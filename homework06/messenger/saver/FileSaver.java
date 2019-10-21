package homework06.messenger.saver;

import java.io.File;

public class FileSaver implements IHistorySaver {

    private final File stream;

    public FileSaver(File stream) {
        this.stream = stream;
    }

    @Override
    public void println(String s) {
        //....
    }
}
