package homework06;

import homework06.messenger.*;
import homework06.messenger.input.InputMessageFromKeyboard;
import homework06.messenger.loader.FileLoader;
import homework06.messenger.saver.ConsoleSaver;
import homework06.messenger.saver.FileSaver;

import java.io.File;


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
    public static User getValidUser(User user){
        boolean flag = false;
        do{
            user.setLogin();
            flag = ValidateUser.checkUser(user);
            if (!flag) {
                System.out.println("Некорректный логин пользователя!");
            }
        } while (!flag);
        return user;
    }

    public static void main(String[] args) {
        //Удаляем файл, чтобы сохранялись данные в файл только о новом диалоге
        File file = new File("messagesHistory.txt");
        file.delete();
        User firstUser = new User("password1");
        User secondUser = new User("password2");
        FileLoader fl = new FileLoader();

        Dialogs dialogs = new Dialogs();
        InputMessageFromKeyboard inputMessageFromKeyboard = new InputMessageFromKeyboard(dialogs, getValidUser(firstUser));
        inputMessageFromKeyboard.inputMessage();
        dialogs.history(new ConsoleSaver(System.out));
        dialogs.history(new FileSaver(new File("messagesHistory.txt")));
        dialogs.editMessages(inputMessageFromKeyboard.getUser());
        dialogs.history(new ConsoleSaver(System.out));
        dialogs.history(new FileSaver(new File("messagesHistory.txt")));
        System.out.println("Выгружаем сообщения из файла: ");
        System.out.println(fl.loadHistory("messagesHistory.txt", dialogs).toString());

    }
}
