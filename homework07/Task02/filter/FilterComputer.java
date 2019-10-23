package homework07.Task02.filter;

import dto.Computer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

//Отфильтровываются только те компьютеры из коллекции, у которых RAM size >= 50;
public class FilterComputer implements IFilter<Computer> {

    public Collection<Computer> filter(Collection<Computer> collection) {
        Collection<Computer> filteredComputers = new ArrayList<Computer>();
        Computer computer = null;
        Iterator iterator = collection.iterator();

        while (iterator.hasNext()) {
            computer = (Computer) iterator.next();

            if (computer.getRam().getSize() >= 50) {
                filteredComputers.add(computer);
            }
        }

        return filteredComputers;
    }
}
