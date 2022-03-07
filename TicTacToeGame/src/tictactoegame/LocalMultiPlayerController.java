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
    @FXML
    private Button buttonRestart;
    
    
    
    
    
    
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
    
    @FXML
    public void handleExitButton(ActionEvent event) throws IOException{
        
        root = FXMLLoader.load(getClass().getResource("LocalMultiPlayerEntryScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow() ;
        scene = new Scene(root) ;
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void handlingRestartButton(ActionEvent event){
        
        for (int i = 0 ; i < 9 ; i++){
            xoOrderedMoves[i] = "0" ;
        }
        
        button1.setText("");
        button2.setText("");
        button3.setText("");
        button4.setText("");
        button5.setText("");
        button6.setText("");
        button7.setText("");
        button8.setText("");
        button9.setText("");
        
        button1.setDisable(false);
        button2.setDisable(false);
        button3.setDisable(false);
        button4.setDisable(false);
        button5.setDisable(false);
        button6.setDisable(false);
        button7.setDisable(false);
        button8.setDisable(false);
        button9.setDisable(false);
    }


    @FXML
    public void handlingXOButtons(ActionEvent event) {

        Button source = (Button) event.getSource();
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
            System.out.println(button1.getText());
            System.out.println(xoOrderedMoves[0]);
            
        } else if (source.getId().equals(button2.getId())) {
            xoOrderedMoves[1] = source.getText();
            System.out.println(button2.getText());
            System.out.println(xoOrderedMoves[1]);
            
        } else if (source.getId().equals(button3.getId())) {
            xoOrderedMoves[2] = source.getText();
            System.out.println(button3.getText());
            System.out.println(xoOrderedMoves[2]);
            
        } else if (source.getId().equals(button4.getId())) {
            xoOrderedMoves[3] = source.getText();
            System.out.println(button4.getText());
            System.out.println(xoOrderedMoves[3]);
           
        } else if (source.getId().equals(button5.getId())) {
            xoOrderedMoves[4] = source.getText();
            System.out.println(button5.getText());
            System.out.println(xoOrderedMoves[4]);
           
        } else if (source.getId().equals(button6.getId())) {
            xoOrderedMoves[5] = source.getText();
            System.out.println(button6.getText());
            System.out.println(xoOrderedMoves[5]);
         
        } else if (source.getId().equals(button7.getId())) {
            xoOrderedMoves[6] = source.getText();
            System.out.println(button7.getText());
            System.out.println(xoOrderedMoves[6]);
            
        } else if (source.getId().equals(button8.getId())) {
            xoOrderedMoves[7] = source.getText();
            System.out.println(button8.getText());
            System.out.println(xoOrderedMoves[7]);
            
        } else if (source.getId().equals(button9.getId())) {
            xoOrderedMoves[8] = source.getText();
            System.out.println(button9.getText());
            System.out.println(xoOrderedMoves[8]);
            
        }
        
        if (xPlayerWin()) {
            
            xPlayerScore++;
            player1ResultLabel.setText(xPlayerScore + "");
            terminateExistingRound("win", player1Label.getText());

        }

        if (oPlayerWin()) {
            
            oPlayerScore++;
            player2ResultLabel.setText(oPlayerScore + " Wins");
            terminateExistingRound("win", player2Label.getText());

        }
        
        if (isFull()) {
            xPlayerScore++ ;
            oPlayerScore++ ;
            turnLabel.setText("You are tied");
            terminateExistingRound("tied","");
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
    
    public void terminateExistingRound(String winnerName , String name )  {
        
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
        
        //System.out.println("217");
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("ConclusionVideo.fxml"));
        //Parent root = null;
        try {
            //System.out.println("221");
            root = Loader.load();
            //System.out.println("223");
        } catch (IOException ex) {
            Logger.getLogger(LocalMultiPlayerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println("227");
        ConclusionVideoController conclusionVideoController = Loader.getController();
        //System.out.println("229");
        conclusionVideoController.setWinnerNameLabel(winnerName , name);
        turnLabel.setText(winnerName);
        //System.out.println("231"); 
        stage = new Stage();
        //System.out.println("233");
        stage.setScene(new Scene(root));
        //System.out.println("235");
        stage.show();
        stage.setResizable(false);
        //System.out.println("237");

    }
    

}
