package homework06.messenger.saver;

import homework06.messenger.Message;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileSaver implements IHistorySaver {

    private final File stream;


    public FileSaver(File stream) {
        this.stream = stream;
    }

    @Override
    public void println(Message[] m) {
        List<Message> messages = new ArrayList<>(Arrays.asList(m));
        try (FileOutputStream fileOut = new FileOutputStream(stream);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);) {
            messages.forEach(message -> {
                try {
                    objectOut.writeObject(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }}
