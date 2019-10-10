package homework04;

import homework04.tasks.Task01;
import homework04.tasks.Task021;

public class Main {

    public static void main(String[] args) {
        Task01 task01 = new Task01();
//        task01.comparisonOfTwoLines();
//        task01.charOutputOfTheString();
//        task01.displayInput();
//        task01.convertStringInLong();

        Task021 task021 = new Task021();
//        task021.incorrectSearchInString();
//        task021.correctSearchInString("h+"); //false т.к. != условие "встречается 1++ раз)
//        task021.correctSearchInString("h*"); //true т.к == условие "встречается 0++ раз)
//        task021.correctSearchInString("h?"); // true т.к. находит 1 раз и на этом поиск заканчивается т.е == 0 | 1
    }
}
