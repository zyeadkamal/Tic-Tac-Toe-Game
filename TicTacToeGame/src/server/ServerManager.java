/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import com.sun.deploy.util.SessionState.Client;
import interfaces.NavigateToHomeInterface;
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
import interfaces.OnlineModeGameInterface;
import interfaces.OnlinePlayerBoardInterface;
import java.io.EOFException;
import tictactoegame.OnlineModeGameScreenController;
import java.io.EOFException;
import java.net.ConnectException;
import tictactoegame.MiniScoreTable;

//import user.;
/**
 *
 * @author EmanAbobakr
 */
public class ServerManager implements Runnable {

    private static ServerManager serverManagerObj;
    public static String username = null;
    Socket server;
    ObjectInputStream ois;
    ObjectOutputStream oos;
    public NavigationInterface delegate;
    public OnlinePlayerBoardInterface onlinePlayerBoardDelegate;
    public OnlineModeGameInterface onlineModeGameInterfaceDelegate;
    public NavigateToHomeInterface navigationDelegate;

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
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    Alerts.showWarningAlert("The server is not available. Try later");

                }
            });
            //Logger.getLogger(ServerManager.class.getName()).log(Level.SEVERE, null, ex);
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
            //Logger.getLogger(ServerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loginToServer(LoginModel user) {
        System.out.println("login using: " + user.getUsername());
        System.out.println("with password: " + user.getPassword());
        try {
            oos.writeObject(user);
            username = user.getUsername();
        } catch (IOException ex) {
            System.out.println("catcheeeeeeeeeeeeeeeeeeeeeed four");
            Logger.getLogger(ServerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void logout() {
        System.out.println("I asked to logout");
        String s = new String("logout");
        try {
            oos.writeObject(s);
            oos.close();
            ois.close();
//            Platform.runLater(new Runnable() {
//                @Override
//                public void run() {
//                    navigationDelegate.navigateToHome();
//                }
//            });
            thread.stop();

        } catch (IOException ex) {
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

    public void reqScoreTable() {
        String s = new String("scoreTable");
        try {
            oos.writeObject(s);
        } catch (IOException ex) {
            Logger.getLogger(ServerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sendRequest(GameRequest gameRequest) {

        try {
            oos.writeObject(gameRequest);
        } catch (IOException ex) {
            Logger.getLogger(ServerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void AcceptResponse(AcceptancePlayingRequest accept) {
        try {
            oos.writeObject(accept);
        } catch (IOException ex) {
            Logger.getLogger(ServerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void playMove(GameMove gameMove) {
        try {
            oos.writeObject(gameMove);
        } catch (IOException ex) {
            Logger.getLogger(ServerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sendGameRes(GameResult gameResult) {
        try {
            oos.writeObject(gameResult);
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

                    }else if (str.equals("alreadyLogin")) {
                        System.out.println("server send already login");
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                Alerts.showWarningAlert("This Acc is already login");
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

                    } else {
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
                            ouv.bigOnlineUsersVec.remove(username);
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
                } else if (obj instanceof ScoreTable) {
                    System.out.println("Score table commmming");
                    ScoreTable st;
                    st = (ScoreTable) obj;
                    System.out.println("Score Table:");
                    System.out.println(st.scores);

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            //update score table view

                            OnlinePlayerBoardController.scoresObservableList.clear();
                            for (String k : st.scores.keySet()) {
                                MiniScoreTable mst = new MiniScoreTable();
                                mst.setUsername(k);
                                mst.setScore(st.scores.get(k));
                                OnlinePlayerBoardController.scoresObservableList.add(mst);

                            }
                        }
                    });
                } else if (obj instanceof GameRequest) {
                    System.out.println("Recieve Request");
                    GameRequest gameRequest = (GameRequest) obj;
//                    System.out.println("I am "+gameRequest.getRecieverPlayer());
//                    System.out.println("player"+gameRequest.getStartingPlayer());
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("I am " + gameRequest.getRecieverPlayer());
                            System.out.println("player " + gameRequest.getStartingPlayer());
                            onlinePlayerBoardDelegate.showAlert(gameRequest);
                            OnlineModeGameScreenController.myTic = "O";
                            OnlineModeGameScreenController.opTic = "X";
                        }
                    });

                } else if (obj instanceof AcceptancePlayingRequest) {
                    AcceptancePlayingRequest accept = (AcceptancePlayingRequest) obj;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            onlinePlayerBoardDelegate.NavigateToGame(accept);
                        }
                    });
                } else if (obj instanceof GameMove) {
                    GameMove move = (GameMove) obj;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            onlineModeGameInterfaceDelegate.updateUI(move);
                        }
                    });
                }
            } catch (EOFException ex) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            System.out.println("Herrrrrrrre");
                            Alerts.showWarningAlert("The server is closed now");
                            ois.close();
                            oos.close();
                            thread.stop();
                            navigationDelegate.navigateToHome();
                        } catch (IOException ex1) {
                            Logger.getLogger(ServerManager.class.getName()).log(Level.SEVERE, null, ex1);
                        }

                    }
                });
                break;
            } catch (IOException ex) {
                Logger.getLogger(ServerManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ServerManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
