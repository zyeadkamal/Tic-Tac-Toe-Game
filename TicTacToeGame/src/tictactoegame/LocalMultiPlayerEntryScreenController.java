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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author amrelshazly
 */
public class LocalMultiPlayerEntryScreenController implements Initializable {
    
    private Stage stage ;
    private Scene scene ;
    private Parent root ;

    @FXML
    private TextField textFieldPlayerTwoName;
    @FXML
    private TextField textFieldPlayerOneName;
    @FXML
    private Button buttonPlay;
    @FXML
    private Button buttonBack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    @FXML
    public void handleBackButton(ActionEvent event) throws IOException{
        
        root = FXMLLoader.load(getClass().getResource("Modes.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow() ;
        scene = new Scene(root) ;
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
     public void handlePlayButton (ActionEvent event) throws IOException{
        
        String player1Name = textFieldPlayerOneName.getText();
        String player2Name = textFieldPlayerTwoName.getText();
        
        
        if (!player1Name.isEmpty() && !player2Name.isEmpty()&&
            !player1Name.startsWith(" ") && !player2Name.startsWith(" ")) {
            
        //*********************** if condition is false add alert later **********************
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LocalMultiPlayer.fxml"));
        root = loader.load();
        LocalMultiPlayerController localMultiPlayercotController = loader.getController() ;
        localMultiPlayercotController.setPlayersName(player1Name, player2Name);
        
        //root = FXMLLoader.load(getClass().getResource("LocalMultiPlayer.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow() ;
        scene = new Scene(root) ;
        stage.setScene(scene);
        stage.show();
        }


    }
    
}
