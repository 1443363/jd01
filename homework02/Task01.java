package homework02;

public class Task01 {

    public void shiftRightIgnoreNextChar(int shiftedNum, int numOfShifts) {
        shiftedNum >>>= numOfShifts;
        System.out.println("Результатом побитового сдвига является число " + shiftedNum);
    }

    public void shiftRightIgnoreNextChar(double shiftedNum, double numOfShifts) {
        int shiftedNumInInt = (int) shiftedNum;
        int numOfShiftsInInt = (int) numOfShifts;
        shiftedNumInInt >>>= numOfShiftsInInt;
        System.out.println("Результатом побитового сдвига является число " + shiftedNumInInt);
    }
}
