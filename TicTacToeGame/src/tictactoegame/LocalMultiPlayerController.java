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
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import RecordingHandler.CreatRecordFiles ;

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
    boolean recorded  = false ;
    String gameRecord , player1Name , player2Name;
    
    
    @FXML
    private RadioButton buttonRecord;
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
            gameRecord = "" ;
            
      
    }
    
    @FXML
    private void handleRecordButton(ActionEvent event) {
        
        recorded = !recorded ;
       
    }
    
    
    public void setPlayersName(String player1 , String player2){
        player1Label.setText(player1);
        player2Label.setText(player2);
        player1Name = player1Label.getText();
        player2Name = player2Label.getText();
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
        
        for (int i = 0 ; i < 3 ; i++){
            for (int j = 0; j < 3; j++) {
                xoArr[i][j] = "_" ;
            }
          
        }
        xWin = false ;
        oWin = false ;
        gameRecord = "";
        
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
            xoArr[0][0] = source.getText();
            gameRecord = gameRecord.concat("00"+source.getText()+",") ;
            
            
        } else if (source.getId().equals(button2.getId())) {
            xoArr[0][1] = source.getText();
            gameRecord = gameRecord.concat("01"+source.getText()+",") ;
            
        } else if (source.getId().equals(button3.getId())) {
            xoArr[0][2] = source.getText();
            gameRecord = gameRecord.concat("02"+source.getText()+",") ;
            
        } else if (source.getId().equals(button4.getId())) {
            xoArr[1][0] = source.getText();
           gameRecord = gameRecord.concat("10"+source.getText()+",") ;
           
        } else if (source.getId().equals(button5.getId())) {
            xoArr[1][1] = source.getText();
            gameRecord = gameRecord.concat("11"+source.getText()+",") ;
           
        } else if (source.getId().equals(button6.getId())) {
            xoArr[1][2] = source.getText();
            gameRecord = gameRecord.concat("12"+source.getText()+",") ;
         
        } else if (source.getId().equals(button7.getId())) {
            xoArr[2][0] = source.getText();
            gameRecord = gameRecord.concat("20"+source.getText()+",") ;
            
        } else if (source.getId().equals(button8.getId())) {
            xoArr[2][1] = source.getText();
            gameRecord = gameRecord.concat("21"+source.getText()+",") ;
            
        } else if (source.getId().equals(button9.getId())) {
            xoArr[2][2] = source.getText();
            gameRecord = gameRecord.concat("22"+source.getText()+",") ;
            
        }
        
        if (isXWin()) {
            
            xPlayerScore++;
            player1ResultLabel.setText(xPlayerScore + "");
            System.out.println(player1ResultLabel.getText());
            
            if(recorded){
                CreatRecordFiles.writeFile(player1Name+"-"+player2Name+","+gameRecord,"local-mode",player1Name+" VS "+player2Name);
            }
            terminateExistingRound("win", player1Label.getText());
            System.out.println(gameRecord);

        }

        if (isOWin()) {
            
            oPlayerScore++;
            player2ResultLabel.setText(oPlayerScore + "");
            System.out.println(player2ResultLabel.getText());
            
            if(recorded){
                CreatRecordFiles.writeFile(player1Name+"-"+player2Name+","+gameRecord,"local-mode",player1Name+" VS "+player2Name);
            }
            terminateExistingRound("win", player2Label.getText());
            System.out.println(gameRecord);

        }
        
        if (isDraw()) {
            xPlayerScore++ ;
            oPlayerScore++ ;
            turnLabel.setText("You are tied");
            
            if(recorded){
                CreatRecordFiles.writeFile(player1Name+"-"+player2Name+","+gameRecord,"local-mode",player1Name+" VS "+player2Name);
            }
            terminateExistingRound("tied","");
            System.out.println(gameRecord);
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
        
        for (int i = 0 ; i < 3 ; i++){
            for (int j = 0; j < 3; j++) {
                xoArr[i][j] = "_" ;
            }
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

    @FXML
    private void historyButton(ActionEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("GamesRecordsTable.fxml"));
            root = loader.load();
            GamesRecordsTableController gamesRecordsTableController = loader.getController() ;
            gamesRecordsTableController.setType("local-mode");
            stage = (Stage)((Node)event.getSource()).getScene().getWindow() ;
            scene = new Scene(root) ;
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(SingleModeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
    

}
