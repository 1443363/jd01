package homework08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task03 {
    private int[] masOfInt = new int[1];

    public void inputIntFromKeyaboard() {
        int countOfMistakes = 2;
        int i = 0;

        try (Scanner scanner = new Scanner(System.in);) {
            while (countOfMistakes >= 0) {
                if (scanner.hasNextInt()) {
                    if (i > masOfInt.length - 1) {
                        masOfInt = Arrays.copyOf(masOfInt, masOfInt.length + 1);
                    }
                    masOfInt[i] = Integer.valueOf(scanner.next());
                    i++;
                } else {
                    System.out.println("Было введено некорректное значение, осталось попыток: " + countOfMistakes);
                    countOfMistakes--;
                    scanner.next();
                }
            }

            throw new NumberFormatException("Было введено некорректное значение более трех раз!");
        } catch (NumberFormatException e) {
            System.out.println("Введенные значения успешно записаны в массив!");
            e.printStackTrace();
        }
    }

    public int[] getMasOfInt() {
        return masOfInt;
    }
}
