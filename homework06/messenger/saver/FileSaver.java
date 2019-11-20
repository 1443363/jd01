package homework06.messenger.saver;

import homework06.messenger.Dialogs;
import homework06.messenger.Message;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileSaver implements IHistorySaver {

    private final File stream;


    public FileSaver(File stream) {
        this.stream = stream;
    }

//    @Override
//    public void println(String s, Dialogs dialogs) {
//        try (PrintWriter out = new PrintWriter(
//                new BufferedWriter(new FileWriter(stream, true)));) {
//            out.println(s);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public void println(Message s, Dialogs dialogs) {
        List<Message> messagesList = new ArrayList<>(Arrays.asList(dialogs.getMessages()));
        try (FileOutputStream fileOut = new FileOutputStream(stream);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);) {
            messagesList.forEach(m -> {
                try {
                    objectOut.writeObject(m);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }}
