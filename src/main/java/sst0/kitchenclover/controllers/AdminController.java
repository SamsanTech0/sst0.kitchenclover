package sst0.kitchenclover.controllers;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import sst0.kitchenclover.config.StageManager;
import sst0.kitchenclover.views.FxmlView;
import sst0.kitchenclover.services.impl.AdminService;
import sst0.kitchenclover.models.Admin;

@Controller
public class AdminController implements Initializable {

    @FXML
    private TextField cnuUser;
    @FXML
    private PasswordField cnuPass;
    @FXML
    private Button cnuSave;
    @FXML
    private Button cnuReset;
    @FXML
    private TableColumn<Admin, String> colCnuUsername;
    @FXML
    private TableColumn<Admin, String> colCnuPass;
    @FXML
    private Button cnuBack;
    @FXML
    private Button cnuDelete;
    @FXML
    private TableView<Admin> cnuTable;
    @FXML
    private TableColumn<Admin, Long> colCnuId;
    @FXML
    private TableColumn<Admin, Boolean> colCnuEdit;
    @FXML
    private Label adminId;
    
    @Lazy
    @Autowired
    private StageManager stageManager;
    @Autowired
    private AdminService adminService;

    private ObservableList<Admin> adminList = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cnuTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        setColumnProperties();
        loadUserDetails();
    }

    private void setColumnProperties() {
        colCnuId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colCnuUsername.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colCnuPass.setCellValueFactory(new PropertyValueFactory<>("Pass"));
        colCnuEdit.setCellFactory(cellFactory);
    }
    Callback<TableColumn<Admin, Boolean>, TableCell<Admin, Boolean>> cellFactory
            = new Callback<TableColumn<Admin, Boolean>, TableCell<Admin, Boolean>>() {
        @Override
        public TableCell<Admin, Boolean> call(final TableColumn<Admin, Boolean> param) {
            final TableCell<Admin, Boolean> cell = new TableCell<Admin, Boolean>() {
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
                            Admin user = getTableView().getItems().get(getIndex());
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

                private void updateUser(Admin user) {
                    adminId.setText(Long.toString(user.getId()));
                    cnuUser.setText(user.getName());
                    cnuPass.setText(user.getPass());
                }
            };
            return cell;
        }
    };

    @FXML
    private void cnuSave(ActionEvent event) {

        if (validate("Username", getName(), "([a-zA-Z]{3,30}\\s*)+")
                && validate("Password", getPass(), "([a-zA-Z0-9\"#$%&'()*+,-./:;<=>?@]{8,30}\\s*)+")) {
            if (adminId.getText() == null || "".equals(adminId.getText())) {
                if (true) {

                    Admin user = new Admin();
                    user.setName(getName());
                    user.setPass(getPass());

                    Admin newUser = adminService.save(user);

                    saveAlert(newUser);
                }

            } else {
                Admin user = adminService.find(Long.parseLong(adminId.getText()));
                user.setName(getName());
                user.setPass(getPass());

                Admin updatedUser = adminService.update(user);
                updateAlert(updatedUser);
            }

            clearFields();
            loadUserDetails();
        }
    }

    private void saveAlert(Admin user) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Admin saved successfully.");
        alert.setHeaderText(null);
        alert.setContentText("The admin " + user.getName() + " " + user.getPass() + " has been created and \n" + " id is " + user.getId() + ".");
        alert.showAndWait();
        loadUserDetails();
    }

    public String getName() {
        return cnuUser.getText();
    }

    public String getPass() {
        return cnuPass.getText();
    }

    private boolean validate(String field, String value, String pattern) {
        if (!value.isEmpty()) {
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(value);
            if (m.find() && m.group().equals(value)) {
                return true;
            } else {
                validationAlert(field, true);
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
                alert.setContentText("Please Enter Valid" + field);
            }
        }
        alert.showAndWait();
    }

    private boolean emptyValidation(String field, boolean empty) {
        if (!empty) {
            return true;
        } else {
            validationAlert(field, true);
            return false;
        }
    }

    private void loadUserDetails() {
        adminList.clear();
        adminList.addAll(adminService.findAll());
        cnuTable.setItems(adminList);
    }
//OK    
    private void clearFields() {
        cnuUser.clear();
        cnuPass.clear();
    }
//OK
    private void updateAlert(Admin user) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("The Admin has been successfully updated.");
        alert.setHeaderText(null);
        alert.setContentText("The admin " + user.getName() + " " + user.getPass() + " has been updated.");
        alert.showAndWait();
    }
//cnuResetOK
    @FXML
    private void cnuReset(ActionEvent event) {
        cnuUser.clear();
        cnuPass.clear();
    }
//cnuBack OK
    @FXML
    private void cnuBack(ActionEvent event) {
        stageManager.switchScene(FxmlView.LOGIN);
    }
    @FXML
    void cnuDelete(ActionEvent event){
        List<Admin> users = cnuTable.getSelectionModel().getSelectedItems();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete the selected admin?");
        Optional<ButtonType> action = alert.showAndWait();

        if (action.get() == ButtonType.OK) {
            adminService.deleteInBatch(users);
        }

        loadUserDetails();    
    }

}
