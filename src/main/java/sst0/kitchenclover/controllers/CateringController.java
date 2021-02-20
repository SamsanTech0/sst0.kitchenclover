/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sst0.kitchenclover.controllers;
import sst0.kitchenclover.config.StageManager;
import sst0.kitchenclover.views.FxmlView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;


@Controller
public class CateringController implements Initializable {

    @Lazy
    @Autowired
    private StageManager stageManager;

    @FXML
    private TextField clientName;
    @FXML
    private TextField contact;
    @FXML
    private TextField time;
    @FXML
    private RadioButton rbtnPickUp;
    @FXML
    private RadioButton rbtnDropOff;
    @FXML
    private RadioButton rbtnDisplay;
    @FXML
    private RadioButton rbtnFullService;
    @FXML
    private TextField location;
    @FXML
    private DatePicker DoE;
    @FXML
    private TextField guestCount;
    @FXML
    private Button btnNext;
    @FXML
    private TextField date;
    @FXML
    private Button btnCHome;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void rbtnPickUp(ActionEvent event) {
    }

    @FXML
    private void rbtnDropOff(ActionEvent event) {
    }

    @FXML
    private void rbtnDisplay(ActionEvent event) {
    }

    @FXML
    private void rbtnFullService(ActionEvent event) {
    }

    @FXML
    void btnNext(ActionEvent event) {
        stageManager.switchScene(FxmlView.SERVICE);
    }

    @FXML
    void btnCHome(ActionEvent event) {
        stageManager.switchScene(FxmlView.LOGIN);
    }

}
