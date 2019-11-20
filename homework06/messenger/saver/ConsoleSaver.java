package homework06.messenger.saver;

import homework06.messenger.Message;

import java.io.PrintStream;

public class ConsoleSaver implements IHistorySaver {

    private final PrintStream stream;

    public ConsoleSaver(PrintStream stream) {
        this.stream = stream;
    }

    @Override
    public void println(Message[] s) {
        this.stream.println(s.toString());
    }
}
