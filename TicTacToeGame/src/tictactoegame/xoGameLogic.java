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
public class xoGameLogic {

    public String xPlayer, oPlayer;
    public int xPlayerScore, oPlayerScore;
    public String[] xoOrderedMoves;

    public xoGameLogic() {
        
        xPlayer = "X";
        oPlayer = "O";
        xPlayerScore = 0;
        oPlayerScore = 0;
        xoOrderedMoves = new String[9];

        for (int i = 0; i < 9; i++) {
            xoOrderedMoves[i] = "0";
        }

    }

   
    
    public boolean isFull() {
        for (int i = 0; i < 9; i++) {
            if (xoOrderedMoves[i] == "0") {
                return false;
            }
        }
        return true;
    }
    
    public boolean xPlayerWin() {
       
        if ((xoOrderedMoves[0].equals(xoOrderedMoves[1]) && xoOrderedMoves[1].equals(xoOrderedMoves[2]) && xoOrderedMoves[2].equals(xPlayer))
                || (xoOrderedMoves[3].equals(xoOrderedMoves[4]) && xoOrderedMoves[4].equals(xoOrderedMoves[5]) && xoOrderedMoves[5].equals(xPlayer))
                || (xoOrderedMoves[6].equals(xoOrderedMoves[7]) && xoOrderedMoves[7].equals(xoOrderedMoves[8]) && xoOrderedMoves[8].equals(xPlayer))
                || (xoOrderedMoves[0].equals(xoOrderedMoves[3]) && xoOrderedMoves[3].equals(xoOrderedMoves[6]) && xoOrderedMoves[6].equals(xPlayer))
                || (xoOrderedMoves[1].equals(xoOrderedMoves[4]) && xoOrderedMoves[4].equals(xoOrderedMoves[7]) && xoOrderedMoves[7].equals(xPlayer))
                || (xoOrderedMoves[2].equals(xoOrderedMoves[5]) && xoOrderedMoves[5].equals(xoOrderedMoves[8]) && xoOrderedMoves[8].equals(xPlayer))
                || (xoOrderedMoves[0].equals(xoOrderedMoves[4]) && xoOrderedMoves[4].equals(xoOrderedMoves[8]) && xoOrderedMoves[8].equals(xPlayer))
                || (xoOrderedMoves[2].equals(xoOrderedMoves[4]) && xoOrderedMoves[4].equals(xoOrderedMoves[6]) && xoOrderedMoves[6].equals(xPlayer))) {
            return true;
        } else {
            return false;
        }
    }

    public boolean oPlayerWin() {
        
        if ((xoOrderedMoves[0].equals(xoOrderedMoves[1]) && xoOrderedMoves[1].equals(xoOrderedMoves[2]) && xoOrderedMoves[2].equals(oPlayer))
                || (xoOrderedMoves[3].equals(xoOrderedMoves[4]) && xoOrderedMoves[4].equals(xoOrderedMoves[5]) && xoOrderedMoves[5].equals(oPlayer))
                || (xoOrderedMoves[6].equals(xoOrderedMoves[7]) && xoOrderedMoves[7].equals(xoOrderedMoves[8]) && xoOrderedMoves[8].equals(oPlayer))
                || (xoOrderedMoves[0].equals(xoOrderedMoves[3]) && xoOrderedMoves[3].equals(xoOrderedMoves[6]) && xoOrderedMoves[6].equals(oPlayer))
                || (xoOrderedMoves[1].equals(xoOrderedMoves[4]) && xoOrderedMoves[4].equals(xoOrderedMoves[7]) && xoOrderedMoves[7].equals(oPlayer))
                || (xoOrderedMoves[2].equals(xoOrderedMoves[5]) && xoOrderedMoves[5].equals(xoOrderedMoves[8]) && xoOrderedMoves[8].equals(oPlayer))
                || (xoOrderedMoves[0].equals(xoOrderedMoves[4]) && xoOrderedMoves[4].equals(xoOrderedMoves[8]) && xoOrderedMoves[8].equals(oPlayer))
                || (xoOrderedMoves[2].equals(xoOrderedMoves[4]) && xoOrderedMoves[4].equals(xoOrderedMoves[6]) && xoOrderedMoves[6].equals(oPlayer))) {
            return true;
        } else {
            return false;
        }
    }

}
