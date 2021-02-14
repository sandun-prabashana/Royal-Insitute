package lk.royalInstitute.hibernate.controller;

import com.jfoenix.controls.JFXButton;
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
import lk.royalInstitute.hibernate.bo.custom.RegistrationBO;
import lk.royalInstitute.hibernate.dto.CourseDTO;
import lk.royalInstitute.hibernate.dto.RegistrationDTO;
import lk.royalInstitute.hibernate.entity.Course;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static sun.net.www.MimeTable.loadTable;

public class ManageCourseForm implements Initializable {
    public JFXTextField txtId;
    public JFXTextField txtName;
    public JFXTextField txtDuration;
    public JFXButton btnSave;
    public JFXButton btnDelete;
    public JFXButton btnAdd;
    public JFXTextField txtType;
    public ImageView imghome;
    public AnchorPane root;
    @FXML
    private TableView<CourseDTO> tblCourse;

    @FXML
    private TableColumn<CourseDTO,String> clmId;

    @FXML
    private TableColumn<CourseDTO,String> clmName;

    @FXML
    private TableColumn<CourseDTO,String> clmType;

    @FXML
    private TableColumn<CourseDTO,String> clmDuration;

    static CourseBO courseBO= (CourseBO) BOFactry.getInstance().getBO(BOFactry.BOTypes.COURSE);
    static RegistrationBO registrationBO= (RegistrationBO) BOFactry.getInstance().getBO(BOFactry.BOTypes.REGISTRATION);


    public void btnAddOnAction(ActionEvent actionEvent) {
        txtId.setText("CT");
        txtId.setDisable(false);
        txtName.setDisable(false);
        txtDuration.setDisable(false);
        txtType.setDisable(false);
        btnSave.setText("Save");
        btnDelete.setDisable(true);
        btnSave.setDisable(false);
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String id = txtId.getText();
        String name = txtName.getText();
        Double fee= Double.parseDouble(txtType.getText());
        String duration = txtDuration.getText();

        CourseDTO course = new CourseDTO(id, name,fee, duration);
        try {
            boolean deleted = courseBO.deleteCourse(course);

            if (deleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "OK").showAndWait();
                txtId.setDisable(true);
                txtName.setDisable(true);
                txtDuration.setDisable(true);
                txtType.setDisable(true);

                txtId.setText("CT");
                txtType.clear();
                txtName.clear();
                txtDuration.clear();

                loadTable();
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
//        getReg();
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        String id = txtId.getText();
        String name = txtName.getText();
        Double fee= Double.parseDouble(txtType.getText());
        String duration = txtDuration.getText();

        CourseDTO course = new CourseDTO(id, name,fee,duration);

        if (btnSave.getText().equals("Save")) {
            try {
                boolean added = courseBO.addCourse(course);

                if (added) {
                    new Alert(Alert.AlertType.CONFIRMATION, "OK").showAndWait();
                    txtId.setDisable(true);
                    txtName.setDisable(true);
                    txtDuration.setDisable(true);
                    txtType.setDisable(true);

                    txtId.setText("CT");
                    txtType.clear();
                    txtName.clear();
                    txtDuration.clear();

                    loadTable();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }if (btnSave.getText().equals("Update")) {
            try {
                boolean added = courseBO.updateCourse(course);

                if (added) {
                    new Alert(Alert.AlertType.CONFIRMATION, "OK").showAndWait();
                    txtId.setDisable(true);
                    txtName.setDisable(true);
                    txtDuration.setDisable(true);
                    txtType.setDisable(true);

                    txtId.setText("CT");
                    txtType.clear();
                    txtName.clear();
                    txtDuration.clear();

                    loadTable();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        }

    public void loadTable() {
        try {
            List<CourseDTO> cusList = courseBO.getCourse();
            ObservableList<CourseDTO> list = FXCollections.observableArrayList();
            list.addAll(cusList);
            tblCourse.setItems(list);
            clmId.setCellValueFactory(new PropertyValueFactory<CourseDTO, String>("Course_ID"));
            clmName.setCellValueFactory(new PropertyValueFactory<CourseDTO, String>("Course_Name"));
            clmType.setCellValueFactory(new PropertyValueFactory<CourseDTO, String>("Fee"));
            clmDuration.setCellValueFactory(new PropertyValueFactory<CourseDTO, String>("Duration"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtId.setDisable(true);
        txtName.setDisable(true);
        txtDuration.setDisable(true);
        txtType.setDisable(true);


        btnSave.setDisable(true);
        btnDelete.setDisable(true);

        loadTable();

        tblCourse.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<CourseDTO>() {
            @Override
            public void changed(ObservableValue<? extends CourseDTO> observable, CourseDTO oldValue, CourseDTO newValue) {
                CourseDTO selectedItem = tblCourse.getSelectionModel().getSelectedItem();

                if (selectedItem == null) {
                    btnSave.setText("Save");
                    btnDelete.setDisable(true);
                    txtDuration.clear();
                    txtType.clear();
                    txtName.clear();
                    txtId.setText("CT");
                    return;
                }

                btnSave.setText("Update");
                btnSave.setDisable(false);
                btnDelete.setDisable(false);
                txtType.setDisable(false);
                txtName.setDisable(false);
                txtId.setDisable(false);
                txtDuration.setDisable(false);
                txtId.setText(selectedItem.getCourse_ID());
                txtName.setText(selectedItem.getCourse_Name());
                txtType.setText(selectedItem.getFee()+ "");
                txtDuration.setText(selectedItem.getDuration());


            }
        });
    }

    public void imghomeOnAction(MouseEvent mouseEvent) throws IOException {
        URL resource = this.getClass().getResource("/lk/royalInstitute/hibernate/view/MainForm.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.root.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
    }

    public void getReg(){
        try {
            String id=txtId.getText();
            List<RegistrationDTO> couList = registrationBO.getReg(id);
            for (RegistrationDTO c : couList) {
                System.out.println(c.getStudent_ID());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
