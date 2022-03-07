/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegame;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mac
 */
public class GamesRecordsTableController implements Initializable {

    @FXML
    private ListView<String> recordsListView;
    @FXML
    private Button backButton;
    
    private ArrayList<String> games;
    
    
    private Stage stage ;
    private Scene scene ;
    private Parent root ;
    private String selectedFile;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        selectedFile = "";
        games = new ArrayList<>();
    }    

    @FXML
    private void recordsListViewCellClicked(MouseEvent event) {
        
         String selectedItem = recordsListView.getSelectionModel().getSelectedItems().toString();
         if(selectedItem !="[]") {
            selectedItem = selectedItem.substring(1);
            int  index = selectedItem.indexOf("]");
            if(index!=-1)
            {
             selectedItem = selectedItem.substring(0,index);
             selectedFile = selectedFile.concat("/"+selectedItem);
                System.out.println(selectedFile);
                
                navigateToReplyGames(selectedFile,event);
            }

         }
    }

    @FXML
    private void backButtonPressed(ActionEvent event) {
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Modes.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(GamesRecordsTableController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void getFilesName (String listType){
        String dir="";
        if(listType.equals("local-mode")){
               dir = "savedLocalGame";
        }else if (listType.equals("online-mode")){
              dir = "savedOnlineGame";
        }
        
        File folder = new File("record/"+dir);
        System.out.println("record/"+dir);
        selectedFile = selectedFile.concat("record/"+dir);

        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
         if (listOfFiles[i].isFile() && listOfFiles[i].getName().startsWith("2")) {
             games.add(listOfFiles[i].getName());
             System.out.println(listOfFiles[i].getName());
            } 
         }
        Collections.sort(games, Collections.reverseOrder());
        recordsListView.getItems().addAll(games);
    }
    
    public void setType(String str){
        getFilesName(str);
    }
    
    
    private void navigateToReplyGames(String str,MouseEvent event ){
        
        try {
                //*********************** if condition is false add alert later **********************
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ReplayGames.fxml"));
                root = loader.load();
                ReplayGamesController replayGamesController = loader.getController() ;
                replayGamesController.setDocName(str);
                replayGamesController.getMoves();
                
                //root = FXMLLoader.load(getClass().getResource("LocalMultiPlayer.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow() ;
                scene = new Scene(root) ;
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(EnterSingleModeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
}
