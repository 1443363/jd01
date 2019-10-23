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
        Collection<?> collection = filterApplicator.filter(CollectionsCreator.createComputersCollection(),
                new FilterComputer());

//        System.out.println("Ниже будут отображены отфильтрованные элементы коллекции (те у которых RAM >= 50) : ");
//        collection.forEach(System.out::println);

        CollectionsCreator.createStudentsCollection();
    }


}
