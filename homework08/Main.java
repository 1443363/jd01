package homework08;

import homework08.tasks.Task01;
import homework08.tasks.Task03;
import homework08.tasks.Task04;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Task01 task01 = new Task01();
        task01.divideByZeroTryCatchConstruction();
        task01.divideByZeroTryFinallyConstruction();
        task01.divieByZeroTryCatchFinallyConstruction();

        Task03 task03 = new Task03();
        task03.inputIntFromKeyaboard();

        Task04 task04 = new Task04();
        task04.parseAndSortMasInList(task03.getMasOfInt());
    }
}
