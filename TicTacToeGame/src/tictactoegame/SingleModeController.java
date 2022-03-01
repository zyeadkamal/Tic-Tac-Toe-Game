/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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

    public SingleModeController() {
        
        this.whosTurn = false;
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
    }

    @FXML
    private void recordBtn(ActionEvent event) {
    }

    @FXML
    private void exitGame(ActionEvent event) {
    }

    @FXML
    private void btn1(ActionEvent event) {
        btn1.setText(getWhosTurn());
        xoArr[0][0] = getWhosTurn();
        changeTurn();
        pcPlay();
        btn1.setDisable(true);
        winMsg();
  
    }

    @FXML
    private void btn2(ActionEvent event) {
        btn2.setText(getWhosTurn());
        xoArr[0][1] = getWhosTurn();
        changeTurn();
        pcPlay();
        btn2.setDisable(true);
        winMsg();
    }

    @FXML
    private void btn3(ActionEvent event) {
        btn3.setText(getWhosTurn());
        xoArr[0][2] = getWhosTurn();
        changeTurn();
        pcPlay();
        btn3.setDisable(true);
        winMsg();
    }

    @FXML
    private void btn4(ActionEvent event) {
        btn4.setText(getWhosTurn());
        xoArr[1][0] = getWhosTurn();
        changeTurn();
        pcPlay();
        btn4.setDisable(true);
        winMsg();
    }
    
   
    @FXML
    private void btn5(ActionEvent event) {
        btn5.setText(getWhosTurn());
        xoArr[1][1] = getWhosTurn();
        changeTurn();
        pcPlay();
        btn5.setDisable(true);
        winMsg();
    }

     @FXML
    private void btn6(ActionEvent event) {
        btn6.setText(getWhosTurn());
        xoArr[1][2] = getWhosTurn();
        changeTurn();
        pcPlay();
        btn6.setDisable(true);
        winMsg();
    }


    @FXML
    private void btn7(ActionEvent event) {
        btn7.setText(getWhosTurn());
        xoArr[2][0] = getWhosTurn();
        changeTurn();
        pcPlay();
        btn7.setDisable(true);
        winMsg();
    }

    @FXML
    private void btn8(ActionEvent event) {
        btn8.setText(getWhosTurn());
        xoArr[2][1] = getWhosTurn();
        changeTurn();
        pcPlay();
        btn8.setDisable(true);
        winMsg();
        
    }

    @FXML
    private void btn9(ActionEvent event) {
        btn9.setText(getWhosTurn());
        xoArr[2][2] = getWhosTurn();
        changeTurn();
        pcPlay();
        btn9.setDisable(true);
        winMsg();
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
            winner = "X player win";
            disableAllBtns();
            showAletr(winner);
        } else {
            if (isOWin()) {
            winner = "O player win";
            disableAllBtns();
            showAletr(winner);
            }
        }
    }
    
    public void showAletr(String str){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("XO Game");
        alert.setHeaderText("Congratulation");
        alert.setContentText(str);
        alert.show();
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
                  || (xoArr[0][2].equals(xoArr[1][1]) && xoArr[1][1].equals(xoArr[2][0]) && xoArr[2][0].equals("X")))
                return true;
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
                  || (xoArr[0][2].equals(xoArr[1][1]) && xoArr[1][1].equals(xoArr[2][0]) && xoArr[2][0].equals("O")))
                return true;
            else
                return false;
    }
    
    public void pcPlay(){
        move = AIAlgoritm.findBestMove(xoArr);
        if (move.row == 0 && move.col == 0) {
            btn1.setText(getWhosTurn());
            xoArr[0][0] = getWhosTurn();
            btn1.setDisable(true);
            winMsg();
            changeTurn();
        }else if (move.row == 0 && move.col == 1) {
            btn2.setText(getWhosTurn());
            xoArr[0][1] = getWhosTurn();
            btn2.setDisable(true);
            winMsg();
            changeTurn();
        }else if (move.row == 0 && move.col == 2) {
            btn3.setText(getWhosTurn());
            xoArr[0][2] = getWhosTurn();
            btn3.setDisable(true);
            winMsg();
            changeTurn();
        }else if (move.row == 1 && move.col == 0) {
            btn4.setText(getWhosTurn());
            xoArr[1][0] = getWhosTurn();
            btn4.setDisable(true);
            winMsg();
            changeTurn();
        }else if (move.row == 1 && move.col == 1) {
            btn5.setText(getWhosTurn());
            xoArr[1][1] = getWhosTurn();
            btn5.setDisable(true);
            winMsg();
            changeTurn();
        }else if (move.row == 1 && move.col == 2) {
            btn6.setText(getWhosTurn());
            xoArr[1][2] = getWhosTurn();
            btn6.setDisable(true);
            winMsg();
            changeTurn();
        }else if (move.row == 2 && move.col == 0) {
            btn7.setText(getWhosTurn());
            xoArr[2][0] = getWhosTurn();
            btn7.setDisable(true);
            winMsg();
            changeTurn();
        }else if (move.row == 2 && move.col == 1) {
            btn8.setText(getWhosTurn());
            xoArr[2][1] = getWhosTurn();
            btn8.setDisable(true);
            winMsg();
            changeTurn();
        }else if (move.row == 2 && move.col == 2) {
            btn9.setText(getWhosTurn());
            xoArr[2][2] = getWhosTurn();
            btn9.setDisable(true);
            winMsg();
            changeTurn();
        }
    }
    
}
