package homework08.tasks;

import homework08.exceptions.DivideByZeroException_v1;

public class Task02dot1 {

    public static void main(String[] args) {
        try {
            divideInt(0);
        } catch (DivideByZeroException_v1 e) {
            e.printStackTrace(); // будет выбрашена ошибка DivideByZeroException_v1
        }
    }

    public static void divideInt(int num) throws DivideByZeroException_v1 {
        int dividedInt = 6;

        if (num == 0) {
            throw new DivideByZeroException_v1("Cannot be divide by zero!");
        }

        System.out.println("Результатом деления является число: " + dividedInt / num);
    }
}
