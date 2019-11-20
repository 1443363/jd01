package homework06.messenger.loader;

import homework06.messenger.Dialogs;
import homework06.messenger.Message;

import java.util.List;

public interface IHistoryLoader {
    List<Message> loadHistory(String file, Dialogs dialogs);
}
