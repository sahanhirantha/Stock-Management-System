package com.hirantha.fxmls;

import org.apache.commons.lang3.StringUtils;

public class FXMLS {
    public static class Admin {
        public static class Customers {
            public static String CUSTOMER_PROFILE = "/com/hirantha/fxmls/admin/customers/customer_profile.fxml";
            public static String NEW_CUSTOMER = "/com/hirantha/fxmls/admin/customers/new_customer.fxml";
            public static String CUSTOMER_ROW = "/com/hirantha/fxmls/admin/customers/customer_row.fxml";
            public static String CUSTOMER_DASHBOARD = "/com/hirantha/fxmls/admin/customers/customers.fxml";
        }

        public static class Items {
            public static String ITEMS_DASHBOARD = "/com/hirantha/fxmls/admin/items/items.fxml";
            public static String ITEM_ROW = "/com/hirantha/fxmls/admin/items/item_row.fxml";
            public static String ITEM_FULL_VIEW = "/com/hirantha/fxmls/admin/items/item_full_view.fxml";
        }

        public static class Stocks {
            public static String STOCKS_DASHBOARD = "/com/hirantha/fxmls/admin/stocks.fxml";
        }

        public static class Financial {
            public static String FINANCIAL_DASHBOARD = "/com/hirantha/fxmls/admin/financial.fxml";

        }
    }

}