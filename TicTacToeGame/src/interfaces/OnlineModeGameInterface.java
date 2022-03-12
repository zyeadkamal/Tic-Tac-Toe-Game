/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import requests.GameMove;

/**
 *
 * @author MOHAMED ADEL
 */
public interface OnlineModeGameInterface {
    abstract void updateUI(GameMove move);
    
}
