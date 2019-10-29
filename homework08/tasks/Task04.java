package homework08.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task04 {

    public void parseAndSortMasInList(int[] masOfNumbers) {
        List<Integer> listOfNumbers = new ArrayList<Integer>(masOfNumbers.length);
        for (int num: masOfNumbers) {
            listOfNumbers.add(num);
        }

        Collections.sort(listOfNumbers);
        System.out.println("Отсортированные значения в виде листа: ");
        listOfNumbers.forEach(System.out::println);
    }
}
