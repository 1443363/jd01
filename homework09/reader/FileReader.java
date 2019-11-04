package homework09.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader implements IReader {
    @Override
    public void read() {
        try (Stream<String> stream = Files.lines(Paths.get("topStudentsFile.txt"))) {
            List<String> list = stream.collect(Collectors.toList());
            Collections.reverse(list);
            list.stream()
                    .limit(34)
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
