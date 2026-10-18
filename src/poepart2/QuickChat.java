/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poepart2;
import java.util.Scanner;





/**
 *
 * @author Student
 */
public class QuickChat {
    public void beginChat(){
        Scanner scanner = new Scanner(System.in);
      
        //User must be logged in
        System.out.println("Welcome to QuickChat");
        
        //Ask how many messages
        System.out.print("How many messages do you wish to send?");
        int numMessages=scanner.nextInt();
        scanner.nextLine();
        
        int messageCount=0;
        //Outer while loop, rums until user quits
        boolean running = true;
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1) Send Messages");
            System.out.println("2) Show recently sent messages (Coming soon)");
            System.out.println("3) Quit");
            System.out.print("Choose option: ");
            int menuChoice= scanner.nextInt();
            scanner.nextLine();
            
            if(menuChoice == 1) {
                
                //For loop, allow user to enter assigned number
                for(int i = 0; i < numMessages; i++) {
                    messageCount++;
                    System.out.println("/n---Message" + messageCount+ "---");
                    
                    //Recipient
                    System.out.print("Enter recipient cell number(with international codes");
                    String recipient= scanner.nextLine();
                    
                    //Message text
                    System.out.print("Enter your message (max 250 chars): ");
                    String text= scanner.nextLine();
                    if (text.length()> 250) {
                        System.out.println("Please enter a messsage of less than 250 characters");
                        System.out.println("You are" + (text.length()-250)+ "characters over.");
                        
                        i--; //Let the user retry
                        messageCount--; continue;
                    } else{
                        System.out.println("Message sent");
                    }
                    
                    //Create message
                    Message msg= new Message(messageCount,recipient,text);
                    
                    //Check recipient
                    System.out.println(msg.checkRecipientCell());
                    //Display details
                    System.out.println("Message ID:" + msg.getMessageID());
                    System.out.println("Message Hash:" + msg.createMessageHash());
                    System.out.println("Recipient:" + msg.getRecipient());
                    System.out.println("Message:" + msg.getMessageText());
                    
                   //Send, Store or Diregard
                   System.out.println("Choose:1) Send message 2)Disregard message 3)Store message to send later");
                   int choice=scanner.nextInt();
                   scanner.nextLine();
                   String result= msg.SentMessage(choice);
                   System.out.println(result);
                   if(choice == 3) {
                       msg.storeMessage();
                   }
                }
                System.out.println("\nTotal messages sent:" + messageCount);
            }else if (menuChoice ==2) {
                System.out.println("Coming soon");
                    }else if (menuChoice == 3) {
                        running = false;
                        System.out.println("Quitting application. Total messages:" + messageCount);
                    }else {
                        System.out.println("Invalid choice.");
                }
            }
        scanner.close();
        }
        
    }
    
    

