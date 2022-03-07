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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import RecordingHandler.CreatRecordFiles;
import javafx.scene.control.RadioButton;

/**
 * FXML Controller class
 *
 * @author mac
 */
public class SingleModeController implements Initializable {

    @FXML
    private Label userScore;
    @FXML
    private Label pcScore;
    @FXML
    private Button historyBtn;
    @FXML
    private Button recordBtn;
    @FXML
    private Button exitGame;
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
    private Button btn7;
    @FXML
    private Button btn8;
    @FXML
    private Button btn9;
    @FXML
    private Label playerNameLabel;
    
    
    boolean whosTurn;
    public String[][] xoArr;
    Move move = new Move();
    String winner;
    String playerName;
    int playerScore = 0; 
    int computerScore = 0;
    int drawScr = 0;
    boolean xWin;
    boolean oWin;
    String gameRecord;
    boolean recorded = false;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label drawLabel;
    @FXML
    private Label drawScore;
    @FXML
    private RadioButton recordRadioButton;

    public SingleModeController() {
        
        this.whosTurn = false;
        gameRecord = "";
        this.xoArr = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
            xoArr[i][j] = "_";
            }
        }
    }
    
     
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void historyBtn(ActionEvent event) {
        
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

    @FXML
    private void recordBtn(ActionEvent event) {
        
        newGame();
        
    }

    @FXML
    private void exitGame(ActionEvent event) {
        
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
    private void btn1(ActionEvent event) {
        btn1.setText(getWhosTurn());
        xoArr[0][0] = getWhosTurn();
        gameRecord=gameRecord.concat("00"+getWhosTurn()+",");
        changeTurn();
        winMsg();
        pcPlay();
        btn1.setDisable(true);
        System.out.println(xoArr+"\n"+gameRecord);
  
    }

    @FXML
    private void btn2(ActionEvent event) {
        btn2.setText(getWhosTurn());
        xoArr[0][1] = getWhosTurn();
        gameRecord=gameRecord.concat("01"+getWhosTurn()+",");
        changeTurn();
        winMsg();
        pcPlay();
        btn2.setDisable(true);
        System.out.println(xoArr+"\n"+gameRecord);
    }

    @FXML
    private void btn3(ActionEvent event) {
        btn3.setText(getWhosTurn());
        xoArr[0][2] = getWhosTurn();
        gameRecord=gameRecord.concat("02"+getWhosTurn()+",");
        changeTurn();
        winMsg();
        pcPlay();
        btn3.setDisable(true);
        System.out.println(xoArr+"\n"+gameRecord);
        
    }

    @FXML
    private void btn4(ActionEvent event) {
        btn4.setText(getWhosTurn());
        xoArr[1][0] = getWhosTurn();
        gameRecord=gameRecord.concat("10"+getWhosTurn()+",");
        changeTurn();
        winMsg();
        pcPlay();
        btn4.setDisable(true);
        System.out.println(xoArr+"\n"+gameRecord);
    }
    
   
    @FXML
    private void btn5(ActionEvent event) {
        btn5.setText(getWhosTurn());
        xoArr[1][1] = getWhosTurn();
        gameRecord=gameRecord.concat("11"+getWhosTurn()+",");
        changeTurn();
        winMsg();
        pcPlay();
        btn5.setDisable(true);
        System.out.println(xoArr+"\n"+gameRecord);
    }

     @FXML
    private void btn6(ActionEvent event) {
        btn6.setText(getWhosTurn());
        xoArr[1][2] = getWhosTurn();
        gameRecord=gameRecord.concat("12"+getWhosTurn()+",");
        changeTurn();
        winMsg();
        pcPlay();
        btn6.setDisable(true);
        System.out.println(xoArr+"\n"+gameRecord);
    }


    @FXML
    private void btn7(ActionEvent event) {
        btn7.setText(getWhosTurn());
        xoArr[2][0] = getWhosTurn();
        gameRecord=gameRecord.concat("20"+getWhosTurn()+",");
        changeTurn();
        winMsg();
        pcPlay();
        btn7.setDisable(true);
        System.out.println(xoArr+"\n"+gameRecord);
    }

    @FXML
    private void btn8(ActionEvent event) {
        btn8.setText(getWhosTurn());
        xoArr[2][1] = getWhosTurn();
        gameRecord=gameRecord.concat("21"+getWhosTurn()+",");
        changeTurn();
        winMsg();
        pcPlay();
        btn8.setDisable(true);
        System.out.println(xoArr+"\n"+gameRecord);
        
    }

    @FXML
    private void btn9(ActionEvent event) {
        btn9.setText(getWhosTurn());
        xoArr[2][2] = getWhosTurn();
        gameRecord=gameRecord.concat("22"+getWhosTurn()+",");
        changeTurn();
        winMsg();
        pcPlay();
        btn9.setDisable(true);
        System.out.println(xoArr+"\n"+gameRecord);
    }
    
    
    public String getWhosTurn() {
        if (whosTurn) {
            return "O";
        } else {
            return "X";
        }
    }
    
    public void changeTurn() {
        if (whosTurn) {
            whosTurn = false;
        } else {
            whosTurn = true;
        }
    }
    
    public void winMsg() {
        if (isXWin()) {
            winner = "win";
            disableAllBtns();
            showVideo(winner,playerName );
            playerScore++;
            userScore.setText(String.valueOf(playerScore));
            if (recorded) {
               CreatRecordFiles.writeFile(playerNameLabel.getText()+","+gameRecord,"local-mode",playerName+" vs "+"PC"+" - "+winner); 
            }
        } else if (isOWin()) {
            winner = "lose";
            disableAllBtns();
            showVideo(winner , playerName);
            computerScore++;
            pcScore.setText(String.valueOf(computerScore));
            if (recorded) {
             CreatRecordFiles.writeFile(playerNameLabel.getText()+","+gameRecord,"local-mode",playerName+" vs "+"PC"+" - "+winner);               
            }
        }else if (isDraw()) {
            winner = "tied";
            showVideo(winner , "");
            drawScr++;
            drawScore.setText(String.valueOf(drawScr));
            if (recorded) {
            CreatRecordFiles.writeFile(playerNameLabel.getText()+","+gameRecord,"local-mode",playerName+" vs "+"PC"+" - "+winner);
            }
        }
    }
    
    public void showAletr(String str, String str2){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("XO Game");
        alert.setHeaderText(str2);
        alert.setContentText(str);
        alert.show();
    }
    
    public void setPlayersName(String name){
        
        playerNameLabel.setText(name);
        playerName = name;
    }
    
    public void disableAllBtns(){
        btn1.setDisable(true);
        btn2.setDisable(true);
        btn3.setDisable(true);
        btn4.setDisable(true);
        btn5.setDisable(true);
        btn6.setDisable(true);
        btn7.setDisable(true);
        btn8.setDisable(true);
        btn9.setDisable(true);
    }
    
    public boolean isXWin() {
            //first row
           if ((xoArr[0][0].equals(xoArr[0][1]) && xoArr[0][1].equals(xoArr[0][2]) && xoArr[0][2].equals("X"))
                  || (xoArr[1][0].equals(xoArr[1][1]) && xoArr[1][1].equals(xoArr[1][2]) && xoArr[1][2].equals("X"))
                  || (xoArr[2][0].equals(xoArr[2][1]) && xoArr[2][1].equals(xoArr[2][2]) && xoArr[2][2].equals("X"))
                  || (xoArr[0][0].equals(xoArr[1][0]) && xoArr[1][0].equals(xoArr[2][0]) && xoArr[2][0].equals("X"))
                  || (xoArr[0][1].equals(xoArr[1][1]) && xoArr[1][1].equals(xoArr[2][1]) && xoArr[2][1].equals("X"))
                  || (xoArr[0][2].equals(xoArr[1][2]) && xoArr[1][2].equals(xoArr[2][2]) && xoArr[2][2].equals("X"))
                  || (xoArr[0][0].equals(xoArr[1][1]) && xoArr[1][1].equals(xoArr[2][2]) && xoArr[2][2].equals("X"))
                  || (xoArr[0][2].equals(xoArr[1][1]) && xoArr[1][1].equals(xoArr[2][0]) && xoArr[2][0].equals("X"))) {
               
                xWin = true;
                return true;
           }
            else
                return false;
    }
    
     public boolean isOWin() {
            //first row
           if ((xoArr[0][0].equals(xoArr[0][1]) && xoArr[0][1].equals(xoArr[0][2]) && xoArr[0][2].equals("O"))
                  || (xoArr[1][0].equals(xoArr[1][1]) && xoArr[1][1].equals(xoArr[1][2]) && xoArr[1][2].equals("O"))
                  || (xoArr[2][0].equals(xoArr[2][1]) && xoArr[2][1].equals(xoArr[2][2]) && xoArr[2][2].equals("O"))
                  || (xoArr[0][0].equals(xoArr[1][0]) && xoArr[1][0].equals(xoArr[2][0]) && xoArr[2][0].equals("O"))
                  || (xoArr[0][1].equals(xoArr[1][1]) && xoArr[1][1].equals(xoArr[2][1]) && xoArr[2][1].equals("O"))
                  || (xoArr[0][2].equals(xoArr[1][2]) && xoArr[1][2].equals(xoArr[2][2]) && xoArr[2][2].equals("O"))
                  || (xoArr[0][0].equals(xoArr[1][1]) && xoArr[1][1].equals(xoArr[2][2]) && xoArr[2][2].equals("O"))
                  || (xoArr[0][2].equals(xoArr[1][1]) && xoArr[1][1].equals(xoArr[2][0]) && xoArr[2][0].equals("O"))) {
               
                oWin = true;
                return true;
           }
            else
                return false;
    }
     
    public boolean isFull(){
     
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (xoArr[i][j] == "_") {
                return false;
                }
            }
        }
        return true;
    }
    
    public boolean isDraw(){
        
        if (isFull() && !xWin && !oWin) {
            return true;
        }
        return  false;
    }
    
    
    public void pcPlay(){
        move = AIAlgoritm.findBestMove(xoArr);
        if (move.row == 0 && move.col == 0) {
            btn1.setText(getWhosTurn());
            xoArr[0][0] = getWhosTurn();
            gameRecord=gameRecord.concat("00"+getWhosTurn()+",");
            btn1.setDisable(true);
            winMsg();
            changeTurn();
        }else if (move.row == 0 && move.col == 1) {
            btn2.setText(getWhosTurn());
            xoArr[0][1] = getWhosTurn();
            gameRecord=gameRecord.concat("01"+getWhosTurn()+",");
            btn2.setDisable(true);
            winMsg();
            changeTurn();
        }else if (move.row == 0 && move.col == 2) {
            btn3.setText(getWhosTurn());
            xoArr[0][2] = getWhosTurn();
            gameRecord=gameRecord.concat("02"+getWhosTurn()+",");
            btn3.setDisable(true);
            winMsg();
            changeTurn();
        }else if (move.row == 1 && move.col == 0) {
            btn4.setText(getWhosTurn());
            xoArr[1][0] = getWhosTurn();
            gameRecord=gameRecord.concat("10"+getWhosTurn()+",");
            btn4.setDisable(true);
            winMsg();
            changeTurn();
        }else if (move.row == 1 && move.col == 1) {
            btn5.setText(getWhosTurn());
            xoArr[1][1] = getWhosTurn();
            gameRecord=gameRecord.concat("11"+getWhosTurn()+",");
            btn5.setDisable(true);
            winMsg();
            changeTurn();
        }else if (move.row == 1 && move.col == 2) {
            btn6.setText(getWhosTurn());
            xoArr[1][2] = getWhosTurn();
            gameRecord=gameRecord.concat("12"+getWhosTurn()+",");
            btn6.setDisable(true);
            winMsg();
            changeTurn();
        }else if (move.row == 2 && move.col == 0) {
            btn7.setText(getWhosTurn());
            xoArr[2][0] = getWhosTurn();
            gameRecord=gameRecord.concat("20"+getWhosTurn()+",");
            btn7.setDisable(true);
            winMsg();
            changeTurn();
        }else if (move.row == 2 && move.col == 1) {
            btn8.setText(getWhosTurn());
            xoArr[2][1] = getWhosTurn();
            gameRecord=gameRecord.concat("21"+getWhosTurn()+",");
            btn8.setDisable(true);
            winMsg();
            changeTurn();
        }else if (move.row == 2 && move.col == 2) {
            btn9.setText(getWhosTurn());
            xoArr[2][2] = getWhosTurn();
            gameRecord=gameRecord.concat("22"+getWhosTurn()+",");
            btn9.setDisable(true);
            winMsg();
            changeTurn();
        }
    }
     
     public void newGame() {
         
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                xoArr[i][j] = "_";
            }
        }
        this.whosTurn = false;
        gameRecord = "";
        xWin = false;
        oWin = false;
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        btn1.setDisable(false);
        btn2.setDisable(false);
        btn3.setDisable(false);
        btn4.setDisable(false);
        btn5.setDisable(false);
        btn6.setDisable(false);
        btn7.setDisable(false);
        btn8.setDisable(false);
        btn9.setDisable(false);
    }

    @FXML
    private void recordRadioBtnPressed(ActionEvent event) {
        
        recorded = !recorded;
        
    }
    
    private void showVideo(String winnerName, String name) {
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
        conclusionVideoController.setWinnerNameLabel(winnerName,name);
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
