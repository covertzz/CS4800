import java.util.Iterator;
import java.util.ArrayList;

interface IterableByUser {
    Iterator<Message> iterator(User userToSearchWith);
}

public class User implements IterableByUser {
    private String name;
    private ChatHistory chatHistory = new ChatHistory(this);
    private MessageMemento messageMemento = new MessageMemento(null);
    private ArrayList<User> blockedUsers = new ArrayList<User>();

    public User(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public ArrayList<User> getBlockedUsers() {
        return blockedUsers;
    }
    public void sendMessage(User[] receivers, String messageText) {
        Message message = new Message(this, receivers, messageText);
        ChatServer.sendMessage(message);
        messageMemento.setMessage(message);
        chatHistory.addNewMessage(message);
    }
    public void receiveMessage(Message message) {
        chatHistory.addNewMessage(message);
    }
    public void undoMessage() {
        Message lastMessage = messageMemento.getMessage();
        ChatServer.undoMessage(lastMessage);
        chatHistory.removeMessage(lastMessage);
    }
    public void blockUser(User user) {
        blockedUsers.add(user);
    }
    public void unBlockUser(User user) {
        blockedUsers.remove(user);
    }
    public ChatHistory getHistory() {
        return chatHistory;
    }
    public void printHistory() {
        System.out.println(name + "'s Chat History:");
        for(Message message : chatHistory.getHistory()) {
            System.out.print("\tTIMESTAMP: " + message.getTimestamp() + " FROM: " + message.getSender().getName() + " TO: "); message.printRecipients();
            System.out.println(" MESSAGE: " + message.getMessageString());
        }
        System.out.println();
    }
    public Iterator<Message> iterator(User userToSearchWith) {
        return new SearchMessagesByUser(chatHistory, userToSearchWith); 
    } 
}

class SearchMessagesByUser implements Iterator<Message> {
    Iterator<Message> chatHistoryIterator;
    public SearchMessagesByUser(ChatHistory chatHistory, User userToSearchWith) {
        chatHistoryIterator = chatHistory.iterator(userToSearchWith);
    }

    @Override
    public boolean hasNext() {
        return chatHistoryIterator.hasNext();
    }

    @Override 
    public Message next() {
        return chatHistoryIterator.next();
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }
}
