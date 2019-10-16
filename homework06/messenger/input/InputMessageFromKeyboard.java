package homework06.messenger.input;

import homework06.messenger.Dialogs;
import homework06.messenger.Message;
import homework06.messenger.User;

import java.util.Date;
import java.util.Scanner;

public class InputMessageFromKeyboard implements IInputMessage{
    Dialogs dialog;
    User user;

    public InputMessageFromKeyboard(Dialogs dialog, User user) {
        this.dialog = dialog;
        this.user = user;
    }

    public String inputMessage() {
        String message = "";
        String input = "";
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите новое сообщение, чтобы закончить ввод сообщений введите \"send\".");
        System.out.println("Чтобы отправить отложенное сообщение введите \"pending\".");

        while (scan.hasNext() && !input.equalsIgnoreCase("send") && !input.equalsIgnoreCase("pending")) {
            input = scan.nextLine();
            if (input.equalsIgnoreCase("send")) {
                break;
            } else if (input.equalsIgnoreCase("pending")) {
                inputPendingMessages();
                break;
            } else {
                dialog.addMessages(new Message(input, this.user, new Date()));
            }
        }
        return message;
    }

    public void inputPendingMessages() {
        String message = "";
        String input = "";
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите новое отложенное сообщение, чтобы закончить ввод сообщений введите \\\"send pending message\\\".");
        System.out.println("Чтобы отправить обычное сообщение введите \"simple\".");
        while (scan.hasNext() && !input.equalsIgnoreCase("send pending message") && !input.equalsIgnoreCase("simple")) {
            input = scan.nextLine();
            if (input.equalsIgnoreCase("send pending message")) {
                break;
            } else if(input.equalsIgnoreCase("simple")) {
                inputMessage();
                break;
            } else {
                dialog.addPendingMessages(new Message(input, this.user, new Date()));
            }
         }
    }

    public User getUser() {
        return user;
    }
}
