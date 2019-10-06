package homework02;

public class Task02 {
    /* операторы длинной схеым &, |, ^ используется для побитовых операция.
    Неудобно использовать для логических операция т.к. проверяется условия, как справа от оператора, так и слева, что может вызывать ошибки.
    В отличии от операторов короткой схемы (&&, ||, ^^), которые в случае ложного левого условия - правое проверять не будут. */

    public void ANDBitwiseOperation(int firstNum, int secondNum) {
        System.out.println("Результатом битовой операции AND является значение: " + (Integer.valueOf(Integer.toBinaryString(firstNum))
                & Integer.valueOf(Integer.toBinaryString(secondNum))));
    }

    public void ORBitwiseOperation(int firstNum, int secondNum) {
        System.out.println("Результатом битовой операции OR является значение: " + (Integer.valueOf(Integer.toBinaryString(firstNum))
                | Integer.valueOf(Integer.toBinaryString(secondNum))));
    }

    public void XORBitwiseOperation(int firstNum, int secondNum) {
        System.out.println("Результатом битовой операции XOR является значение: " + (Integer.valueOf(Integer.toBinaryString(firstNum))
                ^ Integer.valueOf(Integer.toBinaryString(secondNum))));
    }

    public void ANDLogicalOperation(boolean firstValue, boolean secondValue) {
        System.out.println("Результатом логической операции AND является значение: " + (firstValue && secondValue));
    }

    public void ORLogicalOperation(boolean firstValue, boolean secondValue) {
        System.out.println("Результатом логической операции OR является значение: " + (firstValue || secondValue));
    }
}
