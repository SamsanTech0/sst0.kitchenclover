package sst0.kitchenclover.controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import sst0.kitchenclover.config.StageManager;
import sst0.kitchenclover.models.Receipt;
import sst0.kitchenclover.models.Receipt;
import sst0.kitchenclover.views.FxmlView;
import sst0.kitchenclover.services.impl.ReceiptService;
/**
 * FXML Controller class
 *
 * @author Miles
 */
@Controller
public class ReceiptController implements Initializable {

    @Lazy
    @Autowired
    private StageManager stageManager;
    @Autowired
    private ReceiptService receiptService;
    
    private ObservableList<Receipt> receiptList = FXCollections.observableArrayList();

    @FXML
    private TextField textName;
    @FXML
    private TextField textDelivery;
    @FXML
    private TextField textGuest;
    @FXML
    private TextField textContact;
    @FXML
    private TextField textTime;
    @FXML
    private TextField textLocation;
    @FXML
    private TableColumn<Receipt, String> colName;
    @FXML
    private TableColumn<Receipt, String> colContact;
    @FXML
    private TableColumn<Receipt, String> colGuest;
    @FXML
    private TableColumn<Receipt, LocalDate> colDoe;
    @FXML
    private TableColumn<Receipt, String> colDelivery;
    @FXML
    private TableColumn<Receipt, String> colTime;
    @FXML
    private TableColumn<Receipt, String> colLocation;
    @FXML
    private TableColumn<Receipt, Boolean> colEdit;
    @FXML
    private TableColumn<Receipt, Long> colId;
    @FXML
    private DatePicker rcptDoe;
    @FXML
    private Button rcptBack;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnReset;
    @FXML
    private Button btnDelete;
    @FXML
    private Label clientId;
    @FXML
    private TableView<Receipt> receiptTable;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        receiptTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        setColumnProperties();
        loadUserDetails();    
    }

    @FXML
    private void rcptBack(ActionEvent event) {
        stageManager.switchScene(FxmlView.CATERING);
    }

    @FXML
    private void btnSave(ActionEvent event) {
        if (validate("Name", getName(), "([a-zA-Z]{3,30}\\s*)+")
                && validate("Contact #", getContact(), "([0-9\"#'()*+,-./:;<=>?@]{3,30}\\s*)+")
                && validate("# of Guests", getGuest(), "([1,2,3,4,5,6,7,8,9,0]{1,30}\\s*)+")
                && validate("Delivery Method", getDelivery(), "([a-zA-Z]{3,30}\\s*)+")            
                && emptyValidation("Date of Event", rcptDoe.getEditor().getText().isEmpty())        
                && validate("Time", getTime(), "([a-zA-Z,1,2,3,4,5,6,7,8,9,0]{1,30}\\s*)+")     
                && validate("Event Location", getLocation(), "([a-zA-Z]{3,30}\\s*)+"))        {
        
            if (clientId.getText() == null || "".equals(clientId.getText())) {
                if (true) {

                    Receipt user = new Receipt();
                    user.setName(getName());
                    user.setContact(getContact());
                    user.setGuest(getGuest());
                    user.setDelivery(getDelivery());
                    user.setTime(getTime());
                    user.setLocation(getLocation());
                    user.setDoe(getDoe());


                    Receipt newUser = receiptService.save(user);

                    saveAlert(newUser);
                }

            } else {
                Receipt user = receiptService.find(Long.parseLong(clientId.getText()));
                user.setName(getName());
                user.setContact(getContact());
                user.setGuest(getGuest());
                user.setDelivery(getDelivery());
                user.setTime(getTime());
                user.setLocation(getLocation());
                user.setDoe(getDoe());

                Receipt updatedUser = receiptService.update(user);
                updateAlert(updatedUser);
            }

            clearFields();
            loadUserDetails();
        }
    }
    
    private void saveAlert(Receipt user) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("User saved successfully.");
        alert.setHeaderText(null);
        alert.setContentText("The client " + user.getName() +  " has been created and \n" + " id is " + user.getId() + ".");
        alert.showAndWait();
        loadUserDetails();
    }
    
    private void updateAlert(Receipt user) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Client updated successfully.");
        alert.setHeaderText(null);
        alert.setContentText("The client " + user.getName() + " has been updated.");
        alert.showAndWait();
    }
    
    private boolean validate(String field, String value, String pattern) {
        if (!value.isEmpty()) {
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(value);
            if (m.find() && m.group().equals(value)) {
                return true;
            } else {
                validationAlert(field, false);
                return false;
            }
        } else {
            validationAlert(field, true);
            return false;
        }
    }
    
    private void validationAlert(String field, boolean empty) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Validation Error");
        alert.setHeaderText(null);
        if (field.equals("Role")) {
            alert.setContentText("Please Select " + field);
        } else {
            if (empty) {
                alert.setContentText("Please Enter " + field);
            } else {
                alert.setContentText("Please Enter Valid " + field);
            }
        }
        alert.showAndWait();
    }
    
    private void clearFields() {
        textName.clear();
        textDelivery.clear();
        textGuest.clear();
        textContact.clear();
        textTime.clear();
        textLocation.clear();
        rcptDoe.getEditor().clear();
    }
        

    @FXML
    void btnReset(ActionEvent event) {
        textName.clear();
        textDelivery.clear();
        textGuest.clear();
        textContact.clear();
        textTime.clear();
        textLocation.clear();
        rcptDoe.getEditor().clear();
    }
    
    private void loadUserDetails(){
        receiptList.clear();
        receiptList.addAll(receiptService.findAll());
        receiptTable.setItems(receiptList);
    }

    @FXML
    private void btnDelete(ActionEvent event) {
    List<Receipt> users = receiptTable.getSelectionModel().getSelectedItems();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete the selected user?");
        Optional<ButtonType> action = alert.showAndWait();

        if (action.get() == ButtonType.OK) {
            receiptService.deleteInBatch(users);
        }

        loadUserDetails();
    }

    public String getName() {
        return textName.getText();
    }

    public String getContact() {
        return textContact.getText();
    }

    public String getGuest() {
        return textGuest.getText();
    }

    public String getDelivery() {
        return textDelivery.getText();
    }

    public LocalDate getDoe()  {
        return rcptDoe.getValue();
    }

    public String getTime() {
        return textTime.getText();
    }

    public String getLocation() {
        return textLocation.getText();
    }

    private boolean emptyValidation(String field, boolean empty) {
        if (!empty) {
            return true;
        } else {
            validationAlert(field, true);
            return false;
        }
    }

    private void setColumnProperties() {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colGuest.setCellValueFactory(new PropertyValueFactory<>("guest"));
        colDoe.setCellValueFactory(new PropertyValueFactory<>("doe"));
        colDelivery.setCellValueFactory(new PropertyValueFactory<>("delivery"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        colLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colEdit.setCellFactory(cellFactory);
    }
    Callback<TableColumn<Receipt, Boolean>, TableCell<Receipt, Boolean>> cellFactory
            = new Callback<TableColumn<Receipt, Boolean>, TableCell<Receipt, Boolean>>() {
        @Override
        public TableCell<Receipt, Boolean> call(final TableColumn<Receipt, Boolean> param) {
            final TableCell<Receipt, Boolean> cell = new TableCell<Receipt, Boolean>() {
                Image imgEdit = new Image(getClass().getResourceAsStream("/images/edit.png"));
                final Button btnEdit = new Button();

                @Override
                public void updateItem(Boolean check, boolean empty) {
                    super.updateItem(check, empty);
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        btnEdit.setOnAction(e -> {
                            Receipt user = getTableView().getItems().get(getIndex());
                            updateUser(user);
                        });

                        btnEdit.setStyle("-fx-background-color: transparent;");
                        ImageView iv = new ImageView();
                        iv.setImage(imgEdit);
                        iv.setPreserveRatio(true);
                        iv.setSmooth(true);
                        iv.setCache(true);
                        btnEdit.setGraphic(iv);

                        setGraphic(btnEdit);
                        setAlignment(Pos.CENTER);
                        setText(null);
                    }
                }

                private void updateUser(Receipt user) {
                    clientId.setText(Long.toString(user.getId()));
                    textName.setText(user.getName());
                }
            };
            return cell;
        }
    };

}
