/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import javafx.scene.control.Alert;
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
}
