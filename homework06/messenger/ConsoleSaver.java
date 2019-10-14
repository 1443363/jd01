package homework06.messenger;

import java.io.PrintStream;

public class ConsoleSaver implements IHistorySaver {

    private final PrintStream stream;

    public ConsoleSaver(PrintStream stream) {
        this.stream = stream;
    }

    @Override
    public void println(String s) {
        this.stream.println(s);
    }
}
