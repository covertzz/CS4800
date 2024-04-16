public class Message {
    private User sender;
    private User[] recipients;
    private String message;
    private long timestamp;
 
    public Message(User sender, User[] recipients, String message) {
        timestamp = System.currentTimeMillis();
        this.sender = sender;
        this.recipients = recipients;
        this.message = message;
    }
    public void setSender(User sender) {
        this.sender = sender;
    }
    public User getSender() {
        return sender;
    }
    public void setRecipients(User[] recipients) {
        this.recipients = recipients;
    }
    public User[] getRecipients() {
        return recipients;
    }
    public void printRecipients() {
        for(User user : recipients) {
            System.out.print(user.getName() + " ");
        }
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessageString() {
        return message;
    }
    public long getTimestamp() {
        return timestamp;
    }
    
}