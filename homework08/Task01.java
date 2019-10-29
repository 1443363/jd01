package homework08;

public class Task01 {
    int a = 3, b = 0, c;

    //Ошибка "деление на ноль" будет обработана, выполнится код в блоке "catch"
    public void divideByZeroTryCatchConstruction() {
        try {
            c = a / b;
        } catch (ArithmeticException e) {
            System.out.println("Было обнаружено деление на ноль (конструкция try-catch)");
        }
    }

    /**
     * Ошибка "деление на ноль" не будет обработана, т.к. отсутствует блок "catch
     * Приложение упадет с ошибкой, далее выполнится код в блоке "finally" (т.к. всегда выполняется,
     * исключение System.exit и еще одно)
     */

    public void divideByZeroTryFinallyConstruction() {
        try {
            c = a / b;
        } finally {
            System.out.println("Было обнаружено деление на ноль (конструкция try-finally)");
        }
    }

    /**
     * Ошибка "деление на ноль" будет обработана, выполнится код в блоке "catch"
     * Далее выполнится код в блоке "finally"
     */
    public void divieByZeroTryCatchFinallyConstruction () {
        try {
            c = a / b;
        } catch (ArithmeticException e) {
            System.out.println("Было обнаружено деление на ноль (конструкция try-catch-finally), блок catch");
        } finally {
            System.out.println("Было обнаружено деление на ноль (конструкция try-catch-finally), блок finally");
        }
    }
}
