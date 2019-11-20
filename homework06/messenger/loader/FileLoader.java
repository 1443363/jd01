package homework06.messenger.loader;

import homework06.messenger.Message;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class FileLoader implements IHistoryLoader{

    @Override
    public List<Message> loadHistory(String file) {
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
