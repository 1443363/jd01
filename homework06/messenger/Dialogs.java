package homework06.messenger;

import java.util.Arrays;

public class Dialogs {
    private Message[] messages = new Message[0];

    public void addMessages(Message message){
        this.addMessages(new Message[]{message});
    }

    public void addMessages(Message [] messages){
        if (messages != null && messages.length != 0) {
            this.messages = Arrays.copyOf(this.messages, this.messages.length + messages.length);
            int messagesLength = messages.length;
            for (Message mes : messages) {
                this.messages[this.messages.length - messagesLength--] = mes;
            }
        }
    }

//    public Message[] getMessages() {
//        return messages;
//    }

    public void history(IHistorySaver saver){
        for (Message message : this.messages) {
            saver.println(message.toString());
        }

    }


}
