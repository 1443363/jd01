package homework06.messenger.loader;

import homework06.messenger.Dialogs;
import homework06.messenger.Message;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class FileLoader implements IHistoryLoader{

//    @Override
//    public void loadHistory(String file) {
//        StringBuilder messageHistory = new StringBuilder();
//        try (Stream<String> stream = Files.lines(Paths.get(file), StandardCharsets.UTF_8)) {
//            stream.forEach(s -> messageHistory.append(s).append("\n"));
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(messageHistory.toString());
//    }

    @Override
    public List<Message> loadHistory(String file, Dialogs dialogs) {
        List<Message> messagesList = new ArrayList<>();
        try (FileInputStream fileIn = new FileInputStream(file);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn);) {
            while(fileIn.available() > 0) {
                Message message = (Message) objectIn.readObject();
                messagesList.add(message);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return messagesList;
    }
}
