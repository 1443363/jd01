package homework06.messenger.saver;

import homework06.messenger.Dialogs;
import homework06.messenger.Message;

public interface IHistorySaver {
    void println(Message s, Dialogs dialogs);
}
