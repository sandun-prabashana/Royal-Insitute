package lk.royalInstitute.hibernate.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.royalInstitute.hibernate.bo.BOFactry;
import lk.royalInstitute.hibernate.bo.custom.CourseBO;
import lk.royalInstitute.hibernate.bo.custom.StudentBO;
import lk.royalInstitute.hibernate.dto.CourseDTO;
import lk.royalInstitute.hibernate.dto.StudentDTO;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class ManageStudentForm implements Initializable {
    public JFXTextField txtId;
    public JFXTextField txtName;
    public JFXTextField txtDuration;
    public JFXButton btnSave;
    public JFXButton btnDelete;
    public JFXButton btnAdd;
    public JFXTextField txtType;
    public JFXTextField txtAdress;
    public JFXTextField txtContact;
    public JFXTextField txtDOB;
    public JFXComboBox cmbGender;
    public ImageView imghome;
    public AnchorPane root;


    @FXML
    private TableView<StudentDTO> tblStudent;

    @FXML
    private TableColumn<StudentDTO,String> clmId;

    @FXML
    private TableColumn<StudentDTO,String> clmName;

    @FXML
    private TableColumn<StudentDTO,String> clmAddress;

    @FXML
    private TableColumn<StudentDTO,String> clmContact;

    @FXML
    private TableColumn<StudentDTO,Date> clmDOB;

    @FXML
    private TableColumn<StudentDTO,String> clmGender;

    static StudentBO studentBO= (StudentBO) BOFactry.getInstance().getBO(BOFactry.BOTypes.STUDENT);


    public void btnAddOnAction(ActionEvent actionEvent) {
        txtId.setDisable(true);
        txtName.setDisable(false);
        txtAdress.setDisable(false);
        txtContact.setDisable(false);
        txtDOB.setDisable(false);
        cmbGender.setDisable(false);
        btnSave.setText("Save");
        btnDelete.setDisable(true);
        btnSave.setDisable(false);
    }

    public void getID(){
        String s = null;
        try {
            s = studentBO.newStudentID();
        } catch (Exception e) {
            e.printStackTrace();
        }
        txtId.setText(s);
    }
//    public void btnDeleteOnAction(ActionEvent actionEvent) {
//        String id = txtId.getText();
//        String name = txtName.getText();
//        String type= txtType.getText();
//        String duration = txtDuration.getText();
//
//        CourseDTO course = new CourseDTO(id, name,type, duration);
//        try {
//            boolean deleted = courseBO.deleteCourse(course);
//
//            if (deleted) {
//                new Alert(Alert.AlertType.CONFIRMATION, "OK").showAndWait();
//                txtId.setDisable(true);
//                txtName.setDisable(true);
//                txtDuration.setDisable(true);
//                txtType.setDisable(true);
//
//                txtId.setText("CT");
//                txtType.clear();
//                txtName.clear();
//                txtDuration.clear();
//
//                loadTable();
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//    }

    public void btnSaveOnAction(ActionEvent actionEvent) throws ParseException {
        String id = txtId.getText();
        String name = txtName.getText();
        String address= txtAdress.getText();
        String contact = txtContact.getText();
        String str_date=txtDOB.getText();
//        DateFormat format;
//        Date dob;
//        format=new SimpleDateFormat("dd/MM/yyyy");
//        dob=format.parse(str_date);
        String dob=txtDOB.getText();
        String gender=cmbGender.getSelectionModel().getSelectedItem().toString();

        StudentDTO student = new StudentDTO(id, name,address,contact,dob,gender);

        if (btnSave.getText().equals("Save")) {
            try {
                boolean added = studentBO.addStudent(student);

                if (added) {
                    new Alert(Alert.AlertType.CONFIRMATION, "OK").showAndWait();

                    getID();
                    loadTable();

                    txtId.setDisable(true);
                    txtName.setDisable(true);
                    txtAdress.setDisable(true);
                    txtContact.setDisable(true);
                    txtDOB.setDisable(true);
                    cmbGender.setDisable(true);

                    txtName.clear();
                    txtAdress.clear();
                    txtContact.clear();
                    txtDOB.clear();
                    cmbGender.getItems().clear();
                    btnSave.setDisable(true);


                }else {
                    new Alert(Alert.AlertType.WARNING, "Fail").showAndWait();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }if (btnSave.getText().equals("Update")) {
            try {
                boolean added = studentBO.updateStudent(student);

                if (added) {
                    new Alert(Alert.AlertType.CONFIRMATION, "OK").showAndWait();

                    getID();
                    loadTable();

                    txtId.setDisable(true);
                    txtName.setDisable(true);
                    txtAdress.setDisable(true);
                    txtContact.setDisable(true);
                    txtDOB.setDisable(true);
                    cmbGender.setDisable(true);


                    txtName.clear();
                    txtAdress.clear();
                    txtContact.clear();
                    txtDOB.clear();
                    cmbGender.getItems().clear();
                    btnSave.setDisable(true);

                }else {
                    new Alert(Alert.AlertType.WARNING, "Fail").showAndWait();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        }

    public void loadTable() {
        try {
            List<StudentDTO> stuList = studentBO.getStudent();
            ObservableList<StudentDTO> list = FXCollections.observableArrayList();
            list.addAll(stuList);
            tblStudent.setItems(list);
            clmId.setCellValueFactory(new PropertyValueFactory<StudentDTO,String>("Student_ID"));
            clmName.setCellValueFactory(new PropertyValueFactory<StudentDTO, String>("Student_Name"));
            clmAddress.setCellValueFactory(new PropertyValueFactory<StudentDTO, String>("Address"));
            clmContact.setCellValueFactory(new PropertyValueFactory<StudentDTO, String>("Contact"));
            clmDOB.setCellValueFactory(new PropertyValueFactory<StudentDTO, Date>("DOB"));
            clmGender.setCellValueFactory(new PropertyValueFactory<StudentDTO, String>("Gender"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        getID();
        loadTable();

        cmbGender.getItems().clear();
        cmbGender.getItems().add("Male");
        cmbGender.getItems().add("Female");

        txtId.setDisable(true);
        txtName.setDisable(true);
        txtAdress.setDisable(true);
        txtContact.setDisable(true);
        txtDOB.setDisable(true);
        cmbGender.setDisable(true);


        btnSave.setDisable(true);
        btnDelete.setDisable(true);


        tblStudent.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<StudentDTO>() {
            @Override
            public void changed(ObservableValue<? extends StudentDTO> observable, StudentDTO oldValue, StudentDTO newValue) {
                StudentDTO selectedItem = tblStudent.getSelectionModel().getSelectedItem();

                if (selectedItem == null) {
                    btnSave.setText("Save");
                    btnDelete.setDisable(true);
                    txtName.clear();
                    txtAdress.clear();
                    txtContact.clear();
                    txtDOB.clear();
                    cmbGender.getItems().clear();
                    return;
                }

                btnSave.setText("Update");
                btnSave.setDisable(false);
                btnDelete.setDisable(false);
                txtId.setDisable(true);
                txtName.setDisable(false);
                txtAdress.setDisable(false);
                txtContact.setDisable(false);
                txtDOB.setDisable(false);
                cmbGender.setDisable(false);

                txtId.setText(selectedItem.getStudent_ID());
                txtName.setText(selectedItem.getStudent_Name());
                txtAdress.setText(selectedItem.getAddress());
                txtContact.setText(selectedItem.getContact());
                txtDOB.setText(String.valueOf(selectedItem.getDOB()));

                cmbGender.getItems().clear();
                cmbGender.getItems().add("Male");
                cmbGender.getItems().add("Female");
            }
        });
    }

//    public void btnSaveOnAction(ActionEvent actionEvent) {
//    }

    public void btnDeleteOnAction(ActionEvent actionEvent) throws ParseException {
        String id = txtId.getText();
        String name = txtName.getText();
        String address= txtAdress.getText();
        String contact = txtContact.getText();
        String str_date=txtDOB.getText();
//        DateFormat format;
//        Date dob;
//        format=new SimpleDateFormat("dd/MM/yyyy");
//        dob=format.parse(str_date);
        String dob=txtDOB.getText();
        String gender=cmbGender.getSelectionModel().getSelectedItem().toString();

        StudentDTO student = new StudentDTO(id, name,address,contact,dob,gender);
        try {
            boolean delete = studentBO.deleteStudent(student);

            if (delete) {
                new Alert(Alert.AlertType.CONFIRMATION, "OK").showAndWait();

                getID();
                loadTable();

                txtId.setDisable(true);
                txtName.setDisable(true);
                txtAdress.setDisable(true);
                txtContact.setDisable(true);
                txtDOB.setDisable(true);
                cmbGender.setDisable(true);

                txtName.clear();
                txtAdress.clear();
                txtContact.clear();
                txtDOB.clear();
                btnSave.setDisable(true);
//                cmbGender.getItems().clear();

            }else {
                new Alert(Alert.AlertType.WARNING, "Fail").showAndWait();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void imghomeOnAction(MouseEvent mouseEvent) throws IOException {
        URL resource = this.getClass().getResource("/lk/royalInstitute/hibernate/view/MainForm.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.root.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
    }
}
