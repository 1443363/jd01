package homework08.tasks;

import java.util.Arrays;
import java.util.Scanner;

public class Task03 {
    private int[] masOfInt = new int[0];

    public void inputIntFromKeyaboard() throws InterruptedException {
        int countOfMistakes = 2;
        int i = 0;

        while (countOfMistakes >= 0) {
            Scanner scanner = new Scanner(System.in);
            try {
                if (scanner.hasNextInt()) {
                    if (i > masOfInt.length - 1) {
                        masOfInt = Arrays.copyOf(masOfInt, masOfInt.length + 1);
                    }
                }

                masOfInt[i] = Integer.valueOf(scanner.next());
                i++;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                Thread.sleep(1000);
                System.out.println("Было введено некорректное значение, осталось попыток: " + countOfMistakes);
                countOfMistakes--;
                if (countOfMistakes < 0) {
                    scanner.close();
                }
            }
        }
    }

    public int[] getMasOfInt() {
        return masOfInt;
    }
}
