/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import java.io.IOException;
import static java.lang.Math.random;
import java.util.*;
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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author amrelshazly
 */
public class LocalMultiPlayerController extends xoGameLogic implements Initializable {

    int firstPlayerTurn;
    private  Stage stage ;
    private Scene scene ;
    private Parent root ;
    
    
    @FXML
    private Button buttonRecord;
    @FXML
    private Button buttonHistory;
    @FXML
    private Button buttonExit;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button9;
    @FXML
    private Button button8;
    @FXML
    private Button button7;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private Label turnLabel;
    @FXML
    private Label player1Label;
    @FXML
    private Label player2Label;
   
    @FXML
    private Label player1ResultLabel;
    @FXML
    private Label player2ResultLabel;
    
    
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
            turnLabel.setText( player1Label.getText() + " turn");
            firstPlayerTurn = 1;
      
    }
    
    
    public void setPlayersName(String player1 , String player2){
        player1Label.setText(player1);
        player2Label.setText(player2);
    }
    
    public void handleExitButton(ActionEvent event) throws IOException{
        
        root = FXMLLoader.load(getClass().getResource("EntryScreenForLocalGame.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow() ;
        scene = new Scene(root) ;
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    public void handlingXOButtons(ActionEvent event) {

        Button source = (Button) event.getSource();
        System.out.println("source = " + source);
        setNextTurn();
        
        
        if (source.getText().equals("")) {
            
            source.setText(getNexturn());
            // next turn
            if (getNexturn().equals("X")){
                turnLabel.setText(player2Label.getText() + " turn - O ");
            }
            else{
                turnLabel.setText( player1Label.getText() + " turn - X ");
            }
            source.setDisable(true);

        }
        if (source.getId().equals(button1.getId())) {
            xoOrderedMoves[0] = source.getText();
            
        } else if (source.getId().equals(button2.getId())) {
            xoOrderedMoves[1] = source.getText();
            
        } else if (source.getId().equals(button3.getId())) {
            xoOrderedMoves[2] = source.getText();
            
        } else if (source.getId().equals(button4.getId())) {
            xoOrderedMoves[3] = source.getText();
           
        } else if (source.getId().equals(button5.getId())) {
            xoOrderedMoves[4] = source.getText();
           
        } else if (source.getId().equals(button6.getId())) {
            xoOrderedMoves[5] = source.getText();
         
        } else if (source.getId().equals(button7.getId())) {
            xoOrderedMoves[6] = source.getText();
            
        } else if (source.getId().equals(button8.getId())) {
            xoOrderedMoves[7] = source.getText();
            
        } else if (source.getId().equals(button9.getId())) {
            xoOrderedMoves[8] = source.getText();
            
        }
        
        if (xPlayerWin()) {
            
            xPlayerScore++;
            player1ResultLabel.setText(xPlayerScore + "");
            terminateExistingRound(player1Label.getText());

        }

        if (oPlayerWin()) {
            
            oPlayerScore++;
            player2ResultLabel.setText(oPlayerScore + "");
            terminateExistingRound(player2Label.getText());

        }
        
        if (isFull()) {
            xPlayerScore++ ;
            oPlayerScore++ ;
            turnLabel.setText("You are tied,let's play another round");
            terminateExistingRound("tied");
        }

    }

    public void setNextTurn() {

        if (firstPlayerTurn == 0) {
            firstPlayerTurn = 1 ;
        } else {
            firstPlayerTurn = 0 ;
        }
    }

    public String getNexturn() {
        
        if (firstPlayerTurn == 0) {
            return xPlayer ;
        } else {
            return oPlayer ;
        }

    }
    
    public void terminateExistingRound(String winnerName )  {
        
        for (int i = 0; i < 9; i++) {
            xoOrderedMoves[i] = "0" ;
        }
        
        button1.setDisable(true);
        button2.setDisable(true);
        button3.setDisable(true);
        button4.setDisable(true);
        button5.setDisable(true);
        button6.setDisable(true);
        button7.setDisable(true);
        button8.setDisable(true);
        button9.setDisable(true);
        
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("resultVideo.fxml"));
        //Parent root = null;
        try {
            root = Loader.load();
        } catch (IOException ex) {
            Logger.getLogger(LocalMultiPlayerController.class.getName()).log(Level.SEVERE, null, ex);
        }

        ResultVideoController resultVideoController = Loader.getController();
        resultVideoController.setWinnerNameLabel(winnerName);
         
        stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();

    }
    

}
