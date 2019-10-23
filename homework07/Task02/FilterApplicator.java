package homework07.Task02;

import dto.Computer;
import homework07.Task02.filter.IFilter;

import java.util.*;

public class FilterApplicator<T> {

    public <T> Collection<T> filter(Collection<T> collection, IFilter filter) {
        return filter.filter((Collection<Computer>)collection);
    }


}
