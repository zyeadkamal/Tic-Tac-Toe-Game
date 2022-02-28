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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author mac
 */
public class EnterSingleModeController implements Initializable {

    @FXML
    private TextField nameLabel;
    @FXML
    private Button backBtn;
    @FXML
    private Button playBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backBtnPressed(ActionEvent event) {
    }

    @FXML
    private void playBtnPressed(ActionEvent event) {
    }
    
}
