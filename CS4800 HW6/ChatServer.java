import java.util.ArrayList;

public class ChatServer {
    static ArrayList<User> currentlyRegisteredUsers = new ArrayList<User>();
    public static void registerUser(User user) {
        currentlyRegisteredUsers.add(user);
    }
    public static void unregisterUser(User user) {
        currentlyRegisteredUsers.remove(user);
    }
    public static void sendMessage(Message message) {
        User sender = message.getSender();
        for (User receiver : message.getRecipients()) {
            if (currentlyRegisteredUsers.contains(sender) && 
            areMessagesBlocked(sender, receiver)) {
                receiver.receiveMessage(message);
            }
        }
    }
    public static boolean areMessagesBlocked(User sender, User receiver) {
        if (sender.getBlockedUsers().contains(receiver) || receiver.getBlockedUsers().contains(sender)) {
            return false;
        }
        return true;   
    }
    public static void undoMessage(Message message) {
        User[] recipients = message.getRecipients();
        for(User user : recipients) {
            user.getChatHistory().removeMessage(message);
        }
    }
}