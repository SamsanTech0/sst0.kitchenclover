package sst0.kitchenclover.views;

import java.util.ResourceBundle;

public enum FxmlView {

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
    TABLE {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("Adminpage.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/Adminpage.fxml";
        }
    },
    SERVICE {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("Service.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/Service.fxml";
        }
    },
    AVAIL {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("Catering.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/Catering.fxml";
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
