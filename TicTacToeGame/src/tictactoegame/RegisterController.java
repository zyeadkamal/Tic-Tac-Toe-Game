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
import tictactoelibrary.SignUpModel;

import validation.*;

/**
 * FXML Controller class
 *
 * @author EmanAbobakr
 */
public class RegisterController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    SignUpModel user;

    @FXML
    private Button signInId;
    @FXML
    private Button switchToLogin;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        suv = new SignUpValidation();
    }

    public void switchToLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void registerUser(ActionEvent event) throws IOException {

        if (suv.emptyUsername(usernameId.getText()) == "" && suv.validateSignUpPassword(passId.getText(), conformPassId.getText()) == "") {
            //System.out.println("correct!");
            user = new SignUpModel(usernameId.getText(), Integer.parseInt(passId.getText()));
            ServerManager sm = ServerManager.getInstance();
            usernameTagId.setVisible(false);
            passwordTagId.setVisible(false);
            signupTagId.setText(sm.registerToServer(user));
            signupTagId.setVisible(true);

//            if(sm.registerToServer(user)){    
//            
//                usernameTagId.setVisible(false);
//                passwordTagId.setVisible(false);
//                
//                signupTagId.setTextFill(Color.GREEN);
//                signupTagId.setText("You are successfully registered. Thank you.");    
//                signupTagId.setVisible(true);
//                
//            }
//            else {
//                signupTagId.setTextFill(Color.RED);
//                signupTagId.setText("This username is already registerd. try another username");    
//                signupTagId.setVisible(true);
//            }
        } else {
            usernameTagId.setTextFill(Color.RED);
            usernameTagId.setText(suv.emptyUsername(usernameId.getText()));
            usernameTagId.setVisible(true);

            passwordTagId.setTextFill(Color.RED);
            passwordTagId.setText(suv.validateSignUpPassword(passId.getText(), conformPassId.getText()));
            passwordTagId.setVisible(true);
        }
    }

}
