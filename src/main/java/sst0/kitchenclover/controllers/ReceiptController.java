package sst0.kitchenclover.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import sst0.kitchenclover.config.StageManager;
import sst0.kitchenclover.views.FxmlView;

@Controller
/**
 * FXML Controller class
 *
 * @author Miles
 */
public class ReceiptController implements Initializable {

    @Lazy
    @Autowired
    private StageManager stageManager;

    @FXML
    private Label datePlacedOrder;
    @FXML
    private Label contact;
    @FXML
    private Label Name;
    @FXML
    private Label time;
    @FXML
    private Label event;
    @FXML
    private Label sub;
    @FXML
    private Label ship;
    @FXML
    private Label amount;
    @FXML
    private Button btnRHome;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnRHome(ActionEvent event) {
        stageManager.switchScene(FxmlView.LOGIN);
    }

}
