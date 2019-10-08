package homework03;

public class Main {
    public static void main(String[] args) {
        Task01 task01 = new Task01();
        task01.viewMultiplicationTable();
        task01.multiplicationOfNumbers(Integer.parseInt(args[0]));
        task01.multipicationofNumericFromNumber(Integer.parseInt(args[1]));

        Task02 task02 = new Task02();
        task02.iterateElementsByDoWhile(3);
        task02.iterateElementsByWhile(3);
        task02.iterateElementsByFor(5);
        task02.iterateElementsByForEach(3);
        task02.displayElementsThroughOneWithoutNull(7);

        Task03 task03 = new Task03();
        task03.displayMasOfTheRandomObjects(55);
    }
}
