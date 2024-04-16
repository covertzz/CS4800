import java.util.Iterator;

public class driver {
    public static void main(String[] args) {
        UnitTests.testAll();

        User user1 = new User("User 1");
        User user2 = new User("User 2");
        User user3 = new User("User 3");
        
        ChatServer.registerUser(user1);
        ChatServer.registerUser(user2);
        ChatServer.registerUser(user3);

        user1.sendMessage(new User[] {user2, user3}, "Hello");
        user2.sendMessage(new User[] {user1, user3}, "Hey!");
        user3.sendMessage(new User[] {user1, user2}, "I don't like User 1");
        user3.blockUser(user1);
        user1.sendMessage(new User[] {user2, user3}, "Wait what?");
        user2.sendMessage(new User[] {user1, user3}, "Did you just block User 1? Not cool man");
        user3.sendMessage(new User[] {user1, user2}, "idc");

        user1.sendMessage(new User[] {user3}, "Why did you block me?");

        user3.undoMessage();
        user3.sendMessage(new User[] {user1, user2}, "sorry I shouldn't have said that");
        user3.sendMessage(new User[] {user2}, "I still don't like him but I'll unblock him");

        user3.unBlockUser(user1);
        user3.sendMessage(new User[] {user1, user2}, "Hey User 1");

        user1.printHistory();
        user2.printHistory();
        user3.printHistory();

        Iterator<Message> user3Iterator = user1.iterator(user3); 
        System.out.println("User 1's chat history from user 3:");
        while(user3Iterator.hasNext()) {
            System.out.println(user3Iterator.next().getMessageString());
        }
        System.out.println();

        Iterator<Message> user2Iterator = user2.iterator(user3); 
        System.out.println("User 2's chat history from user 3:");
        while(user2Iterator.hasNext()) {
            System.out.println(user2Iterator.next().getMessageString());
        }
        System.out.println();
    }
}
