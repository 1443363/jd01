package homework07.Task02;

import dto.Computer;
import homework07.Task02.filter.IFilter;

import java.util.*;

public class FilterApplicator<T> {

    public Collection<T> filter(Collection<T> collection, IFilter filter) {
        return filter.filter((Collection<Computer>)collection);
    }

//    public static Collection<? extends Comparable> sort(Collection<? extends Comparable> collection) {
//
//    }
}
