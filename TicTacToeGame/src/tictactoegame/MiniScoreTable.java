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
public class MiniScoreTable {
    
    String username;
    String score;

    public MiniScoreTable(String username, String score) {
        this.username = username;
        this.score = score;
    }
    
    public MiniScoreTable() {
        
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
    
    
}
