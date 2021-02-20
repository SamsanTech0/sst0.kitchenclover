package sst0.kitchenclover.views;

import java.util.ResourceBundle;

public enum FxmlView {

    LOGIN {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("login.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/login.fxml";
        }
    },
    TABLE {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("adminpage.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/adminpage.fxml";
        }
    },
    SERVICE {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("service.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/service.fxml";
        }
    };

    public abstract String getTitle();

    public abstract String getFxmlFile();

    String getStringFromResourceBundle(String key) {
        return ResourceBundle.getBundle("Bundle").getString(key);
    }

}
