/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import requests.AcceptancePlayingRequest;
import requests.GameRequest;

/**
 *
 * @author MOHAMED ADEL
 */
public interface OnlinePlayerBoardInterface {
    abstract void showAlert(GameRequest gameRequest);
    abstract void NavigateToGame(AcceptancePlayingRequest accept);
    
}
