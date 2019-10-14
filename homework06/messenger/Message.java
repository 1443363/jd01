package homework06.messenger;

import java.util.Date;

public class Message {
    private String message;
    private final User user;
    private Date date;

    public Message(String message, User user, Date date) {
        this.message = message;
        this.user = user;
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }

    public Date getDate() {
        return date;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                ", user=" + user +
                ", date=" + date +
                '}';
    }
}
