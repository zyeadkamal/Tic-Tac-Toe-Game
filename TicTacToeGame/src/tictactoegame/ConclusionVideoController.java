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

/**
 * FXML Controller class
 *
 * @author amrelshazly
 */
public class ConclusionVideoController implements Initializable {
    
    File file ;
    Media media ;
    MediaPlayer mediaPlayer ;
    private  Stage stage ;
    private Scene scene ;
    private Parent root ;

    @FXML
    private MediaView mediaViewConclusion;
    @FXML
    private Button buttonExit;
    @FXML
    private Label labelWinner;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setWinnerNameLabel(String winnerName){
        
        labelWinner.setText("Congraats "+winnerName);
        System.out.println("video 58");
        if (!winnerName.equals("tied")){
        file = new File("src/tictactoegame/winningVideo.mp4") ;
        System.out.println("video 60");
        media = new Media(file.toURI().toString()) ;
        System.out.println("video 62");
        mediaPlayer = new MediaPlayer(media) ;
        System.out.println("video 64");
        mediaViewConclusion.setMediaPlayer(mediaPlayer);
        System.out.println("video 66");
        mediaPlayer.play();
        System.out.println("video 68");
        }
        else{
        file = new File("/Users/amrelshazly/Desktop/iti/java course/Tic-Tac-Toe-Game-main/TicTacToeGame/src/tictactoegame/looser.mp4") ;
        media = new Media(file.toURI().toString()) ;
        mediaPlayer = new MediaPlayer(media) ;
        mediaViewConclusion.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();
        }
        
    }
    
    @FXML
    public void handleExitButton(ActionEvent event) throws IOException{
        
//        root = FXMLLoader.load(getClass().getResource("EntryScreenForLocalGame.fxml"));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow() ;
//        scene = new Scene(root) ;
//        stage.setScene(scene);
//        stage.show();
            System.out.println("video 83");
           stage = (Stage) buttonExit.getScene().getWindow();
           // do what you have to do
           System.out.println("video 86");
           stage.close();
    }
    
}
