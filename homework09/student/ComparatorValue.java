package homework09.student;

import java.util.Comparator;

public class ComparatorValue implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if(o1.getAvgValue() < o2.getAvgValue()) return -1;
        if(o1.getAvgValue() == o2.getAvgValue()) return 0;
        return 1;
    }
}
