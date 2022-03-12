/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

/**
 *
 * @author amrelshazly
 */
public class XOGameLogic {

    public String xPlayer, oPlayer;
    public int xPlayerScore, oPlayerScore;
    public String[][] xoArr;
    boolean xWin = false , oWin  = false;
    public XOGameLogic() {
        
        xPlayer = "X";
        oPlayer = "O";
        xPlayerScore = 0;
        oPlayerScore = 0;
        xoArr = new String[3][3];

        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3 ; j++) {
                xoArr[i][j] = "_";
            }
            
        }

    }

   
    
    public boolean isXWin() {
            //first row
           if ((xoArr[0][0].equals(xoArr[0][1]) && xoArr[0][1].equals(xoArr[0][2]) && xoArr[0][2].equals("X"))
                  || (xoArr[1][0].equals(xoArr[1][1]) && xoArr[1][1].equals(xoArr[1][2]) && xoArr[1][2].equals("X"))
                  || (xoArr[2][0].equals(xoArr[2][1]) && xoArr[2][1].equals(xoArr[2][2]) && xoArr[2][2].equals("X"))
                  || (xoArr[0][0].equals(xoArr[1][0]) && xoArr[1][0].equals(xoArr[2][0]) && xoArr[2][0].equals("X"))
                  || (xoArr[0][1].equals(xoArr[1][1]) && xoArr[1][1].equals(xoArr[2][1]) && xoArr[2][1].equals("X"))
                  || (xoArr[0][2].equals(xoArr[1][2]) && xoArr[1][2].equals(xoArr[2][2]) && xoArr[2][2].equals("X"))
                  || (xoArr[0][0].equals(xoArr[1][1]) && xoArr[1][1].equals(xoArr[2][2]) && xoArr[2][2].equals("X"))
                  || (xoArr[0][2].equals(xoArr[1][1]) && xoArr[1][1].equals(xoArr[2][0]) && xoArr[2][0].equals("X"))) {
               
                xWin = true;
                return true;
           }
            else
                return false;
    }
    
     public boolean isOWin() {
            //first row
           if ((xoArr[0][0].equals(xoArr[0][1]) && xoArr[0][1].equals(xoArr[0][2]) && xoArr[0][2].equals("O"))
                  || (xoArr[1][0].equals(xoArr[1][1]) && xoArr[1][1].equals(xoArr[1][2]) && xoArr[1][2].equals("O"))
                  || (xoArr[2][0].equals(xoArr[2][1]) && xoArr[2][1].equals(xoArr[2][2]) && xoArr[2][2].equals("O"))
                  || (xoArr[0][0].equals(xoArr[1][0]) && xoArr[1][0].equals(xoArr[2][0]) && xoArr[2][0].equals("O"))
                  || (xoArr[0][1].equals(xoArr[1][1]) && xoArr[1][1].equals(xoArr[2][1]) && xoArr[2][1].equals("O"))
                  || (xoArr[0][2].equals(xoArr[1][2]) && xoArr[1][2].equals(xoArr[2][2]) && xoArr[2][2].equals("O"))
                  || (xoArr[0][0].equals(xoArr[1][1]) && xoArr[1][1].equals(xoArr[2][2]) && xoArr[2][2].equals("O"))
                  || (xoArr[0][2].equals(xoArr[1][1]) && xoArr[1][1].equals(xoArr[2][0]) && xoArr[2][0].equals("O"))) {
               
                oWin = true;
                return true;
           }
            else
                return false;
    }
     
    public boolean isFull(){
     
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (xoArr[i][j] == "_") {
                return false;
                }
            }
        }
        return true;
    }
    
    public boolean isDraw(){
        
        if (isFull() && !xWin && !oWin) {
            return true;
        }
        return  false;
    }

}
