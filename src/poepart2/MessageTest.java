package poepart2;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    @Test
    public void testRecipienrCellSucess()
    {
        //Test data: +27718693002 should be valid
        Message msg = new Message (0, "+27718693002", "Hi Sihle, can you join us for dinner tonight");
        String expected = "Cell phone number successfully captured";
        assertEquals(expected, msg.checkRecipientCell());
    }
    @Test
    public void testRecipientCellFailure()
    {
        //Test data: 08575975889 should fail because theres no international code
      Message msg = new Message(0, "08575975889", "Hi Joy, did you recieve the payment?");
      String expected= "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again";
      assertEquals(expected, msg.checkRecipientCell());
    }
    @Test
    public void testMessageLengthSucess()
    {
        //Test data: Under 250 chars
      Message msg=new Message(0, "+27718693002", "Hi Sihle, can you join us for dinner");
      assertEquals("Message ready to send", msg.checkMessageLength());
    }
    @Test
    public void testMessageLengthFailure()
    {
        //Test data: Over 250 chars
        String longText= "a" . repeat(260);
        Message msg= new Message(0,"+27718693002", longText);
        assertTrue(msg.checkMessageLength(). contains("exceeds 250 characters"));
        assertTrue(msg.checkMessageLength() . contains("10"));
    }
    @Test
    public void testMessageHashFormat() {
        Message msg= new Message(0, "+27718693002", "Hi Sihle, can yu us for dinner tonight");
        String hash= msg.createMessageHash();
        
        //Hash must contain :0 and end with TONIGHT
        assertTrue(hash.contains(":0:"));
        assertTrue(hash.toUpperCase(). contains("Hi"));
        assertTrue(hash.toUpperCase(). contains("TONIGHT"));
        System.out.println("Generated Hash:" + hash);
    }
    @Test
        
        public void testMessageIDLength() {
            
            //ID must be 10 digits
            Message msg=new Message(1, "+27718693002", "Test");
            System.out.println("Generated ID:" + msg.getMessageID());
            assertTrue(msg. checkMessageID());
            assertEquals(10,msg.getMessageID().length());
        }
        @Test
        
        public void testSentMessage() {
            //1= sent, 2=diregard,3=store
            Message msg = new Message(1,"+27718693002", "Test message");
            
            assertEquals("Message successfully sent", msg.SentMessage(1));
            assertEquals("Press 0 to delete the message", msg.SentMessage(2));
            assertEquals("Message successfully stored.", msg.SentMessage(3));
        }
        @Test
        
        public void testTotalMessage() {
            //Test total counter increases
            Message msg1 = new Message(1,"+27718693002", "First");
            msg1=SentMessage(1);
            int total= msg1.returnTotalMessages();
            assertTrue(total >= 1);
            
            
        }
        
        
    }
    
