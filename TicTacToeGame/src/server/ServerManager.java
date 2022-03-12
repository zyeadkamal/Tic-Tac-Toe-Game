/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import com.sun.deploy.util.SessionState.Client;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.stage.Stage;
import tictactoegame.Alerts;
import tictactoelibrary.*;
import requests.*;

import tictactoegame.LoginController;
import tictactoegame.OnlinePlayerBoardController;
import tictactoegame.OnlineTable;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import interfaces.NavigationInterface;
import interfaces.OnlinePlayerBoardInterface;
import java.io.EOFException;
import java.net.ConnectException;

//import user.;
/**
 *
 * @author EmanAbobakr
 */
public class ServerManager implements Runnable {

    private static ServerManager serverManagerObj;

    Socket server;
    ObjectInputStream ois;
    ObjectOutputStream oos;
    public NavigationInterface delegate;
    public OnlinePlayerBoardInterface onlinePlayerBoardDelegate;

    Thread thread;

    private ServerManager() {

    }

    public static ServerManager getInstance() {
        if (serverManagerObj == null) {
            return serverManagerObj = new ServerManager();
        } else {
            return serverManagerObj;
        }
    }

    public boolean connectToServer() {
        try {
            //server = new Socket("10.145.5.245", 5005);
            server = new Socket("localhost", 5005);
            ois = new ObjectInputStream(server.getInputStream());
            oos = new ObjectOutputStream(server.getOutputStream());
            thread = new Thread(this);
            thread.start();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(ServerManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
//catch(ConnectException ex) {
//            
//        }
    }

    public void registerToServer(SignUpModel user) {
        System.out.println("Register using: " + user.getUsername());
        System.out.println("With Password: " + user.getPassword());
        try {
            oos.writeObject(user);
        } catch (IOException ex) {

            System.out.println("catcheeeeeeeeeeeeeeeeeeeeeed two");
            Alerts.showWarningAlert("The server is not available. Try later");
            Logger.getLogger(ServerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loginToServer(LoginModel user) {
        System.out.println("login using: " + user.getUsername());
        System.out.println("with password: " + user.getPassword());
        try {
            oos.writeObject(user);
        } catch (IOException ex) {
            System.out.println("catcheeeeeeeeeeeeeeeeeeeeeed four");
            Logger.getLogger(ServerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void reqOnlineUsers() {
        String s = new String("getOnlineUser");
        try {
            oos.writeObject(s);
        } catch (IOException ex) {
            Logger.getLogger(ServerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void sendRequest(GameRequest gameRequest)
    {
        try {
            oos.writeObject(gameRequest);
        } catch (IOException ex) {
            Logger.getLogger(ServerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void AcceptResponse(AcceptancePlayingRequest accept)
    {
        try {
            oos.writeObject(accept);
        } catch (IOException ex) {
            Logger.getLogger(ServerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @Override
    public void run() {

        while (true) {
            Object obj = null;
            try {
                obj = ois.readObject();
                if (obj instanceof String) {
                    String str = (String) obj;
                    if (str.equals("signup")) {
                        System.out.println("server send sign up");
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                Alerts.showInformationAlert("You are successfully registered. Thank you.");
                                //delegate.navigateToNext();
                            }
                        });
                    } else if (str.equals("notSignup")) {
                        System.out.println("server send not sign up");
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                Alerts.showWarningAlert("This username is already registerd. try another username");
                            }
                        });

                    } else if (str.equals("login")) {
                        System.out.println("server send login");
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                //Stage stage = this.currentStageProperty().get();
                                delegate.navigateToNext();
                            }
                        });

                    } else if (str.equals("notLogin")) {
                        System.out.println("server send not login");
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                Alerts.showWarningAlert("There is no Acc, Sign up");
                            }
                        });

                    } 
                    else {
                        System.out.println("Weird string from server");
                        System.out.println(str);
                    }

                } else if (obj instanceof OnlineUsersVector) {
                    System.out.println("Online users commmming");
                    System.out.println("Online Users:");
                    OnlineUsersVector ouv;
                    ouv = (OnlineUsersVector) obj;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            //update table view without username 
                            OnlinePlayerBoardController.ouv = ouv;
                            OnlinePlayerBoardController.observableList.clear();
                            for (int i = 0; i < ouv.bigOnlineUsersVec.size(); i++) {
                                //System.out.println("Hello from server manage-online users");
                                String str = ouv.bigOnlineUsersVec.get(i);
                                OnlineTable oot = new OnlineTable(str);
                                OnlinePlayerBoardController.observableList.add(oot);
                                System.out.println(ouv.bigOnlineUsersVec.get(i));
                            }
                        }
                    });
                }                
                else if (obj instanceof GameRequest) {
                    System.out.println("Recieve Request");
                    GameRequest gameRequest = (GameRequest) obj;
//                    System.out.println("I am "+gameRequest.getRecieverPlayer());
//                    System.out.println("player"+gameRequest.getStartingPlayer());
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("I am "+gameRequest.getRecieverPlayer());
                            System.out.println("player "+gameRequest.getStartingPlayer());
                            onlinePlayerBoardDelegate.showAlert(gameRequest);
                        }
                    });      
                    
                    
                }
                
                else if (obj instanceof AcceptancePlayingRequest) {
                   AcceptancePlayingRequest accept = (AcceptancePlayingRequest) obj;
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                               onlinePlayerBoardDelegate.NavigateToGame(accept);
                            }
                        });    
                    
                    
                }
            } catch (EOFException ex) {
                System.out.println("I am EOException 229");
                Logger.getLogger(ServerManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ServerManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ServerManager.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }

    }

}
