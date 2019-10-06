package homework02;

public class Task03 {
    public void getGreaterNumberByTernary(int firstNum, int secondNum) {
        System.out.println("Наибольшим является число: " + (firstNum > secondNum ? firstNum : secondNum));
    }

    public void getGreaterNumberByIf(int firstNum, int secondNum) {
        if (firstNum > secondNum) {
            System.out.println("Наибольшим является число: " + firstNum);
        } else {
            System.out.println("Наибольшим является число: " + secondNum);
        }
    }

}
