package homework04.tasks;

import java.util.Scanner;

public class Task01 {

    public void comparisonOfTwoLines() {
        String firstString = "Мама мыла раму";
        String secondString = "Мама" + " мыла " + "раму";
        System.out.println(firstString == secondString);
    }

    public void charOutputOfTheString() {
        String string = "Мама мыла раму";
        for (int i = 0; i < string.length(); i++) {
            System.out.println(string.charAt(i));
        }
    }

    public void displayInput() {
        Scanner scan = new Scanner(System.in);
        String input =  "";
        String stringWithResult = "";

        while (scan.hasNext() && !input.equalsIgnoreCase("exit")) {
            input = scan.next();
            if (!input.equalsIgnoreCase("exit")) {
                stringWithResult += input + " ";
            } else break;
        }
        scan.close();
        System.out.println(stringWithResult);
    }

    public void convertStringInLong() {
        String string = "012312";
        long lon1 = Long.parseLong(string);
        long lon2 = Long.decode(string);
        long lon3 = Long.valueOf(string);

        System.out.println(lon1 + " " + lon2 + " " + lon3);
    }
}
