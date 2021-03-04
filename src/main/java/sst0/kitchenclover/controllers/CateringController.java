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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import sst0.kitchenclover.config.StageManager;
import sst0.kitchenclover.models.Catering;
import sst0.kitchenclover.models.Receipt;
import sst0.kitchenclover.services.impl.CateringService;
import sst0.kitchenclover.services.impl.ReceiptService;
import sst0.kitchenclover.views.FxmlView;

/**
 * FXML Controller class
 *
 * @author Miles
 */
@Controller
public class CateringController implements Initializable {

    @Lazy
    @Autowired
    private StageManager stageManager;
    @FXML
    private Button ctrBack;
    @FXML
    private TextField clientName;
    @FXML
    private TextField contact;
    @FXML
    private TextField time;
    private RadioButton rbtnPickUp;
    private RadioButton rbtnDropOff;
    private RadioButton rbtnDisplay;
    private RadioButton rbtnFullService;
    @FXML
    private TextField location;
    @FXML
    private DatePicker doe;
    @FXML
    private Button btnSubmit;
    @FXML
    private Button btnClear;
    @FXML
    private Button btnDelete;
    private RadioButton rbtnAM;
    private RadioButton rbtnPM;

    @FXML
    private TableView<Catering> cateringTable;
    @FXML
    private TableColumn<Catering, Long> colId;
    @FXML
    private TableColumn<Catering, String> colName;
    @FXML
    private TableColumn<Catering, String> colContact;
    @FXML
    private TableColumn<Catering, String> colDeliver;
    @FXML
    private TableColumn<Catering, LocalDate> colDate;
    @FXML
    private TableColumn<Catering, Long> colTime;
    @FXML
    private TableColumn<Catering, String> colLocation;
    @FXML
    private TableColumn<Catering, Boolean> colEdit;
    @FXML
    private Label cateringId;

    @Autowired
    private CateringService cateringService;

    private ObservableList<Catering> cateringList = FXCollections.observableArrayList();
    
    private ObservableList<String> delimeth = FXCollections.observableArrayList("PickUp", "DropOff", "Display", "FullService");
    
    @FXML
    private Button btnReceipt;
    @FXML
    private ComboBox comboDeliver;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cateringTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        comboDeliver.setItems(delimeth);

