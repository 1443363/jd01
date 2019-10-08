package homework03;

import java.util.Random;

//элементами массива будут нули, т.к. не было задания заполнить массив, а только перебрать.

public class Task02 {
    private int[] masOfNumbers;
    private Integer[] masOfNumbersAndNulls;
    private int i;

    public void iterateElementsByDoWhile(int numOfElements) {
        masOfNumbers = new int[numOfElements];
        i = 0;

        if (numOfElements < 0) {
            System.out.println("NegativeArraySizeException. Parametr should be positive!");
        } else {
            do {
                System.out.println((i + 1) + " элемент массива хранит в себе значение: " + masOfNumbers[i]);
                i++;
            } while (i < masOfNumbers.length);
        }
    }

    public void iterateElementsByWhile(int numOfElements) {
        masOfNumbers = new int[numOfElements];
        i = 0;

        if (numOfElements < 0) {
            System.out.println("NegativeArraySizeException. Parametr should be positive!");
        } else {
            while (i < masOfNumbers.length) {
                System.out.println((i + 1) + " элемент массива хранит в себе значение: " + masOfNumbers[i]);
                i++;
            }
        }
    }

    public void iterateElementsByFor(int numOfElements) {
        masOfNumbers = new int[numOfElements];

        if (numOfElements < 0) {
            System.out.println("NegativeArraySizeException. Parametr should be positive!");
        } else {
            for (int i = 0; i < masOfNumbers.length; i++) {
                System.out.println((i + 1) + " элемент массива хранит в себе значение: " + masOfNumbers[i]);
            }
        }
    }

    public void iterateElementsByForEach(int numOfElements) {
        masOfNumbers = new int[numOfElements];
        i = 1;

        if (numOfElements < 0) {
            System.out.println("NegativeArraySizeException. Parametr should be positive!");
        } else {
            for (int element : masOfNumbers) {
                System.out.println(i + " элемент массива хранит в себе значение: " + element);
                i++;
            }
        }
    }

    public void displayElementsThroughOne(int numOfElements) {
        masOfNumbers = new int[numOfElements];

        if (numOfElements < 0) {
            System.out.println("NegativeArraySizeException. Parametr should be positive!");
        } else {
            for (int i = 1 ; i < numOfElements; i+=2) {
                System.out.println((i + 1) + " элемент массива хранит в себе значение: " + masOfNumbers[i]);
            }
        }
    }

    /**ничего не выведет в консоль т.к. по умолчанию элементы массива инициализируются наллами ( = null).
    можно было добавить "masOfNumbersAndNulls[i] = i" в цикл, но небыло задания проинициализировать элементы.
     */
    public void displayElementsThroughOneWithoutNull(Integer numOfElements) {
        masOfNumbersAndNulls = new Integer[numOfElements];

        if (numOfElements < 0) {
            System.out.println("NegativeArraySizeException. Parametr should be positive!");
        } else {
            for (int i = 1 ; i < numOfElements; i += 2) {
                if (masOfNumbersAndNulls[i] != null) {
                    System.out.println((i + 1) + " элемент массива хранит в себе значение: " + masOfNumbers[i]);
                } else {
                    break;
                }
            }
        }
    }


}
