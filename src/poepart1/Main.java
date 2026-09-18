/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poepart1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner sc =new
            Scanner(System.in);
        Login obj= new Login();
        System.out.println(" Registration");
        System.out.print("Enter first Name:");
        String fn = sc.nextLine();
        System.out.print("Enter last Name:");
        String ln = sc.nextLine();
        System.out.print("Enter Username (e,g kyl_1):");
        String user=sc.nextLine();
        System.out.print("Enter password (e,g Ch&&sec@ke99!):");
        String pass=sc.nextLine();
        System.out.print("Enter Cell(e.g +27838968976):");
        String cell = sc.nextLine();
        
        if (obj.checkUserName(user)) {
            System.out.println("Username successfully captured");
        } else {
            System.out.println("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length");
        }
        if
        (obj.checkPasswordComplexity(pass)) {
            System.out.println("Password successfully captured.");
        } else {
            System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters. a capital letter, a number and a special character");
        }
        if
       (obj.checkCellPhoneNumber(cell)) {
            System.out.println("Cell phone number successfully added");
        } else {
            System.out.println("Cell phone number incorrectly formatted or does not contain international code");
        }
        
        System.out.println(obj.registerUser(user, pass, cell, fn, ln));
        System.out.println("\n login");
        System.out.print("Username:");
        String loginU= sc.nextLine();
        System.out.print("Password:");
        String loginP= sc.nextLine();
        
        boolean loginStatus=obj.loginUser(loginU,loginP);
        
        System.out.println(obj.returnLoginStatus(loginStatus));  
    }
}
