package homework07.Task02.filter;


import java.util.Collection;

public interface IFilter<T> {
    Collection<T> filter(Collection<T> collection);
}
