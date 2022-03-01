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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author amrelshazly
 */
public class EntryScreenForLocalGameController implements Initializable {
    
    private Stage stage ;
    private Scene scene ;
    private Parent root ;
    Image myImage ;

    @FXML
    private Button buttonPlay;
    @FXML
    private TextField textFieldPlayer1Name;
    @FXML
    private TextField textFieldPlayer2Name;
    @FXML
    private ImageView imageLogo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        myImage = new Image(getClass().getResourceAsStream("logo.jpeg"));
    }    
    
    
    @FXML
    public void handlePlayButton (ActionEvent event) throws IOException{
        
        String player1Name = textFieldPlayer1Name.getText();
        String player2Name = textFieldPlayer2Name.getText();
        
        
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
