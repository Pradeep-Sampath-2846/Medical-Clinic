package lk.ijse.dep9.clinic.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class AdminDashboardFormController {
    public JFXButton btnProfileManagement;
    public JFXButton btnViewRecords;
    public JFXButton btnSettings;
    public JFXButton btnLogout;

    public void btnProfileManagementOnAction(ActionEvent actionEvent) {
    }

    public void btnViewRecordsOnAction(ActionEvent actionEvent) {
    }

    public void btnSettingsOnAction(ActionEvent actionEvent) {
    }

    public void btnLogoutOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/LoginForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage stage = new Stage();
        stage.setScene(new Scene(load));
        stage.centerOnScreen();
        btnLogout.getScene().getWindow().hide();
        stage.setResizable(false);
        stage.show();
    }
}
