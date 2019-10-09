package homework04;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Task01 task01 = new Task01();
//        task01.comparisonOfTwoLines();
//        task01.charOutputOfTheString();
//        task01.displayInput();
//        task01.convertStringInLong();

        Task02 task02 = new Task02();
//        task02.searchInString();
        String string = "Я люблю JAVA";
        System.out.println(string.matches("любл*"));
        Pattern p = Pattern.compile("A??");
        Matcher m = p.matcher(string);
        System.out.println();
}
}