        setColumnProperties();
        loadUserDetails();
    }

    @FXML
    private void ctrBack(ActionEvent event) {
        stageManager.switchScene(FxmlView.LOGIN);
    }


    @FXML
    private void btnSubmit(ActionEvent event) {
        if (validate("FullName", getCustomerName(), "([a-zA-Z]{2,30}\\s*)+")
                && validate("Phone Number", getContact(), "([1,2,3,4,5,6,7,8,9,0]{1,30}\\s*)+")
                && validate("Location", getLocation(), "([a-zA-Z]{2,30}\\s*)+")
                && validate("Time", getTime(), "([a-zA-Z,1,2,3,4,5,6,7,8,9,0]{1,30}\\s*)+")
                && emptyValidation("DOE", doe.getEditor().getText().isEmpty())) {
            if (cateringId.getText() == null || "".equals(cateringId.getText())) {
                if (true) {

                    Catering user = new Catering();
                    user.setName(getCustomerName());
                    user.setContact(getContact());
                    user.setTime(getTime());
                    user.setLocation(getLocation());
                    user.setDoe(getDoe());
                    user.setDeliver(getDeliver());
                    
                    Catering newUser = cateringService.save(user);

                    saveAlert(newUser);
                }

            } else {
                Catering user = cateringService.find(Long.parseLong(cateringId.getText()));
                user.setName(getCustomerName());
                user.setContact(getContact());
                user.setTime(getTime());
                user.setLocation(getLocation());
                user.setDoe(getDoe());
                user.setDeliver(getDeliver());

                Catering updatedUser = cateringService.update(user);
                updateAlert(updatedUser);
            }

            clearFields();
            loadUserDetails();
        }
    }

    @FXML
    private void btnClear(ActionEvent event) {
        clientName.clear();
        contact.clear();
        time.clear();
        location.clear();
        rbtnPickUp.setSelected(false);
        rbtnDropOff.setSelected(false);
        rbtnDisplay.setSelected(false);
        rbtnFullService.setSelected(false);
        rbtnPickUp.setSelected(false);
        rbtnDropOff.setSelected(false);
        rbtnDisplay.setSelected(false);
        rbtnFullService.setSelected(false);
        rbtnPickUp.setSelected(false);
        rbtnDropOff.setSelected(false);
        rbtnDisplay.setSelected(false);
        rbtnFullService.setSelected(false);
        rbtnPickUp.setSelected(false);
        rbtnDropOff.setSelected(false);
        rbtnDisplay.setSelected(false);
        rbtnFullService.setSelected(false);
        rbtnAM.setSelected(false);
        rbtnPM.setSelected(false);

    }

    @FXML
    private void btnDelete(ActionEvent event) {
        List<Catering> users = cateringTable.getSelectionModel().getSelectedItems();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete the selected user?");
        Optional<ButtonType> action = alert.showAndWait();

        if (action.get() == ButtonType.OK) {
            cateringService.deleteInBatch(users);
        }

        loadUserDetails();
    }

    private void btnRecord(ActionEvent event) {
        stageManager.switchScene(FxmlView.RECEIPT);
    }

    private void setColumnProperties() {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("doe"));
        colDeliver.setCellValueFactory(new PropertyValueFactory<>("deliver"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        colLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colEdit.setCellFactory(cellFactory);
    }
    Callback<TableColumn<Catering, Boolean>, TableCell<Catering, Boolean>> cellFactory
            = new Callback<TableColumn<Catering, Boolean>, TableCell<Catering, Boolean>>() {
        @Override
        public TableCell<Catering, Boolean> call(final TableColumn<Catering, Boolean> param) {
            final TableCell<Catering, Boolean> cell = new TableCell<Catering, Boolean>() {
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
                            Catering user = getTableView().getItems().get(getIndex());
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

                private void updateUser(Catering user) {
                    cateringId.setText(Long.toString(user.getId()));
                    clientName.setText(user.getName());
                }
            };
            return cell;
        }
    };

    private void loadUserDetails() {
        cateringList.clear();
        cateringList.addAll(cateringService.findAll());
        cateringTable.setItems(cateringList);
    }

    private boolean emptyValidation(String field, boolean empty) {
        if (!empty) {
            return true;
        } else {
            validationAlert(field, true);
            return false;
        }
    }

    private String getCustomerName() {
        return clientName.getText();
    }

    private String getContact() {
        return contact.getText();
    }

    private LocalDate getDoe() {
        return doe.getValue();
    }

    private String getTime() {
        return time.getText();
    }

    public String getPeriod() {
        return rbtnAM.isSelected() ? "AM" : "PM";
    }

    

     private void saveAlert(Catering newUser) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("User saved successfully.");
        alert.setHeaderText(null);
        alert.setContentText("User " + newUser.getName() + " has been created with ID number " + newUser.getId() + ".");
        alert.showAndWait();
        loadUserDetails();
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

    private String getLocation() {
        return location.getText();
    }

    private void updateAlert(Catering updatedUser) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("User updated successfully.");
        alert.setHeaderText(null);
        alert.setContentText("User " + updatedUser.getName() + " has been updated.");
        alert.showAndWait();
    }

    private void clearFields() {
        clientName.clear();
        contact.clear();
        time.clear();
        location.clear();
        doe.getEditor().clear();

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

    @FXML
    private void btnReceipt(ActionEvent event) {
        stageManager.switchScene(FxmlView.RECEIPT);
    }

    @FXML
    private void comboDeliver(ActionEvent event) {
    }

    public String getDeliver() {
        return comboDeliver.getSelectionModel().getSelectedItem().toString();
    }

    
}
