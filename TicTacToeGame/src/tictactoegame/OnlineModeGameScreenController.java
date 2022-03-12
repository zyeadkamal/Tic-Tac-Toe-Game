/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import RecordingHandler.CreatRecordFiles;
import interfaces.OnlineModeGameInterface;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import requests.GameMove;
import server.ServerManager;

/**
 * FXML Controller class
 *
 * @author MOHAMED ADEL
 */
public class OnlineModeGameScreenController extends XOGameLogic implements Initializable, OnlineModeGameInterface {

    @FXML
    private Label player1NameLabel;
    @FXML
    private Label userScore;
    @FXML
    private Label pcScore;
    @FXML
    private Label player2NameLabel;
    @FXML
    private Button historyBtn;
    @FXML
    private Button recordBtn;
    @FXML
    private Label drawLabel;
    @FXML
    private Label drawScore;
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
    private RadioButton recordRadioButton;
    private Button[] arrButton = new Button[9];

    static boolean myTurn;
    public static String myTic;
    public static String opTic;
    /*
        players user name
     */
    private String player1;
    private String player2;
    
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void setPlayer1(String player1) {
        this.player1 = player1;
        player1NameLabel.setText(player1);
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
        player2NameLabel.setText(player2);
    }
    private String opName;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODo
        ServerManager.getInstance().onlineModeGameInterfaceDelegate = this;
        System.out.println(myTic);
        System.out.println(opTic);
        if (myTic.equals("X")) {
            myTurn = true;
        } else {
            myTurn = false;
            setAllButtonDisable();
        }
        arrButton[0] = btn1;
        arrButton[1] = btn2;
        arrButton[2] = btn3;
        arrButton[3] = btn4;
        arrButton[4] = btn5;
        arrButton[5] = btn6;
        arrButton[6] = btn7;
        arrButton[7] = btn8;
        arrButton[8] = btn9;

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
    private void btn1_clicked(ActionEvent event) {

        btn1.setText(myTic);
        xoArr[0][0] = myTic;
        changeTurn();
        btnsStatus();
        ServerManager.getInstance().playMove(createMove("00"));
        winMsg();
    }

    @FXML
    private void btn2_clicked(ActionEvent event) {
        btn2.setText(myTic);
        xoArr[0][1] = myTic;
        changeTurn();
        btnsStatus();
        ServerManager.getInstance().playMove(createMove("01"));
        winMsg();
    }

    @FXML
    private void btn3_clicked(ActionEvent event) {
        btn3.setText(myTic);
        xoArr[0][2] = myTic;
        changeTurn();
        btnsStatus();
        ServerManager.getInstance().playMove(createMove("02"));
        winMsg();
    }

    @FXML
    private void btn6_clicked(ActionEvent event) {
        btn6.setText(myTic);
        xoArr[1][2] = myTic;
        changeTurn();
        btnsStatus();
        ServerManager.getInstance().playMove(createMove("12"));
        winMsg();
    }

    @FXML
    private void btn5__clicked(ActionEvent event) {
        btn5.setText(myTic);
        xoArr[1][1] = myTic;
        changeTurn();
        btnsStatus();
        ServerManager.getInstance().playMove(createMove("11"));
        winMsg();

    }

    @FXML
    private void btn4_clicked(ActionEvent event) {
        btn4.setText(myTic);
        xoArr[1][0] = myTic;
        changeTurn();
        btnsStatus();
        ServerManager.getInstance().playMove(createMove("10"));
        winMsg();
    }

    @FXML
    private void btn7__clicked(ActionEvent event) {
        btn7.setText(myTic);
        xoArr[2][0] = myTic;
        changeTurn();
        btnsStatus();
        ServerManager.getInstance().playMove(createMove("20"));
        winMsg();
    }

    @FXML
    private void btn8_clicked(ActionEvent event) {
        btn8.setText(myTic);
        xoArr[2][1] = myTic;
        changeTurn();
        btnsStatus();
        ServerManager.getInstance().playMove(createMove("21"));
        winMsg();
    }

