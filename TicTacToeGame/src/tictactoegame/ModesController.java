/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import server.ServerManager;

/**
 * FXML Controller class
 *
 * @author EmanAbobakr
 */
public class ModesController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Stage stage;
    private Scene scene;
    private Parent root;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
    }

    public void switchToDouble(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LocalMultiPlayerEntryScreen.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    public void switchToSingle(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EnterSingleMode.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void switchToLogin(ActionEvent event) throws IOException {

        Thread th = new Thread(new Runnable() {
            public void run() {

                if (ServerManager.getInstance().connectToServer()) {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            Parent root;
                            try {
                                root = FXMLLoader.load(getClass().getResource("Login.fxml"));
                                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                Scene scene = new Scene(root);
                                stage.setScene(scene);
                                stage.show();
                                stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                                    public void handle(WindowEvent we) {
                                        System.out.println("User closed from login");
                                        ServerManager.getInstance().logout();
                                        stage.close();
                                    }

                                });
                            } catch (IOException ex) {
                                System.out.println("ModesController");
                                Logger.getLogger(ModesController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    });

                }
            }
        });
        th.start();

    }

}
