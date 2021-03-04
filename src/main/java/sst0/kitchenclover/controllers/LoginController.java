/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sst0.kitchenclover.controllers;

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
import sst0.kitchenclover.config.StageManager;
import sst0.kitchenclover.views.FxmlView;

/**
 * FXML Controller class
 *
 * @author Miles
 */
@Controller
public class LoginController implements Initializable {

    @Lazy
    @Autowired
    private StageManager stageManager;
    @FXML
    private TextField adminField;
    @FXML
    private Button btnLogIn;
    @FXML
    private Button btnUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnLogIn(ActionEvent event) {
        stageManager.switchScene(FxmlView.CATERING);
    }

    @FXML
    private void btnUser(ActionEvent event) {
        stageManager.switchScene(FxmlView.ADMIN);
    }

}
