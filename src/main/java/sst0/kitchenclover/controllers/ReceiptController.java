/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sst0.kitchenclover.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Miles
 */
public class ReceiptController implements Initializable {

    @FXML
    private Label datePlacedOrder;
    @FXML
    private Label contact;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
