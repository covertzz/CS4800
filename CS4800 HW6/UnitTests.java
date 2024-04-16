import java.util.ArrayList;
import java.util.Iterator;

public class UnitTests {
    public static void testAll() {
        testChatHistory();
        testSendMessage();
        testSendMessageToMultipleUsers();
        testMessageString();
        testMessageTimestamp();
        testBlockUsers();
        testUndoMessage();
        testIterateByUser();
    }
    public static void testChatHistory() {
        User testUser1 = new User("Test User 1");
        User testUser2 = new User("Test User 2");
        testUser1.sendMessage(new User[] {testUser2}, "Testing");
        testUser1.sendMessage(new User[] {testUser2}, "Testing 2");
        testUser2.sendMessage(new User[] {testUser2}, "Testing 3");

        if(!testUser1.getChatHistory().getHistory().get(0).getMessageString().equals("Testing") || 
           !testUser1.getChatHistory().getHistory().get(1).getMessageString().equals("Testing 2")) {
            System.out.println("ERROR: testSendMessage");
        }

    }
    public static void testSendMessage() {
        User testUser1 = new User("Test User 1");
        User testUser2 = new User("Test User 2");
        testUser1.sendMessage(new User[] {testUser2}, "Testing");
        
        if(testUser2.getChatHistory().getSize() != 0) {
            System.out.println("ERROR: testSendMessage");
        }
    }
    public static void testSendMessageToMultipleUsers() {
        User testUser1 = new User("Test User 1");
        User testUser2 = new User("Test User 2");
        User testUser3 = new User("Test User 3");
        testUser1.sendMessage(new User[] {testUser2, testUser3}, "Testing");
        
        if(testUser2.getChatHistory().getSize() != 0 || testUser3.getChatHistory().getSize() !=0) {
            System.out.println("ERROR: testSendMessage");
        }
    }
    public static void testMessageString() {
        User testUser1 = new User("Test User 1");
        Message message = new Message(testUser1, new User[] {}, "Testing");
        
        if(!message.getMessageString().equals("Testing")) {
            System.out.println("ERROR: testMessageString");
        }
    }
    public static void testMessageTimestamp() {
        User testUser1 = new User("Test User 1");
        User testUser2 = new User("Test User 2");
        Message message = new Message(testUser1, new User[] {testUser2}, "Testing");
        long timestamp = System.currentTimeMillis();
        
        if(message.getTimestamp() != timestamp) {
            System.out.println("ERROR: testMessageTimestamp");
        }
    }
    public static void testBlockUsers() {
        User testUser1 = new User("Test User 1");
        User testUser2 = new User("Test User 2");
        User testUser3 = new User("Test User 3");
        testUser1.blockUser(testUser2);
        testUser1.blockUser(testUser3);
        User[] usersThatAreBlocked = {testUser2, testUser3};
        ArrayList<User> blockedUserList = testUser1.getBlockedUsers();

        for(int i = 0; i < blockedUserList.size(); i++) {
            if(!blockedUserList.get(i).equals(usersThatAreBlocked[i])) {
                System.out.println("ERROR: testBanUsers");
            }
        }
    }
    public static void testUndoMessage() {
        User testUser1 = new User("Test User 1");
        User testUser2 = new User("Test User 2");
        testUser1.sendMessage(new User[] {testUser2}, "Testing");
        testUser1.sendMessage(new User[] {testUser2}, "Testing 2");
        testUser1.undoMessage();

        if(!testUser1.getChatHistory().getLastMessageSent().getMessageString().equals("Testing")) {
            System.out.println("ERROR: testUndoMessage");
        }
    }
    public static void testIterateByUser() {
        User testUser1 = new User("Test User 1");
        User testUser2 = new User("Test User 2");
        User testUser3 = new User("Test User 3");
        testUser2.sendMessage(new User[] {testUser1}, "Testing");
        testUser3.sendMessage(new User[] {testUser1}, "Testing 2");
        testUser2.sendMessage(new User[] {testUser1}, "Testing 3");

        String[] testMessages = {"Testing", "Testing 3"};

        Iterator<Message> testUser2Iterator = testUser1.iterator(testUser2); 
        int count = 0;
        while(testUser2Iterator.hasNext()) {
            if(!testUser2Iterator.next().getMessageString().equals(testMessages[count])) {
                System.out.println("ERROR: testIterateByUser");
            }
            count++;
        }
    }
}
