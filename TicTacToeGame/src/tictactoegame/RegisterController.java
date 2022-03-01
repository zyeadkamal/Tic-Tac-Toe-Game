/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author EmanAbobakr
 */
public class RegisterController implements Initializable {
    
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    //UserModel user;
    
    
    @FXML
    private Button signInId;
    @FXML
    private Button switchToLogin;
    @FXML
    private TextField usernameId;
    @FXML
    private PasswordField passId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    public void switchToLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
    public void registerUser(ActionEvent event) throws IOException {
        //user = new UserModel(usernameId.getText(), Integer.parseInt(passId.getText()));
        //ServerManager sm = new ServerManager();
        //sm.registerToServer(user);
        setUserInformation(usernameId.getText(), Integer.parseInt(passId.getText()));
    }
    
    
    public void setUserInformation(String username, int pass) {
        System.out.println("your name = " + username);
        System.out.println("your pass = " + pass);
    }
    
    
    
}
