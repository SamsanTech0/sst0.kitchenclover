package sst0.kitchenclover.controllers;

import sst0.kitchenclover.config.StageManager;
import sst0.kitchenclover.views.FxmlView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
public class AdminpageController implements Initializable {

    @Lazy
    @Autowired
    private StageManager stageManager;
    @FXML
    private Button btnBack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    void btnBack(ActionEvent event) {
        stageManager.switchScene(FxmlView.LOGIN);

    }

}
