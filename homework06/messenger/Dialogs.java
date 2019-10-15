package homework06.messenger;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Dialogs {
    private Message[] messages = new Message[0];
    private Message[] pendingMessages = new Message[0];


    public void addMessages(Message message){
        this.addMessages(new Message[]{message});
    }

    public void addPendingMessages(Message pendingMessages){
        this.addPendingMessages(new Message[]{pendingMessages});
    }

    public void addPendingMessages(Message[] pendingMessages){
        if (pendingMessages != null && pendingMessages.length != 0) {
            this.pendingMessages = Arrays.copyOf(this.pendingMessages, this.pendingMessages.length + pendingMessages.length);
            int pendingMessagesLength = pendingMessages.length;
            for (Message mes : pendingMessages) {
                this.pendingMessages[this.pendingMessages.length - pendingMessagesLength--] = mes;
            }
        }
    }

    public void addMessages(Message[] messages){
        if (messages != null && messages.length != 0) {
            this.messages = Arrays.copyOf(this.messages, this.messages.length + messages.length);
            int messagesLength = messages.length;
            for (Message mes : messages) {
                this.messages[this.messages.length - messagesLength--] = mes;
            }
        }
    }

    public void editMessages(User whoseMessage, String nexText){
        Date actualDate = new Date();

        for (int i = this.messages.length - 1; i >= 0; i--) {
            if (this.messages[i].getUser().equals(whoseMessage)) {
                if ((actualDate.getTime() - this.messages[i].getDate().getTime()) < 60000) {
                    this.messages[i].setMessage(nexText);
                    System.out.println("Сообщение успешно отредактировано");
                }
                System.out.println("Сообщение не может быть отредактировано. т.к. оно старше 1 минуты");
                break;
            }
        }

        System.out.println("Не было сообщений от юзера: " + whoseMessage.getLogin());
    }

    public void history(IHistorySaver saver){
        for (Message message : this.messages) {
            saver.println(message.toString());
        }

    }


}
