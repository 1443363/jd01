//package junit;
//
//import homework06.messenger.Message;
//import homework06.messenger.User;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.params.ParameterizedTest;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Queue;
//import java.util.concurrent.ConcurrentLinkedQueue;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//@DisplayName("TestFileLoader. Тестирование загрузки из файла.")
//public class TestFileLoader {
//    public static Queue<String> messages = new ConcurrentLinkedQueue<String>(){{
//        add("привет");
//        add("как дела?");
//        add("как жизнь?");
//        add("все пучком!");
//        add("как семья?");
//        add("как дети?");
//        add("чем вечером занимаешься?");
//        add("может по пивку?");
//        add("мишка в школу уже пошел");
//        add("обедаю");
//    }};
//
//    @ParameterizedTest
//    @DisplayName("Тесты проверки загрузки из файла")
//    public void loadHistoryTest(){
//        List<Message> messagesList = Stream.generate(() -> {
//            return new Message(messages.poll(), new User("Password"), new Date());
//        })
//                .limit(5)
//                .collect(Collectors.toList());
//
//        Assertions.assertEquals();
//    }
//}
