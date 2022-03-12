/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import interfaces.NavigationInterface;
import interfaces.OnlinePlayerBoardInterface;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import server.ServerManager;
import requests.*;

/**
 * FXML Controller class
 *
 * @author MOHAMED ADEL
 */
public class OnlinePlayerBoardController implements Initializable, OnlinePlayerBoardInterface {

    @FXML
    private TableView<OnlineTable> tableViewId;
    @FXML
    private TableColumn<OnlineTable, String> playerColId;
    @FXML
    private TableColumn<OnlineTable, String> reqColId;
    
    public static OnlineUsersVector ouv;

    public static ObservableList<OnlineTable> observableList = FXCollections.observableArrayList(
            
    );
     private String username;
    @FXML
    private Text textId;

    public void setUsername(String username) {
        this.username = username;
    }
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //OnlinePlayerBoardController myObj = new OnlinePlayerBoardController();
        playerColId.setCellValueFactory(new PropertyValueFactory<OnlineTable, String>("username"));
        reqColId.setCellValueFactory(new PropertyValueFactory<OnlineTable, String>("userInGame"));
        setActionListenerToTable();
        tableViewId.setItems(observableList);
        ServerManager.getInstance().onlinePlayerBoardDelegate = this;
        System.out.println("Hello from init Main Board");
        
        
    }

    public String getUsername() {
        return username;
    }
    
     public void setActionListenerToTable() {
        tableViewId.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                String selectedPlayer = tableViewId.getSelectionModel().getSelectedItem().getUsername();
                System.out.println(selectedPlayer);
                ServerManager.getInstance().sendRequest(new GameRequest(username, selectedPlayer));
                OnlineModeGameScreenController.myTic = "X";
                OnlineModeGameScreenController.opTic = "O";
            }
        });
    }

    @Override
    public void showAlert(GameRequest gameRequest) {
        boolean response = Alerts.showRequestAlert(gameRequest.getStartingPlayer(), " wants to play with you");
        if(response == true)
        {
            AcceptancePlayingRequest acceptRequest = new AcceptancePlayingRequest();
            acceptRequest.setPlayer1(gameRequest.getStartingPlayer());
            acceptRequest.setPlayer2(gameRequest.getRecieverPlayer());
            ServerManager.getInstance().AcceptResponse(acceptRequest);
        }
        else{
            
        }
    }

    @Override
    public void NavigateToGame(AcceptancePlayingRequest accept) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("OnlineModeGameScreen.fxml"));
            Parent root = loader.load();
            OnlineModeGameScreenController onlineModeGameScreenController = loader.getController();
            onlineModeGameScreenController.setPlayer1(accept.getPlayer1());
            onlineModeGameScreenController.setPlayer2(accept.getPlayer2());
            
            Stage stage = (Stage) textId.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



}
