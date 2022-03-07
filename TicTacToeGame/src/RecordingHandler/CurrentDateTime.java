/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecordingHandler;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author mac
 */
public class CurrentDateTime {
    
   private  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd  HH-mm-ss");
   private  LocalDateTime now = LocalDateTime.now();
   public  String getCurrentDateTime(){
            return dtf.format(now);
   }
}
