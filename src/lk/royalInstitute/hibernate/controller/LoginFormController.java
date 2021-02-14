package lk.royalInstitute.hibernate.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginFormController implements Initializable {
    public JFXPasswordField txtPassword;
    public JFXCheckBox bxShow;
    public static final PasswordField txtPassword1 = null;
    public TextField pass_text;
    public PasswordField pass_hidden;
    public JFXButton btneye;
    public ImageView example;
    public JFXButton btnCancel;
    public JFXButton btnLogin;
    public TextField txtName;
    public AnchorPane root;

    public void bxShowOnAction(ActionEvent actionEvent) {
        if (bxShow.isSelected()){
            pass_text.setText(pass_hidden.getText());
            pass_text.setVisible(true);
            pass_hidden.setVisible(false);
            return;
        }
        pass_hidden.setText(pass_text.getText());
        pass_hidden.setVisible(true);
        pass_text.setVisible(false);
    }

    public void btnprint(ActionEvent actionEvent) {
        System.out.println(pass_text.getText());
        System.out.println("passs"+pass_hidden.getText());
    }

    public void btnLoginOnAction(ActionEvent actionEvent) {
        String name=txtName.getText();
        String password=pass_hidden.getText();

        try {
            if (name.length()>0 && password.length()>0){
                    if (name.equals("ijse") && password.equals("1234")){
                        Stage window = (Stage) this.root.getScene().getWindow();
                        window.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/lk/royalInstitute/hibernate/view/MainForm.fxml"))));
                        window.centerOnScreen();
                        window.show();
                    }else{
                        new Alert(Alert.AlertType.WARNING, "Try Again!",
                                ButtonType.OK).show();
                    }
            }else{
                new Alert(Alert.AlertType.WARNING, "User Id Or Password Empty!",
                        ButtonType.OK).show();
            }
        } catch  (IOException e) {
            e.printStackTrace();
        }

    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtName.requestFocus();
    }
}
