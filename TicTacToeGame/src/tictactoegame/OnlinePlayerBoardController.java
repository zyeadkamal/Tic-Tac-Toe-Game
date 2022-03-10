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
import server.ServerManager;
import requests.*;

/**
 * FXML Controller class
 *
 * @author MOHAMED ADEL
 */
public class OnlinePlayerBoardController implements Initializable, Runnable {

    @FXML
    private TableView<OnlineTable> tableViewId;
    @FXML
    private TableColumn<OnlineTable, String> playerColId;
    @FXML
    private TableColumn<OnlineTable, String> reqColId;
    
    ObservableList<OnlineTable> observableList = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //OnlinePlayerBoardController myObj = new OnlinePlayerBoardController();
        System.out.println("Hello from init Main Board");
        Thread th = new Thread(this);
        th.start();
    }

    @Override
    public void run() {
        OnlineUsers ou;
        OnlineUsersVector ouv;
        
        while (true) {
            System.out.println("I am waiting for onine users");
            //ou = ServerManager.getInstance().getOnlineUsers();
            ouv = ServerManager.getInstance().getOnlineUsers();
            if (ouv != null) {
                for (int i = 0; i < ouv.bigOnlineUsersVec.size(); i++) {
                    String str = ouv.bigOnlineUsersVec.get(i);
                    OnlineTable oot = new OnlineTable(str);
                    
                    
                    observableList.add(oot);
                    //System.out.println(ou.getOnlineUsers().get(i));
                    //System.out.println(ouv.onlineUsersVec.get(i));
                    System.out.println(ouv.bigOnlineUsersVec.get(i));
                }
                Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            playerColId.setCellValueFactory(new PropertyValueFactory<OnlineTable, String>("username"));
                            tableViewId.setItems(observableList);
                           
                        }
                    });
            }
        }

    }

}
