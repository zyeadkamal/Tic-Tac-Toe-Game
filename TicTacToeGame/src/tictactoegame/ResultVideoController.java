/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author amrelshazly
 */
public class ResultVideoController implements Initializable {
    
    File file ;
    Media media ;
    MediaPlayer mediaPlayer ;
    private  Stage stage ;
    private Scene scene ;
    private Parent root ;

    @FXML
    private MediaView videoResult;
    @FXML
    private Label labelWinnerName;
    @FXML
    private Button buttonExit;
    @FXML
    private Button buttonRestart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
        
    }    
    
    public void setWinnerNameLabel(String winnerName){
        
        labelWinnerName.setText(winnerName + "Wins");
        if (!winnerName.equals("tied")){
        file = new File("/Users/amrelshazly/Desktop/iti/java course/XO Game/GitHub/TicTacToeGame/src/tictactoegame/winningVideo.mp4") ;
        media = new Media(file.toURI().toString()) ;
        mediaPlayer = new MediaPlayer(media) ;
        videoResult.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();
        }
        else{
        file = new File("/Users/amrelshazly/Desktop/iti/java course/XO Game/GitHub/TicTacToeGame/src/tictactoegame/looser.mp4") ;
        media = new Media(file.toURI().toString()) ;
        mediaPlayer = new MediaPlayer(media) ;
        videoResult.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();
        }
        
    }
    
    @FXML
    public void handleRestartButton(ActionEvent event) throws IOException{
        
        root = FXMLLoader.load(getClass().getResource("LocalMultiPlayer.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow() ;
        scene = new Scene(root) ;
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void handleExitButton(ActionEvent event) throws IOException{
        
//        root = FXMLLoader.load(getClass().getResource("EntryScreenForLocalGame.fxml"));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow() ;
//        scene = new Scene(root) ;
//        stage.setScene(scene);
//        stage.show();
          
           stage = (Stage) buttonExit.getScene().getWindow();
           // do what you have to do
           stage.close();
    }
}
