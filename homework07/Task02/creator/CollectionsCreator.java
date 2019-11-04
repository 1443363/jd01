package homework07.Task02.creator;

import dto.Computer;
import dto.Hdd;
import dto.Ram;
import homework07.Task02.Student;

import java.util.ArrayList;
import java.util.List;

//Класс для создания коллекций
public class CollectionsCreator{

    //Этим методом сосздаем коллекцию из 10 элементов с типо "Computer"
    public static List<Computer> createComputersCollection() {
        List<Computer> computers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            computers.add(new Computer(new Ram((int)(Math.random() * ((100 - 1) + 1)) + 1),
                    new Hdd((int)(Math.random() * ((100 - 1) + 1)) + 1)));
        }

        System.out.println("Коллекция созданная методом createComputersCollection()" +
                " включает в себя следующие элементы: \n" + computers);
        return computers;
    }

    //Этим методом сосздаем коллекцию из 10 элементов с типо "Student"
    public static List<Student> createStudentsCollection() {
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            students.add(new Student(((int)(Math.random() * ((35 - 15) + 1)) + 15),
                    "Студент"));
        }

        System.out.println("Коллекция созданная методом createStudentsCollection()" +
                " включает в себя следующие элементы: \n" + students);
        return students;
    }

}
