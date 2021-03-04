package sst0.kitchenclover.views;

import java.util.ResourceBundle;

/**
 * @author Miles
 */
public enum FxmlView {

    ADMIN {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("Admin.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/Admin.fxml";
        }
    },
    BILL {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("Bill.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/Bill.fxml";
        }
    },
    CATERING {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("Catering.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/Catering.fxml";
        }
    },
    LOGIN {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("Login.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/Login.fxml";
        }
    },
    RECEIPT {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("Receipt.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/Receipt.fxml";
        }
    };

    public abstract String getTitle();

    public abstract String getFxmlFile();

    String getStringFromResourceBundle(String key) {
        return ResourceBundle.getBundle("Bundle").getString(key);
    }

}
