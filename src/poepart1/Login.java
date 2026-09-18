/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poepart1;

/**
 *
 * @author Student
 */
public class Login {

    //Variable;
    String aUserName;
    String aPassWord;
    String aFirstName;
    String aLastName;

    // Check username
    public boolean checkUserName(String UserName) {
        return UserName.contains("_") && UserName.length() <= 5;

    }

    //Check password
    public boolean checkPasswordComplexity(String password) {
        boolean length = false;
        boolean capital = false;
        boolean number = false;
        boolean special = false;
        if (password.length() >= 8) {
            length = true;
        }
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                capital = true;
            }
            if (c >= '0' && c <= '9') {
                number = true;
            }
            if (!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z') && !(c >= '0' && c <= '9')) {
                special = true;

            }
        }
        return length && capital && number && special;
    }

    //Regex for cell
    //Pattern ^\+27\d{9}$ means starts with +27 followed by 9 digits
    public boolean checkCellPhoneNumber(String number) {
        String pattern = "^\\+27\\d{9}$";
        return number.matches(pattern);
    }

    public String registerUser(String username, String password, String Cell, String firstname, String lastname) {
        if (checkUserName(username) == false) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        if (checkPasswordComplexity(password) == false) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number and a special characters";
        }
        if (checkCellPhoneNumber(Cell) == false) {
            return "Cell number is incorrectly formatted or does not conatin an international code; please correct the number and try again.";
        }
        aUserName=username;
        aPassWord=password;
        aFirstName=firstname;
        aLastName=lastname;
         
        return "User registered successfully";
    }
    
    public boolean loginUser(String username, String password) {
        return username.equalsIgnoreCase(aUserName)&& password.equals(aPassWord);
         
    }
    
    public String returnLoginStatus(boolean loginStatus) {
        if (loginStatus==true){
           return "You have sucessfully logged in";  
        }
         return "You have entered incorrect details";
    }   
    
}

    