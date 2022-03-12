/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import interfaces.NavigateToHomeInterface;
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
import tictactoelibrary.SignUpModel;

import validation.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import interfaces.NavigationInterface;

/**
 * FXML Controller class
 *
 * @author EmanAbobakr
 */
public class RegisterController implements Initializable,NavigationInterface, NavigateToHomeInterface {

    private Stage stage;
    private Scene scene;
    private Parent root;

    SignUpModel user;

    @FXML
    private Button signInId;

    @FXML
    private TextField usernameId;
    @FXML
    private PasswordField passId;
    @FXML
    private PasswordField conformPassId;

    @FXML
    private Label usernameTagId;
    @FXML
    private Label passwordTagId;
    @FXML
    private Label signupTagId;

    SignUpValidation suv;
    
    ServerManager sm ;
    @FXML
    private Button loginId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        suv = new SignUpValidation();
        sm = ServerManager.getInstance();
        sm.delegate = this;
    }
    

    @FXML
    public void switchToLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void registerUser(ActionEvent event) throws IOException {

        if (suv.emptyUsername(usernameId.getText()) == "" && suv.validateSignUpPassword(passId.getText(), conformPassId.getText()) == "") {
            
            user = new SignUpModel(usernameId.getText(), Integer.parseInt(passId.getText()));
            
            usernameTagId.setVisible(false);
            passwordTagId.setVisible(false);
            sm.registerToServer(user);
            
            
        } else {
            usernameTagId.setTextFill(Color.RED);
            usernameTagId.setText(suv.emptyUsername(usernameId.getText()));
            usernameTagId.setVisible(true);

            passwordTagId.setTextFill(Color.RED);
            passwordTagId.setText(suv.validateSignUpPassword(passId.getText(), conformPassId.getText()));
            passwordTagId.setVisible(true);
        }
    }

    @Override
    public void navigateToNext() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            this.stage=(Stage) usernameId.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Modes.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void navigateToHome() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Modes.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) signupTagId.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}

