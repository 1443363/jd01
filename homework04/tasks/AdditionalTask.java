package homework04.tasks;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class AdditionalTask {
    public static void main(String []args){
        String pattern_phone = "\\+?\\d{1,3}\\s?\\(?\\d{1,3}\\)?\\s?\\d{2,4}-?\\s?\\d{1,4}-?\\s?\\d{1,2}?";
        Pattern pattern = Pattern.compile(pattern_phone);
        String[] telefon = new String[]{
                "+375 29 5553628", "I love you",
                "+375(29)5553628", "80293338092",
                "+375(29)444-99-02", "+7(129)444-99-02",
                "+1 415 235 5512", "+47 2243 6542",
                "+33 (1) 5433 6431", "+41225436311",
                "+27 21 316 7542"
        };

        for (String tel: telefon
        ) {
            System.out.println(tel);
            Matcher matcher = pattern.matcher(tel);
            System.out.println(matcher.find());

        }
    }
}