package homework06;

import homework06.messenger.*;
import homework06.messenger.input.InputMessageFromKeyboard;

import java.util.Date;


public class Messenger {
    /**Мессенджер
     * 1. Вводить ник:
     *  1.1 Должен быть только латинскими буквами
     *  1.2 Должен быть не меньше 5 символов
     *  1.3 Не должен начинаться с цифры
     *  1.4 Не должен содержать #,!,\
     * 2. Сообщения вводятся через консоль
     * 3. Сообщения хранятся в массиве
     * 4. Можно отредактировать своё сообщение если оно не старше минуты
     * 5. Можно писать отложенные сообщения
     **/
    public static User getValidUser(){
        User user = null;
        boolean flag = false;
        do{
            user = new User ("login1", "password1");
            flag = ValidateUser.checkUser(user);
            if (!flag) {
                System.out.println("Invalid login for user!");
            }
        } while (!flag);
        return user;
    }

    public static void main(String[] args) {
        User user1 = getValidUser();
        Dialogs dialogs = new Dialogs();
        InputMessageFromKeyboard inputMessageFromKeyboard = new InputMessageFromKeyboard(dialogs, getValidUser());
        inputMessageFromKeyboard.inputMessage();
        dialogs.history(new ConsoleSaver(System.out));
        dialogs.editMessages(inputMessageFromKeyboard.getUser());
        dialogs.history(new ConsoleSaver(System.out));

    }
}