    @FXML
    private void btn9(ActionEvent event) {
        btn9.setText(myTic);
        xoArr[2][2] = myTic;
        changeTurn();
        btnsStatus();
        ServerManager.getInstance().playMove(createMove("22"));
        winMsg();
    }

    @FXML
    private void recordRadioBtnPressed(ActionEvent event) {
    }

    void setAllButtonDisable() {
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

    void setAllButtonEnable() {
        for (Button b : arrButton) {
            if (b.getText().equals("")) {
                b.setDisable(false);
            }
        }
    }

    @Override
    public void updateUI(GameMove move) {
        String playedMove = move.getIndex();
        if (playedMove.charAt(0) == '0' && playedMove.charAt(1) == '0') {
            btn1.setText(opTic);
            xoArr[0][0] = opTic;
        } else if (playedMove.charAt(0) == '0' && playedMove.charAt(1) == '1') {
            btn2.setText(opTic);
            xoArr[0][1] = opTic;
        } else if (playedMove.charAt(0) == '0' && playedMove.charAt(1) == '2') {
            btn3.setText(opTic);
            xoArr[0][2] = opTic;
        } // second row
        else if (playedMove.charAt(0) == '1' && playedMove.charAt(1) == '0') {
            btn4.setText(opTic);
            xoArr[1][0] = opTic;
        } else if (playedMove.charAt(0) == '1' && playedMove.charAt(1) == '1') {
            btn5.setText(opTic);
            xoArr[1][1] = opTic;
        } else if (playedMove.charAt(0) == '1' && playedMove.charAt(1) == '2') {
            btn6.setText(opTic);
            xoArr[1][2] = opTic;
        } // third row
        else if (playedMove.charAt(0) == '2' && playedMove.charAt(1) == '0') {
            btn7.setText(opTic);
            xoArr[2][0] = opTic;
        } else if (playedMove.charAt(0) == '2' && playedMove.charAt(1) == '1') {
            btn8.setText(opTic);
            xoArr[2][1] = opTic;
        } else if (playedMove.charAt(0) == '2' && playedMove.charAt(1) == '2') {
            btn9.setText(opTic);
            xoArr[2][2] = opTic;
        }
        changeTurn();
        btnsStatus();
        winMsg();
    }

    public void changeTurn() {
        myTurn = !myTurn;
    }

    public void btnsStatus() {
        if (myTurn) {
            setAllButtonEnable();
        } else {
            setAllButtonDisable();
        }
    }

    public GameMove createMove(String index) {
        GameMove move = null;
        if (ServerManager.username == player1) {
            opName = player2;
            move = new GameMove(ServerManager.username, player2, index);
        } else {
            opName = player1;
            move = new GameMove(ServerManager.username, player1, index);
        }
        return move;
    }

    public void winMsg() {
        if (isXWin()) {
            if (myTic.equals("X")) {
                System.out.println("you win");
                showVideo("win", ServerManager.username);
            }
            if (myTic.equals("O")) {
                System.out.println("you lose");
                showVideo("lose", ServerManager.username);
            }
            setAllButtonDisable();
        } else if (isOWin()) {
            if (myTic.equals("X")) {
                showVideo("lose", ServerManager.username);
            }
            if (myTic.equals("O")) {
                showVideo("win", ServerManager.username);
            }
            setAllButtonDisable();
        } else if (isDraw()) {
            showVideo("tied","");
            setAllButtonDisable();
        }
    }
    private void showVideo(String winnerName, String name) {
        
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("ConclusionVideo.fxml"));
        try {
            root = Loader.load();
        } catch (IOException ex) {
            Logger.getLogger(LocalMultiPlayerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConclusionVideoController conclusionVideoController = Loader.getController();
        conclusionVideoController.setWinnerNameLabel(winnerName,name);
        stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        stage.setResizable(false);
    }

}
