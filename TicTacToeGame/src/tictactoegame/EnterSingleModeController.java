/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mac
 */
public class EnterSingleModeController implements Initializable {

    @FXML
    private TextField nameLabel;
    @FXML
    private Button backBtn;
    @FXML
    private Button playBtn;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    private String playerName;
    @FXML
    private ImageView logoIMageView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backBtnPressed(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("Modes.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(EnterSingleModeController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @FXML
    private void playBtnPressed(ActionEvent event)  {
        playerName = nameLabel.getText();
        
        if (!nameLabel.getText().isEmpty()) {
            
            try {
                //*********************** if condition is false add alert later **********************
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("SingleMode.fxml"));
                root = loader.load();
                SingleModeController singleModeController = loader.getController() ;
                singleModeController.setPlayersName(playerName);
                stage = (Stage)((Node)event.getSource()).getScene().getWindow() ;
                scene = new Scene(root) ;
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(EnterSingleModeController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }else {
            showAletr();
        }
    
}
    
     public void showAletr(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("XO Game");
        alert.setHeaderText("Invalid Name !");
        alert.setContentText("Please enter your name to play");
        alert.show();
    }
}
