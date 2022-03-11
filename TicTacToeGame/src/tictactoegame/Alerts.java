/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;

/**
 *
 * @author EmanAbobakr
 */
public class Alerts {

    public static void showWarningAlert(String s) {
        Alert.AlertType type = Alert.AlertType.WARNING;
        Alert alert = new Alert(type, "");

        alert.initModality(Modality.APPLICATION_MODAL);
        //alert.initOwner(stage);
        alert.getDialogPane()
                .setContentText(s);
        alert.showAndWait();
    }

    public static void showInformationAlert(String s) {
        Alert.AlertType type = Alert.AlertType.INFORMATION;
        Alert alert = new Alert(type, "");

        alert.initModality(Modality.APPLICATION_MODAL);
        //alert.initOwner(stage);
        alert.getDialogPane().setContentText(s);
        alert.showAndWait();
    }

    public static boolean showRequestAlert(String msg, String username) {
//        Alert.AlertType type = Alert.AlertType.CONFIRMATION;
//        Alert alert = new Alert(type, "");
//
//        alert.initModality(Modality.APPLICATION_MODAL);
//        //alert.initOwner(stage);
//        alert.getDialogPane().setContentText(msg);
//        alert.showAndWait();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Request To Game");
        alert.setHeaderText("Player " + username +" "+ msg);
        //alert.showAndWait();

        Optional<ButtonType> option = alert.showAndWait();
        if (option.get() == null) {
            
        } else if (option.get() == ButtonType.OK) {
            return true;
        } else if (option.get() == ButtonType.CANCEL) {
            return false;
        } 
        return false;
    }
}
