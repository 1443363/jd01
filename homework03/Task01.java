package homework03;

public class Task01 {
    private int multiplicationResult;
    private String numbers;
    public void viewMultiplicationTable() {
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                System.out.println(i + " * " + j + " = " + (i * j));
            }
        }
    }

    public void multiplicationOfNumbers(int num) {
        multiplicationResult = 1;
        for (int i = 1; i <= num; i++) {
            System.out.print(multiplicationResult + " * " + i);
            multiplicationResult = multiplicationResult * i;
            System.out.println(" = " + multiplicationResult);
        }
    }

    public void multipicationofNumericFromNumber(int num) {
        numbers = String.valueOf(num);
        int multiplicationResult = 1;

        for (int i = 0; i < numbers.length(); i++) {
            System.out.print(multiplicationResult + " * " + numbers.charAt(i));
            multiplicationResult = multiplicationResult * Character.getNumericValue(numbers.charAt(i));
            System.out.println(" = " + multiplicationResult);
        }
    }
}
