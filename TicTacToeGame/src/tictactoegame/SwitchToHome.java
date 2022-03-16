/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author EmanAbobakr
 */
public class SwitchToHome {

    private static SwitchToHome switchToHomeObj;
    Stage stage;
    
    private SwitchToHome(Stage stage) {
        this.stage = stage;
    }
    
    public static SwitchToHome getInstance(Stage stage) {
        if (switchToHomeObj == null) {
            return switchToHomeObj = new SwitchToHome(stage);
        } else {
            return switchToHomeObj;
        }
    }
    
    public void switchToHome() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Modes.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
