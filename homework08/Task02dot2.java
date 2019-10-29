package homework08;

import homework08.exceptions.DivideByZeroException_v2;

public class Task02dot2 extends Task02dot1 {

    public static void main(String[] args) {
        try {
            divideInt(0);
        } catch (DivideByZeroException_v2 e) {
            e.printStackTrace(); // будет выбрашена ошибка DivideByZeroException_v2
        }
    }

    public static void divideInt(int num) throws DivideByZeroException_v2 {
        int dividedInt = 6;

        if (num == 0) {
            throw new DivideByZeroException_v2("Cannot be divide by zero!");
        }

        System.out.println("Результатом деления является число: " + dividedInt / num);
    }
}
