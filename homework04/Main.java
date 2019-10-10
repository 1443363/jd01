package homework04;

import homework04.dto.File;
import homework04.dto.WordForSearch;
import homework04.finders.SimpleWordFinder;
import homework04.finders.RegWordFinder;
import homework04.tasks.Task01;
import homework04.tasks.Task021;

//Первым аргументом программы необходимо передать искомое слово, затем местонахождение файла
public class Main {

    public static void main(String[] args) {
        Task01 task01 = new Task01();
        task01.comparisonOfTwoLines();
        task01.charOutputOfTheString();
        task01.displayInput();          // необходимо ввести значения с клавиатуры, для выхода применить "exit".
        task01.convertStringInLong();

        Task021 task021 = new Task021();
        task021.incorrectSearchInString();
        task021.correctSearchInString("h+"); //false т.к. != условие "встречается 1++ раз)
        task021.correctSearchInString("h*"); //true т.к == условие "встречается 0++ раз)
        task021.correctSearchInString("h?"); // true т.к. находит 1 раз и на этом поиск заканчивается т.е == 0 | 1

        WordForSearch wordForSearch = new WordForSearch(args[0]);
        File file = new File(args[1]);
        RegWordFinder regWordFinder = new RegWordFinder(wordForSearch, file);
        regWordFinder.countOfWordsInFile();
        SimpleWordFinder swf = new SimpleWordFinder(wordForSearch, file);
        swf.countOfWordsInFile();
    }
}
