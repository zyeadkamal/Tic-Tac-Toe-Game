/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

/**
 *
 * @author EmanAbobakr
 */
public class SignUpValidation {
    
    
    
    public String emptyUsername(String username){
        if(username.isEmpty())
            return "The user name field is empty";
        else
            return "";
    }
    
    public String validateSignUpPassword(String pass1, String pass2){
        
        if(pass1 == "" && pass2 == "")
            return "The password field is empty";
                
        if(!pass1.equals(pass2))
            return "Those passwords didn't match. try again.";
        
        try {
            int x = Integer.parseInt(pass1);
            return "";
        } catch (Exception e) {
            return "Password should only contains numbers";
        }
        
    }
    
    public String validateLoginPassword(String pass){
        
        if(pass == "")
            return "The password field is empty";
                
        try {
            int x = Integer.parseInt(pass);
            return "";
        } catch (Exception e) {
            return "Password should only contains numbers";
        }
        
    }
}
