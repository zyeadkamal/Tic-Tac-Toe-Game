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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import RecordingHandler.CreatRecordFiles;
import java.util.ArrayList;
import java.util.StringTokenizer;  
import java.util.concurrent.TimeUnit;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;


/**
 * FXML Controller class
 *
 * @author mac
 */
public class ReplayGamesController extends Thread implements Initializable {

    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn6;
    @FXML
    private Button btn5;
    @FXML
    private Button btn4;
    @FXML
    private Button btn9;
    @FXML
    private Button btn8;
    @FXML
    private Button btn7;
    @FXML
    private Button backBtn;

    
    private Stage stage;
    private Scene scene;
    private Parent root;
    private String docName = "";
    private String moves = "";
    private ArrayList<String> gameMovement = new ArrayList<>();
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
            root = FXMLLoader.load(getClass().getResource("SingleMode.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(EnterSingleModeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getMoves() {
        
        moves = CreatRecordFiles.readFileAsString(docName);
        movesCutter(moves);
    }
    
    private void movesCutter(String moveString) {
        
        StringTokenizer st = new StringTokenizer(moveString,",");  
        while (st.hasMoreTokens()) {  
            gameMovement.add(st.nextToken());
        }
       startReplayGame();
      
    }
    
    private void startReplayGame(){

        Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        
                        String move;
                        
                        for (int i = 1; i < gameMovement.size(); i++) {
                            
                            move = gameMovement.get(i);
                            
                            if (move.charAt(0) == '0' && move.charAt(1) == '0') {
                                String turn = String.valueOf(move.charAt(2));
                                Platform.runLater(() -> btn1.setText(turn));

                            }

                            if (move.charAt(0) == '0' && move.charAt(1) == '1') {
                                String turn = String.valueOf(move.charAt(2));
                                Platform.runLater(() -> btn2.setText(turn));                            
                            }

                            if (move.charAt(0) == '0' && move.charAt(1) == '2') {

                                String turn = String.valueOf(move.charAt(2));
                                Platform.runLater(() -> btn3.setText(turn));
                            }

                            if (move.charAt(0) == '1' && move.charAt(1) == '0') {
                                String turn = String.valueOf(move.charAt(2));
                                Platform.runLater(() -> btn4.setText(turn));                            
                            }

                            if (move.charAt(0) == '1' && move.charAt(1) == '1') {
                                String turn = String.valueOf(move.charAt(2));
                                Platform.runLater(() -> btn5.setText(turn));                            
                            }

                            if (move.charAt(0) == '1' && move.charAt(1) == '2') {
                                String turn = String.valueOf(move.charAt(2));
                                Platform.runLater(() -> btn6.setText(turn));                            
                            }

                            if (move.charAt(0) == '2' && move.charAt(1) == '0') {
                                String turn = String.valueOf(move.charAt(2));
                                Platform.runLater(() -> btn7.setText(turn));                            
                            }

                            if (move.charAt(0) == '2' && move.charAt(1) == '1') {
                                String turn = String.valueOf(move.charAt(2));
                                Platform.runLater(() -> btn8.setText(turn));                            
                            }

                            if (move.charAt(0) == '2' && move.charAt(1) == '2') {
                                String turn = String.valueOf(move.charAt(2));
                                Platform.runLater(() -> btn9.setText(turn));                            
                            }

                            try {
                                TimeUnit.SECONDS.sleep(1);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(ReplayGamesController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                });
        
            t.start();
    }
    
    public void setDocName(String str){
        docName = str;
    }
        
}
