package homework06.messenger.loader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileLoader implements IHistoryLoader{

    @Override
    public void loadHistory(String file) {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(file), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(contentBuilder.toString());
    }
}
