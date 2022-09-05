package lk.ijse.dep9.clinic.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;

public class AdminSettingsFormController {
    public JFXButton btnHospitalFee;
    public JFXButton btnDiscounts;
    public JFXButton btnChangePassword;
    public JFXButton btnManageFields;
    public JFXButton btnAbout;
    public AnchorPane pneContainer;

    public void btnHospitalFeeOnAction(ActionEvent actionEvent) {
    }

    public void btnDiscountsOnAction(ActionEvent actionEvent) {
    }

    public void btnChangePasswordOnAction(ActionEvent actionEvent) {
    }

    public void btnManageFieldsOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("/view/ManageFieldsForm.fxml");
        Parent load = FXMLLoader.load(resource);
        pneContainer.getChildren().add(load);
        AnchorPane.setLeftAnchor(load,0.0);
        AnchorPane.setRightAnchor(load,0.0);
        AnchorPane.setBottomAnchor(load,0.0);
        AnchorPane.setTopAnchor(load,0.0);


    }

    public void btnAboutOnAction(ActionEvent actionEvent) {
    }
}
