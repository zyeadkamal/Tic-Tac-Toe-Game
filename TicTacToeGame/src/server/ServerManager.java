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
import java.util.logging.Level;
import java.util.logging.Logger;
import tictactoegame.Alerts;
import tictactoelibrary.*;

//import user.;


/**
 *
 * @author EmanAbobakr
 */
public class ServerManager {
    
    private static ServerManager serverManagerObj;

    Socket server;
    ObjectInputStream ois;
    ObjectOutputStream oos;
    
    private ServerManager() {
    }
    
    public static ServerManager getInstance(){
        if(serverManagerObj == null)
            return serverManagerObj = new ServerManager();
        else
            return serverManagerObj;
    }
    
    public boolean connectToServer() {
        try {
            //server = new Socket("10.145.5.245", 5005);
            server = new Socket("localhost", 5005);
            ois = new ObjectInputStream(server.getInputStream());
            oos = new ObjectOutputStream(server.getOutputStream());
            return true;
        } catch (IOException ex) {
            Logger.getLogger(ServerManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }       
    }

    public String registerToServer(SignUpModel user) {
        
        System.out.println("user nameeee " + user.getUsername());
        System.out.println("passworddddd " + user.getPassword());
        try {
//            server = new Socket("10.145.5.245", 5005);
//            ois = new ObjectInputStream(server.getInputStream());
//            oos = new ObjectOutputStream(server.getOutputStream());
            oos.writeObject(user);
            try {
                
                Boolean registered = new Boolean((boolean) ois.readObject());
                if(registered)
                    return "You are successfully registered. Thank you.";
                else
                    return "This username is already registerd. try another username";
                //System.out.println(registered);
            } catch (ClassNotFoundException ex) {
                System.out.println("catcheeeeeeeeeeeeeeeeeeeeeed one");
                Alerts.showWarningAlert("The server is not available, but you can login later");
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                return "You are successfully registered. Thank you.";
            }
        } catch (IOException ex) {
            
            System.out.println("catcheeeeeeeeeeeeeeeeeeeeeed two");
            Alerts.showWarningAlert("The server is not available. Try later");
            Logger.getLogger(ServerManager.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
        
    }
    
    public boolean loginToServer(LoginModel user) {
        
        System.out.println("user nameeee " + user.getUsername());
        System.out.println("passworddddd " + user.getPassword());
        try {
            System.out.println("I will try");
            //server = new Socket("10.145.5.245", 5005);
            server = new Socket("localhost", 5005);
            ois = new ObjectInputStream(server.getInputStream());
            oos = new ObjectOutputStream(server.getOutputStream());
            oos.writeObject(user);
            
            //oos.writeObject("Hello ya Adel");

            try {
                Boolean logined = (Boolean) ois.readObject();
                //server.close();
                //ois.close();
                //oos.close();
                return logined;
            } catch (ClassNotFoundException ex) {
                System.out.println("catcheeeeeeeeeeeeeeeeeeeeeed three");
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
 
        } catch (IOException ex) {
            System.out.println("catcheeeeeeeeeeeeeeeeeeeeeed four");
            Logger.getLogger(ServerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

}
