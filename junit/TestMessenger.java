package junit;

import homework06.messenger.Message;
import homework06.messenger.User;
import homework06.messenger.ValidateUser;
import homework06.messenger.loader.FileLoader;
import homework06.messenger.loader.IHistoryLoader;
import homework06.messenger.saver.FileSaver;
import homework06.messenger.saver.IHistorySaver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@DisplayName("TestMessenger. Тестирование загрузки из файла и валидации пароля.")
public class TestMessenger {
    public static Queue<String> messages = new ConcurrentLinkedQueue<String>(){{
        add("привет");
        add("как дела?");
        add("как жизнь?");
        add("все пучком!");
        add("как семья?");
        add("как дети?");
        add("чем вечером занимаешься?");
        add("может по пивку?");
        add("мишка в школу уже пошел");
        add("обедаю");
    }};

    @Test
    @DisplayName("Тесты проверки загрузки из файла")
    public void loadHistoryTest(){
        IHistoryLoader fl = new FileLoader();
        IHistorySaver fs = new FileSaver(new File("testLoadHistory.txt"));
        List<Message> messagesList = Stream.generate(() -> {
            return new Message(messages.poll(), new User("Password"), new Date());
        })
                .limit(5)
                .collect(Collectors.toList());

        Message[] messagesArray1 = new Message[messagesList.size()];
        messagesList.toArray(messagesArray1);
        fs.println(messagesArray1);


        Assertions.assertEquals(messagesList.toString(), fl.loadHistory("testLoadHistory.txt").toString(), "Некорректная работа загрузчика" +
                " истории из файла");

    }

    @ParameterizedTest
    @DisplayName("Тесты проверки валидации пароля")
    @CsvSource(value = {"lo#12!giin:123login:ds"}, delimiter = ':')
    public void checkUserTest(String correctLogin, String incorrectLogin1, String incorrectLogin2) {
        User user = new User(correctLogin);
        System.out.println(ValidateUser.checkUser(user));
        boolean isValidLogin = ValidateUser.checkUser(user);
        Assertions.assertTrue(ValidateUser.checkUser(new User(correctLogin)), "Валидация прошла успешно");
        Assertions.assertFalse(ValidateUser.checkUser(new User(incorrectLogin1)), "Валидация не должна " +
                "пройти т.к. логин начинается с цифр");
        Assertions.assertFalse(ValidateUser.checkUser(new User(incorrectLogin2)), "Валидация не должна" +
                " пройти т.к. логин слишком короткий");
    }
}
