/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import server.ServerManager;
import requests.*;

/**
 * FXML Controller class
 *
 * @author MOHAMED ADEL
 */
public class OnlinePlayerBoardController implements Initializable {

    @FXML
    private TableView<OnlineTable> tableViewId;
    @FXML
    private TableColumn<OnlineTable, String> playerColId;
    @FXML
    private TableColumn<OnlineTable, String> reqColId;
    
    public static OnlineUsersVector ouv;

    public static ObservableList<OnlineTable> observableList = FXCollections.observableArrayList(
            
    );
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //OnlinePlayerBoardController myObj = new OnlinePlayerBoardController();
        playerColId.setCellValueFactory(new PropertyValueFactory<OnlineTable, String>("username"));
        reqColId.setCellValueFactory(new PropertyValueFactory<OnlineTable, String>("userInGame"));
        
        tableViewId.setItems(observableList);
        
        System.out.println("Hello from init Main Board");
        
        
    }



}
