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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

/**
 * FXML Controller class
 *
 * @author MOHAMED ADEL
 */
public class OnlineModeGameScreenController implements Initializable {

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

    
    /*
        players user name
    */
     private String player1;
     private String player2;

    public void setPlayer1(String player1) {
        this.player1 = player1;
        player1NameLabel.setText(player1);
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
        player2NameLabel.setText(player2);
    }
    /**
     * Initializes the controller class.
     */
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
    private void btn1_clicked(ActionEvent event) {
    }

    @FXML
    private void btn2_clicked(ActionEvent event) {
    }

    @FXML
    private void btn3_clicked(ActionEvent event) {
    }

    @FXML
    private void btn6_clicked(ActionEvent event) {
    }

    @FXML
    private void btn5__clicked(ActionEvent event) {
    }

    @FXML
    private void btn4_clicked(ActionEvent event) {
    }

    @FXML
    private void btn7__clicked(ActionEvent event) {
    }

    @FXML
    private void btn8_clicked(ActionEvent event) {
    }

    @FXML
    private void btn9(ActionEvent event) {
    }

    @FXML
    private void recordRadioBtnPressed(ActionEvent event) {
    }
    
}
