package homework02;

public class Task01 {
    public void shiftRightIgnoreNextChar(int shiftedNum, int numOfShifts) {
        if (shiftedNum >= 0) {
            shiftedNum >>= numOfShifts;
            System.out.println("Результатом побитового сдвига является число: " + shiftedNum);
        } else {
            shiftedNum >>>= numOfShifts;
            System.out.println("Результатом побитового сдвига является число: " + shiftedNum);
        }
    }

    public void shiftRightIgnoreNextChar(double shiftedNum, int numOfShifts) {
        shiftedNum = (int) shiftedNum >>> numOfShifts;
        System.out.println("Результатом побитового сдвига является число: " + shiftedNum);
    }
}
