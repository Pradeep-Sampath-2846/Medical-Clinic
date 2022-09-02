package lk.ijse.dep9.clinic.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

public class LoginFormController {

    public JFXTextField txtUsername;
    public JFXTextField txtPassword;
    public JFXButton btnLogin;

    public void initialize(){
        btnLogin.setDefaultButton(true);
    }

    public void btnLoginOnAction(ActionEvent actionEvent) {

        String userName = txtUsername.getText();
        String password = txtPassword.getText();

        if (userName.isBlank()){
            new Alert(Alert.AlertType.ERROR,"Password can't be empty").show();
            txtUsername.requestFocus();
            txtUsername.selectAll();
            return;
        } else if (password.isBlank()) {
            new Alert(Alert.AlertType.ERROR,"Password can't be empty").show();
            txtPassword.requestFocus();
            txtPassword.selectAll();
            return;
        } else if (!userName.matches("^([]a-zA-Z0-9])+\\b")) {
            new Alert(Alert.AlertType.ERROR,"Invalid login credentials").show();
            txtUsername.requestFocus();
            txtUsername.selectAll();
            return;
        }
    }
}
