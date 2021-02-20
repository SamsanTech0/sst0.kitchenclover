package sst0.kitchenclover.controllers;

import sst0.kitchenclover.config.StageManager;
import sst0.kitchenclover.views.FxmlView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController implements Initializable {

    @Lazy
    @Autowired
    private StageManager stageManager;
    @FXML
    private TextField loginUsn;
    @FXML
    private TextField loginPass;
    @FXML
    private Button btnAvail;
    @FXML
    private Button btnLogIn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnAvail(ActionEvent event) {
        stageManager.switchScene(FxmlView.SERVICE);
    }

    @FXML
    private void btnLogIn(ActionEvent event) {
        stageManager.switchScene(FxmlView.TABLE);

    }

}
