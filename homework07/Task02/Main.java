package homework07.Task02;

import dto.Computer;
import homework07.Task02.creator.CollectionsCreator;
import homework07.Task02.filter.FilterComputer;

import java.util.Collection;
import java.util.List;

public class Main<T> {

    /*Метод createComputersCollection создает коллекцию
      из 10 элементов с типом "Computer" */
    public static void main(String[] args) {
        FilterApplicator filterApplicator = new FilterApplicator();
        Collection<?> collection1 = filterApplicator.filter(CollectionsCreator.createComputersCollection(),
                new FilterComputer());

        System.out.println("Ниже будут отображены отфильтрованные элементы " +
                "коллекции компьютера(те у которых RAM >= 50) : ");
        collection1.forEach(System.out::println);

        Collection<? extends Comparable> collection2 = filterApplicator.sort(CollectionsCreator.
                createStudentsCollection());
          System.out.println("Ниже будут отображены отсортированные элементы коллекции студента (по возрасту) : ");
          collection2.forEach(System.out::println);
    }


}
