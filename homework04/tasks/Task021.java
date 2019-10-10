package homework04.tasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task021 {
    /**
     * при выполнении метода string.matches("h+"/"h*"/"h?") всегда будет возвращаться значение false,
     * т.к. метод matches в классе string сравнивает строку с передаваемым шаблоном целиком.
     * В отличии от Matcher.find который пытается найти данный шаблон внутри строки.
     */
    public void incorrectSearchInString() {
        String  string = "Я люблю JAVA";

        System.out.println(string.matches("h+"));
        System.out.println(string.matches("h*"));
        System.out.println(string.matches("h?"));
    }

    public void correctSearchInString(String searchPattern) {
       Pattern p = Pattern.compile(searchPattern);
       Matcher m = p.matcher("Я люблю JAVA");
       System.out.println(m.find());
    }
}
