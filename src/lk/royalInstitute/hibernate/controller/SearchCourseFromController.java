package lk.royalInstitute.hibernate.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.royalInstitute.hibernate.bo.BOFactry;
import lk.royalInstitute.hibernate.bo.custom.SearchBO;
import lk.royalInstitute.hibernate.bo.custom.StudentBO;
import lk.royalInstitute.hibernate.dto.CourseDTO;
import lk.royalInstitute.hibernate.dto.CoustomDTO;
import lk.royalInstitute.hibernate.dto.StudentDTO;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SearchCourseFromController implements Initializable {
    public JFXComboBox cmbSId;
    static StudentBO studentBO= (StudentBO) BOFactry.getInstance().getBO(BOFactry.BOTypes.STUDENT);

    static SearchBO searchBO= (SearchBO) BOFactry.getInstance().getBO(BOFactry.BOTypes.SEARCH);
    @FXML
    private TableView<CoustomDTO> tblDetail;

    @FXML
    private TableColumn<CoustomDTO,String> clmSname;

    @FXML
    private TableColumn<CoustomDTO,String> clmCid;

    @FXML
    private TableColumn<CoustomDTO,String> clmCname;

    @FXML
    private TableColumn<CoustomDTO, Integer> clmRno;

    @FXML
    private TableColumn<CoustomDTO,String> clmDate;

    @FXML
    private TableColumn<CoustomDTO,Double> clmFee;

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
    public void cmbSIdOnAction(ActionEvent actionEvent) {
        String stuId = cmbSId.getSelectionModel().getSelectedItem().toString();
        try {
            List<CoustomDTO> deatlList = searchBO.getDeatil(stuId);
            ObservableList<CoustomDTO> list = FXCollections.observableArrayList();
            list.addAll(deatlList);
            tblDetail.setItems(list);
            clmSname.setCellValueFactory(new PropertyValueFactory<CoustomDTO,String>("Student_Name"));
            clmCid.setCellValueFactory(new PropertyValueFactory<CoustomDTO,String>("Course_ID"));
            clmCname.setCellValueFactory(new PropertyValueFactory<CoustomDTO, String>("Course_Name"));
            clmRno.setCellValueFactory(new PropertyValueFactory<CoustomDTO, Integer>("Reg_No"));
            clmDate.setCellValueFactory(new PropertyValueFactory<CoustomDTO, String>("Date"));
            clmFee.setCellValueFactory(new PropertyValueFactory<CoustomDTO, Double>("Fee"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadAllStudent();
    }
}
