/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import server.ServerManager;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import tictactoelibrary.LoginModel;

import validation.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import interfaces.NavigationInterface;

/**
 * FXML Controller class
 *
 * @author EmanAbobakr
 */
public class LoginController implements Initializable, NavigationInterface {

    private Stage stage;
    private Scene scene;
    private Parent root;

    LoginModel user;

    @FXML
    private Button loginId;
    @FXML
    private Button signupId;

    @FXML
    private TextField usernameId;
    @FXML
    private PasswordField passId;

    @FXML
    private Label tagId;

    ServerManager sm;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        sm = ServerManager.getInstance();
        sm.delegate = this;
    }

    public void switchToRegister(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void switchToHome() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Modes.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void loginUser(ActionEvent event) throws IOException {

        SignUpValidation suv = new SignUpValidation();
        if (suv.emptyUsername(usernameId.getText()) == "" && suv.validateLoginPassword(passId.getText()) == "") {

            user = new LoginModel(usernameId.getText(), Integer.parseInt(passId.getText()));

            sm.loginToServer(user);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        } else {
            tagId.setTextFill(Color.RED);
            tagId.setText(suv.emptyUsername(usernameId.getText()));
            tagId.setVisible(true);
        }
    }

    public void switchToBoard(Stage inStage, String str) throws IOException {

//        FXMLLoader loader = new FXMLLoader(getClass().getResource("OnlinePlayerBoard.fxml"));
//        Parent root = loader.load();
//        OnlinePlayerBoardController onlinePlayerBoard = loader.getController();
//        onlinePlayerBoard.setUsername(str);
//
//        Stage stage = inStage;
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
    }

    @Override
    public void navigateToNext() {
        //switch to Main board
        try {
//            switchToBoard((Stage) tagId.getScene().getWindow(),usernameId.getText());
            FXMLLoader loader = new FXMLLoader(getClass().getResource("OnlinePlayerBoard.fxml"));
            Parent root = loader.load();
            OnlinePlayerBoardController onlinePlayerBoard = loader.getController();
            onlinePlayerBoard.setUsername(usernameId.getText());

            Stage stage = (Stage) tagId.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            sm.reqOnlineUsers();
        } catch (IOException ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
