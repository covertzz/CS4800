import java.util.ArrayList;

public class UnitTests {
    public static void testAll() {
        testSendMessage();
        testMessageString();
        testMessageTimestamp();
        testBlockUsers();
        testUndoMessage();
    }
    public static void testSendMessage() {
        User testUser1 = new User("Test User 1");
        User testUser2 = new User("Test User 2");
        testUser1.sendMessage(new User[] {testUser2}, "Testing");
        
        if(testUser2.getHistory().getSize() != 0) {
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

        if(!testUser1.getHistory().getLastMessageSent().getMessageString().equals("Testing")) {
            System.out.println("ERROR: testUndoMessage");
        }
    }
}
