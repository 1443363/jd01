package homework02;

public class main {

    public static void main(String[] args) {
        Task01 task01 = new Task01();
        task01.shiftRightIgnoreNextChar(255, 5);
        task01.shiftRightIgnoreNextChar(255.77, 5);
        task01.shiftRightIgnoreNextChar(-1, 24);

        Task02 task02 = new Task02();
        task02.ANDBitwiseOperation(7,8);
        task02.ORBitwiseOperation(8,13);
        task02.XORBitwiseOperation(33,54);
        task02.ANDLogicalOperation(true, false);
        task02.ORLogicalOperation(true, false);

        Task03 task03 = new Task03();
        task03.getGreaterNumberByTernary(4, 6);
        task03.getGreaterNumberByIf(6, 7);

        Task04 task04 = new Task04();
        task04.exampleInstanceOfOperator01();
        task04.exampleInstanceOfOperator02();

        Task05 task05 = new Task05();
        task05.testOperatorPriority();
    }
}
