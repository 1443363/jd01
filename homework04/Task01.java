package homework04;

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
}
