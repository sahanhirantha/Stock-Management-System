package com.hirantha.controllers.admin;

import animatefx.animation.FadeIn;
import com.hirantha.admins.CurrentAdmin;
import com.hirantha.fxmls.FXMLS;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    @FXML
    private HBox topnavbar;

    @FXML
    private Button btnMinimize;


    @FXML
    private Button btnClose;

    @FXML
    private HBox menuCustomers;

    @FXML
    private HBox menuItems;

    @FXML
    private Label txtTitle;

    @FXML
    private HBox menuStocks;

    @FXML
    private HBox menuFinancial;

    @FXML
    private HBox menuOutgoing;

    @FXML
    private HBox menuIncome;

    @FXML
    private HBox menuAdmins;

    @FXML
    private StackPane panesContainer;


    private double x;
    private double y;
    private AnchorPane customersPane;
    private AnchorPane itemsPane;
    private AnchorPane stocksPane;
    private AnchorPane financialPane;
    private AnchorPane currentPane;
    private AnchorPane incomePane;
    private AnchorPane outgoingPane;
    private AnchorPane adminPane;


    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {

        txtTitle.setText(CurrentAdmin.getInstance().getCurrentAdmin().getName() + " @ Werellagama Hardware");

        try {
            FXMLLoader customersFxmlLoader = new FXMLLoader(getClass().getResource(FXMLS.Admin.Customers.CUSTOMER_DASHBOARD));
            FXMLLoader itemsFxmlLoader = new FXMLLoader(getClass().getResource(FXMLS.Admin.Items.ITEMS_DASHBOARD));
            FXMLLoader stocksFxmlLoader = new FXMLLoader(getClass().getResource(FXMLS.Admin.Stocks.STOCKS_DASHBOARD));
            FXMLLoader financialFxmlLoader = new FXMLLoader(getClass().getResource(FXMLS.Admin.Financial.FINANCIAL_DASHBOARD));
            FXMLLoader incomeFxmlLoader = new FXMLLoader(getClass().getResource(FXMLS.Admin.Income.INCOME_DASHBOARD));
            FXMLLoader adminsFxmlLoader = new FXMLLoader(getClass().getResource(FXMLS.Admin.Admins.ADMIN_DASHBOARD));
            FXMLLoader outgoingFxmlLoader = new FXMLLoader(getClass().getResource(FXMLS.Admin.Outgoing.OUTGOING_DASHBOARD));

            customersPane = customersFxmlLoader.load();
            itemsPane = itemsFxmlLoader.load();
            stocksPane = stocksFxmlLoader.load();
            financialPane = financialFxmlLoader.load();
            incomePane = incomeFxmlLoader.load();
            adminPane = adminsFxmlLoader.load();
            outgoingPane = outgoingFxmlLoader.load();

            changePane(customersPane);
        } catch (IOException e) {
            e.printStackTrace();
        }

        topnavbar.setOnMouseClicked(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });


        topnavbar.setOnMouseDragged(e -> {
            Stage stage = (Stage) topnavbar.getScene().getWindow();
            stage.setX(e.getScreenX() - x);
            stage.setY(e.getScreenY() - y);
        });

        btnClose.setOnMouseClicked(e -> btnClose.getScene().getWindow().hide());

        menuCustomers.setOnMouseClicked(event -> changePane(customersPane));

        menuItems.setOnMouseClicked(event -> changePane(itemsPane));

        menuStocks.setOnMouseClicked(event -> changePane(stocksPane));

        menuFinancial.setOnMouseClicked(event -> changePane(financialPane));

        menuIncome.setOnMouseClicked(event -> changePane(incomePane));

        menuAdmins.setOnMouseClicked(event -> changePane(adminPane));

        menuOutgoing.setOnMouseClicked(event -> changePane(outgoingPane));

        btnMinimize.setOnMouseClicked(e -> ((Stage) btnMinimize.getScene().getWindow()).setIconified(true));

    }

    private void changePane(AnchorPane pane) {
        if (!panesContainer.getChildren().contains(pane)) {
            panesContainer.getChildren().add(pane);
            FadeIn animation = new FadeIn(pane);
            animation.setSpeed(3);
            animation.getTimeline().setOnFinished(e -> {
                if (panesContainer.getChildren().size() > 1) panesContainer.getChildren().remove(currentPane);
                currentPane = pane;
            });
            animation.play();

        }
    }

}
