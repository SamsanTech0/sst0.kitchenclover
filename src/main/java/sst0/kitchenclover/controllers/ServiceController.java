package sst0.kitchenclover.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import sst0.kitchenclover.config.StageManager;
import sst0.kitchenclover.views.FxmlView;
import javafx.fxml.Initializable;

@Controller
public class ServiceController implements Initializable {

    @Lazy
    @Autowired
    private StageManager stageManager;
    
    @FXML
    private Button btnTrays;
    @FXML
    private RadioButton rbntTp;
    @FXML
    private RadioButton rbtnDt;
    @FXML
    private Button btnBuffet;
    @FXML
    private RadioButton rbtnUs;
    @FXML
    private RadioButton rbtnvs;
    @FXML
    private RadioButton rbtnTbc;
    @FXML
    private RadioButton rbtnSs;
    @FXML
    private Button btnRentals;
    @FXML
    private RadioButton rbtnBirth;
    @FXML
    private RadioButton rbtnWed;
    @FXML
    private RadioButton rbtnReunion;
    @FXML
    private TextField others;
    @FXML
    private Button btnCheck;
    @FXML
    private TextField pork;
    @FXML
    private Label chicken;
    @FXML
    private TextField chopsuey;
    @FXML
    private TextField stew;
    @FXML
    private TextField fish;
    @FXML
    private TextField salmon;
    @FXML
    private TextField seafood;
    @FXML
    private TextField sausage;
    @FXML
    private Button btnSHome;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

//    @FXML
//    private void btnTrays(ActionEvent event) {
//    }
//
//    @FXML
//    private void rbntTp(ActionEvent event) {
//    }
//
//    @FXML
//    private void rbtnDt(ActionEvent event) {
//    }
//
//    @FXML
//    private void btnBuffet(ActionEvent event) {
//    }
//
//    @FXML
//    private void rbtnvs(ActionEvent event) {
//    }
//
//    @FXML
//    private void rbtnTbc(ActionEvent event) {
//    }
//
//    @FXML
//    private void rbtnSs(ActionEvent event) {
//    }
//
//    @FXML
//    private void btnRentals(ActionEvent event) {
//    }
//
//    @FXML
//    private void rbtnBirth(ActionEvent event) {
//    }
//
//    @FXML
//    private void rbtnWed(ActionEvent event) {
//    }
//
//    @FXML
//    private void rbtnReunion(ActionEvent event) {
//    }

    @FXML
    void btnCheck(ActionEvent event) {
        stageManager.switchScene(FxmlView.RECEIPT);
    }
    @FXML
    void btnSHome(ActionEvent event) {
        stageManager.switchScene(FxmlView.LOGIN);
    }

}
