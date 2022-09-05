package lk.ijse.dep9.clinic.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import lk.ijse.dep9.clinic.misc.CryptoUtil;
import lk.ijse.dep9.clinic.security.SecurityContextHolder;
import lk.ijse.dep9.clinic.security.User;

import java.io.IOException;
import java.sql.*;

public class LoginFormController {

    public JFXTextField txtUsername;
    public JFXTextField txtPassword;
    public JFXButton btnLogin;

    public void initialize(){
        btnLogin.setDefaultButton(true);
    }

    public void btnLoginOnAction(ActionEvent actionEvent) throws ClassNotFoundException, IOException {

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

        Class.forName("com.mysql.cj.jdbc.Driver");

        try(Connection connection = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/medical_clinic", "root", "KPsuneetha@123")){


            //With Regular Statement
            /*String sql =String.format("SELECT role FROM User WHERE username='%s' AND password='%s';",userName,password);

            Statement stm = connection.createStatement();

            ResultSet resultSet = stm.executeQuery(sql);*/


            //With Prepared Statement
            String sql ="SELECT role,password FROM User WHERE username=?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1,userName);
            ResultSet resultSet = stm.executeQuery();

            if (resultSet.next()){
                String cypherText =resultSet.getString("password");
                if (!CryptoUtil.getSha256Hex(password).equals(cypherText)){
                    new Alert(Alert.AlertType.ERROR,"Invalid login credentialsss").show();
                    txtUsername.requestFocus();
                    return;
                }
                String role = resultSet.getString("role");
                SecurityContextHolder.setPrincipal(new User(userName,role));

                Scene scene =null;

                switch (role){
                    case "Admin":
                        scene =new Scene(FXMLLoader.load(this.getClass().getResource("/view/AdminDashboardForm.fxml")));
                        break;
                    case "Doctor":
                        scene =new Scene(FXMLLoader.load(this.getClass().getResource("/view/DoctorDashboardForm.fxml")));
                        break;

                    default:
                        scene =new Scene(FXMLLoader.load(this.getClass().getResource("/view/ReceptionistDashboardForm.fxml")));
                }

                Stage stage = new Stage();
                stage.setTitle("Open Source Medical Clinic");
                stage.setScene(scene);
                stage.show();
                stage.centerOnScreen();

            }else {
                new Alert(Alert.AlertType.ERROR,"Invalid login credentials").show();
                txtUsername.requestFocus();
                return;
            }


        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"Failed to connect with DataBase. Try Again").showAndWait();
            return;
        }
    }
}
