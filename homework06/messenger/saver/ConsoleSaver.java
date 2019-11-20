package homework06.messenger.saver;

import homework06.messenger.Dialogs;
import homework06.messenger.Message;

import java.io.PrintStream;

public class ConsoleSaver implements IHistorySaver {

    private final PrintStream stream;
    private Dialogs dialogs;

    public ConsoleSaver(PrintStream stream) {
        this.stream = stream;
        this.dialogs = dialogs;
    }

    @Override
    public void println(Message s, Dialogs dialogs) {
        this.stream.println(s);
    }
}
