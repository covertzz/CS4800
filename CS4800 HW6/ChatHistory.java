import java.util.Iterator;
import java.util.ArrayList;

interface IterableByUser {
    Iterator<Message> iterator(User userToSearchWith);
}

public class ChatHistory implements IterableByUser {
    User user;
    private ArrayList<Message> history = new ArrayList<Message>();

    public ChatHistory(User user) {
        this.user = user;
    }
    public void addNewMessage(Message message) {
        history.add(message);
    }
    public Message getLastMessageSent() {
        return history.get(history.size()-1);
    }
    public void removeMessage(Message message) {
        history.remove(message);
    }
    public ArrayList<Message> getHistory() {
        return history;
    }
    public int getSize() {
        return history.size();
    }
    public Iterator<Message> iterator(User userToSearchWith) {
        return new ChatHistoryIterator(this, userToSearchWith);
    }
}

class ChatHistoryIterator implements Iterator<Message> {
    private ArrayList<Message> history;
    private User userToSearchFor;
    private int indexInHistory;

    public ChatHistoryIterator(ChatHistory chatHistory, User userToSearchFor) {
        this.history = chatHistory.getHistory();
        indexInHistory = 0;
        this.userToSearchFor = userToSearchFor;
    }

    @Override
    public boolean hasNext() {
        Message message = null;
        while(indexInHistory < history.size()) {
            message = history.get(indexInHistory);
            if(message.getSender().equals(userToSearchFor)) {
                return true;
            }
            else {
                indexInHistory++;
            }
        }
        return false;
    }

    @Override 
    public Message next() {
        return history.get(indexInHistory++);
        
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }
}