/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecordingHandler;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;

/**
 *
 * @author mac
 */
public class CreatRecordFiles {
    
    private static File file;
   
   
   private static void createFile(String listType , String name) {

        Preferences prefs=Preferences.userNodeForPackage(CreatRecordFiles.class);
        
        //Preferences pref=Preferences.userNodeForPackage(OnlinePlayerController.class);
        
          CurrentDateTime currentDateTime = new CurrentDateTime();

        if(listType.equals("local-mode")){
            //System.out.println(dir.toString());
            prefs.put(currentDateTime.getCurrentDateTime(), currentDateTime.getCurrentDateTime()+" - "+name); 
              File dir = new File("record/savedLocalGame");
              dir.mkdirs();
              file = new File(dir,prefs.get(currentDateTime.getCurrentDateTime(),""));
              
        }else if(listType.equals("online-mode")){
            File dir = new File("record/savedOnlineGame");
            dir.mkdirs();
            
        }  
           try {
               
               if(file.createNewFile())
                   System.out.println("file created");
                            
           } catch (IOException ex) {
               Logger.getLogger(CreatRecordFiles.class.getName()).log(Level.SEVERE, null, ex);
           }
   }

    public static void writeFile(String s , String listType , String name)
    {
        createFile(listType, name);
        try {
           // file.createNewFile();
            System.out.println("file Created an write into it");

            if(file.exists())
            {
                FileWriter writer=new FileWriter(file,true);
                writer.write(s);   
                writer.flush();
                writer.close();
                System.out.println("write in file");
               
            }
        } catch (IOException ex) {
            System.out.println("error during write file");
            Logger.getLogger(CreatRecordFiles.class.getName()).log(Level.SEVERE, null, ex);
        }
              
    }
    
    public static String readFileAsString(String fileName) {
        
       String data = "";
       
       try {
          
           data = new String(Files.readAllBytes(Paths.get(fileName))); 
           
       } catch (IOException ex) {
         
           Logger.getLogger(CreatRecordFiles.class.getName()).log(Level.SEVERE, null, ex);
       }
     return data;   
    }
    
}
