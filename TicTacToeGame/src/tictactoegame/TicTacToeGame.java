/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author mac
 */
public class TicTacToeGame extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        //EntryScreenForLocalGame
        // ResultVideoController
        /////////////
        //entryScreenForLocalGame
        //////////
        //resultVideo
        System.out.println("here 111");
        Parent root = FXMLLoader.load(getClass().getResource("EntryScreenForLocalGame.fxml"));
        System.out.println("here 222");
        Scene scene = new Scene(root);
        System.out.println("here 333");
        stage.setScene(scene);
        
        System.out.println("here 444");
        stage.show();
        System.out.println("here 555");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
