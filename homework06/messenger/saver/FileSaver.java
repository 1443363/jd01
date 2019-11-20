package homework06.messenger.saver;

import java.io.*;

public class FileSaver implements IHistorySaver {

    private final File stream;

    public FileSaver(File stream) {
        this.stream = stream;
    }

    @Override
    public void println(String s) {
        try (PrintWriter out = new PrintWriter(
                new BufferedWriter(new FileWriter(stream, true)));) {
            out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
