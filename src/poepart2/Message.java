/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poepart2;

import java.io.FileWriter;
 import java.util. Random;


/**
 *
 * @author Student
 */
public class Message {
    private String messageID;
    private int numMessagesSent;
    private String recipient;
    private String messageText;
    private String messageHash;
    
    private static int totalMessages=0;
    
    // Constructor
    public Message (int numMessagesSent, String recipient, String messageText) {
        this.recipient=recipient;
        this.messageText=messageText;
        this.messageID=generateMessageID();
        this.messageHash=createMessageHash();
    }
    //Message ID, randomly generated 10 digits
    private String generateMessageID() {
        Random rand= new Random();
        long id = 1000000000L + (long) (rand.nextDouble()* 9000000000L);
        return String.valueOf(id);
    }
    public boolean checkMessageID() {
        return messageID.length() <=10;
    }
    
    //Check recipient, no more than 10 chars and contains internationl code (+)
    public String checkRecipientCell() {
        if (recipient.length() <=13 && recipient.startsWith("+")) {
            return "Cell phone successfully captured";
        } else {
            return "Cell phone number is incorrectly formatted or does not conatin an international code. Please correct the number and try again";
        }
    }
    //Unit test, boolean
    public boolean isRecipientValid() {
        return recipient.length() <=13 && recipient.startsWith("+");
    }
    // Message length check
    public String checkMessageLength() {
        if (messageText.length() <=250) {
            return "Message ready to send";
        } else {
            int excess= messageText.length()-250;
            return "Message exceeds 250 charcters by" + excess + "please reduce size";
        } 
        }
    //Create message hash
    public String createMessageHash() {
        String firstTwo=
                messageID.substring(0,2);
        String[] words= messageText.trim().split("\\s+");
        String firstWord=words[0];
        String lastWord=words[words.length-1];
        
        firstWord=firstWord.replaceAll("[^a-zA-Z]", "");
        lastWord=lastWord.replaceAll("[^a-zA-Z]", "");
        
        String hash=firstTwo + ":" + numMessagesSent + ":" + firstWord.toUpperCase()+ lastWord.toUpperCase();
        this.messageHash=hash;
        return hash;
    }
    // SentMessage options
    public String SentMessage(int option) {
        if (option == 1) {
            totalMessages++;
            return "Message successfully sent.";
        } else if (option== 2) {
            return "Press 0 to delete the message";
        } else if (option== 3) {
            return "Message successfully stored";
        } else {
            return "Invalid option";
        }
    }
    // Print messages
    public String printMessages() {
        return "MessageID:" + messageID + "\n" + "MessageHash:" + messageHash+ "\n"+"Recipient:" + recipient + "\n" + "Message: + messageText";
    }
    public int returnTotalMessages() {
        return totalMessages;
    }
    // Store messages in JSON file
    public void storeMessage() {
      
    }
    // Getters for tests
    public String getMessageID() { return messageID; }
    public String getMessageHash() { return messageHash; }
    public String getRecipient() { return recipient; }
    public String  getMessageText() { return messageText; }
    
    }
        
    
    

