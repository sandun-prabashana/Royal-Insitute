package lk.royalInstitute.hibernate.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.royalInstitute.hibernate.bo.BOFactry;
import lk.royalInstitute.hibernate.bo.custom.CourseBO;
import lk.royalInstitute.hibernate.bo.custom.RegistrationBO;
import lk.royalInstitute.hibernate.bo.custom.StudentBO;
import lk.royalInstitute.hibernate.dto.CourseDTO;
import lk.royalInstitute.hibernate.dto.CoustomDTO;
import lk.royalInstitute.hibernate.dto.RegistrationDTO;
import lk.royalInstitute.hibernate.dto.StudentDTO;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class RegistrationFormController implements Initializable {
    public JFXTextField txtSId;
    public JFXTextField txtCId;
    public JFXTextField txtNo;
    public JFXTextField txtDate;
    public JFXTextField txtFee;
    public JFXComboBox cmbSId;
    public JFXButton btnPlace;
    public AnchorPane root;
    @FXML
    private TableView<CoustomDTO> tblReg;

    @FXML
    private TableColumn<CoustomDTO, Integer> clmRegNo;

    @FXML
    private TableColumn<CoustomDTO, String> clmRegDate;

    @FXML
    private TableColumn<CoustomDTO, Double> clmRegFee;

    @FXML
    private TableColumn<CoustomDTO, String> clmSId;

    @FXML
    private TableColumn<CoustomDTO, String> clmCId;

    @FXML
    private TableColumn<CoustomDTO, Button> clmDelete;


    static RegistrationBO registrationBO= (RegistrationBO) BOFactry.getInstance().getBO(BOFactry.BOTypes.REGISTRATION);
    static StudentBO studentBO= (StudentBO) BOFactry.getInstance().getBO(BOFactry.BOTypes.STUDENT);
    static CourseBO courseBO= (CourseBO) BOFactry.getInstance().getBO(BOFactry.BOTypes.COURSE);
    public JFXComboBox cmbCId;
    public JFXTextField txtRFee;

    public void btnOnAction(ActionEvent actionEvent) {
        int regno = Integer.parseInt((txtNo.getText()));
        String date = txtDate.getText();
        Double fee = Double.parseDouble(txtFee.getText());
        String Student_id = txtSId.getText();
        String Course_id=txtCId.getText();

        RegistrationDTO registrationDTO=new RegistrationDTO(regno,date,fee,Student_id,Course_id);
        try {
            boolean deleted = registrationBO.add(registrationDTO);
            if (deleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "OK").showAndWait();
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private void loadAllStudent() {
        try {
            cmbSId.getItems().clear();
            List<StudentDTO> stuList = studentBO.getStudentCombobox();
            for (StudentDTO s : stuList) {
                cmbSId.getItems().add(s.getStudent_ID());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void loadAllCourset() {
        try {
            cmbCId.getItems().clear();
            List<CourseDTO> couList = courseBO.getCourseCombobox();
            for (CourseDTO c : couList) {
                cmbCId.getItems().add(c.getCourse_ID());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cmbSIdOnAction(ActionEvent actionEvent) {
        searchRegNo();
    }

    public void cmbCIdOnAction(ActionEvent actionEvent) {
        String CouId=cmbCId.getSelectionModel().getSelectedItem().toString();;

        try{
            CourseDTO courseDTO=courseBO.searchFee(CouId);
            if(courseDTO!=null){
                txtRFee.setText(String.valueOf(courseDTO.getFee()));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadAllStudent();
        loadAllCourset();

        txtDate.setText(LocalDate.now().toString());
        btnPlace.setDisable(true);

        getRegId();
        txtNo.setDisable(true);


    }

    public void btnAddOnAction(ActionEvent actionEvent) {

        int regno = Integer.parseInt(txtNo.getText());
        String regdate = txtDate.getText();
        double fee = Double.parseDouble(txtRFee.getText());
        String stuId = cmbSId.getSelectionModel().getSelectedItem().toString();
        String couId = cmbCId.getSelectionModel().getSelectedItem().toString();
        Button btnDelete = new Button("Delete");
        ;
        btnDelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int no = tblReg.getSelectionModel().getSelectedIndex();
                tblReg.getItems().remove(no);
            }
        });
        tblReg.getItems().add(new CoustomDTO(regno, regdate, fee, stuId, couId, btnDelete));
        setRegistrationValues();
        btnPlace.setDisable(false);
    }

        public void setRegistrationValues(){
            clmRegNo.setCellValueFactory(new PropertyValueFactory<CoustomDTO, Integer>("Reg_No"));
            clmRegDate.setCellValueFactory(new PropertyValueFactory<CoustomDTO, String>("date"));
            clmRegFee.setCellValueFactory(new PropertyValueFactory<CoustomDTO, Double>("fee"));
            clmSId.setCellValueFactory(new PropertyValueFactory<CoustomDTO, String>("SId"));
            clmCId.setCellValueFactory(new PropertyValueFactory<CoustomDTO, String>("CId"));
            clmDelete.setCellValueFactory(new PropertyValueFactory<CoustomDTO, Button>("button"));
        }

    public void btnRegOnAction(ActionEvent actionEvent) {
//        CustomerDTO customer = new CustomerDTO(txtCID.getText(), txtName.getText(), txtAddress.getText());
//        OrdersDTO order = new OrdersDTO(generateOrderId(), LocalDate.now().toString(), txtCID.getText());

        List<RegistrationDTO> registationLIst = new ArrayList<>();
        for (int i = 0; i < tblReg.getItems().size(); i++) {
            int regno= Integer.parseInt(txtNo.getText());
            String date=txtDate.getText();
            double fee = tblReg.getItems().get(i).getFee();
            String stuId=cmbSId.getSelectionModel().getSelectedItem().toString();
            String CouId = tblReg.getItems().get(i).getCId();
            registationLIst.add(new RegistrationDTO(regno,date,fee,stuId,CouId));
        }

        try {
            registrationBO.placeRegistration(registationLIst);
            new Alert(Alert.AlertType.CONFIRMATION, "Order placed!", ButtonType.OK).show();
            tblReg.getItems().clear();

        } catch (Exception e) {
//            e.printStackTrace();
            new Alert(Alert.AlertType.CONFIRMATION, "error", ButtonType.OK).show();
        }
    }
    public void getRegId(){
        String s = null;
        try {
            s = registrationBO.newRegID();
        } catch (Exception e) {
            e.printStackTrace();
        }
        txtNo.setText(s);
    }

    public void searchRegNo() {
        String stuId = cmbSId.getSelectionModel().getSelectedItem().toString();

        String s = null;
        try {
            s = registrationBO.newRegNo(stuId);
        } catch (Exception e) {
            getRegId();
        }
        if (s!=null) {
            txtNo.setText(s);
        } else {
            getRegId();
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
