/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

/**
 *
 * @author EmanAbobakr
 */
public class OnlineTable {
    private String username;
    private String userInGame;

    public OnlineTable(String username, String userInGame) {
        this.username = username;
        this.userInGame = userInGame;
    }
    
    public OnlineTable(String username){
        this.username = username;
        this.userInGame = "yes";
    }
    
    public OnlineTable(){
        
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserInGame() {
        return userInGame;
    }

    public void setUserInGame(String userInGame) {
        this.userInGame = userInGame;
    }
    
    
}
