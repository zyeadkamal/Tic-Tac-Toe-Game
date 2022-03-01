/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import com.sun.deploy.util.SessionState.Client;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

//import user.;


/**
 *
 * @author EmanAbobakr
 */
public class ServerManager {

    Socket server;
    ObjectInputStream ois;
    ObjectOutputStream oos;
/*
    public void registerToServer(UserModel user) {
        
        System.out.println("user nameeee " + user.getUsername());
        System.out.println("passworddddd " + user.getPassword());
        try {
            server = new Socket("10.145.5.245", 5005);
            ois = new ObjectInputStream(server.getInputStream());
            oos = new ObjectOutputStream(server.getOutputStream());
            oos.writeObject(user);
            
            //oos.writeObject("Hello ya Adel");

            try {
                System.out.println("3");
                String str = (String) ois.readObject();
                System.out.println(str);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            System.out.println("catcheeeeeeeeeeeeeeeeeeeeeed");
            Logger.getLogger(ServerManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
*/

}
