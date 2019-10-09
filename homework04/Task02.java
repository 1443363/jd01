package homework04;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task02 {

    public void searchInString() {
        String  string = "Я люблю JAVA";

        Pattern p = Pattern.compile("л+");
        Matcher m = p.matcher("Я люблю JAVA");
        System.out.println(m.matches());
        System.out.println();
    }
}
