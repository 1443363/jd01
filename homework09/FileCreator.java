package homework09;

import homework09.reader.FileReader;
import homework09.student.ComparatorName;
import homework09.student.ComparatorValue;
import homework09.student.Person;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileCreator {
    private String fileName = "";

    public FileCreator(String fileName) {
        this.fileName = fileName;
    }

    public void createFileOfTopStudents() {
        String[] masOfNames = {"Леша", "Миша", "Саша", "Антон", "Гена", "Дима", "Света", "Аня", "Оля",
                "Соня", "Диана", "Вика"};
        TreeMap<Integer, Person> students = Stream.generate(() -> {
            int i = new Random().nextInt();
            String name = masOfNames[(int) (Math.random() * 12)];
            float score = (float) (Math.round((Math.random() * 10) * 100.0) / 100.0);
            return new Person(i, name, score);
        })
                .limit(10_000)
                .collect(Collectors.toMap(Person::getId, p -> p, (s1, s2) -> s1, TreeMap::new));

        List<String> topStudents = new ArrayList<>();

        students.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(new ComparatorValue().reversed()))
                .limit(100)
                .sorted(Map.Entry.comparingByValue(new ComparatorName()))
                .forEach(p -> topStudents.add(p.getValue().toString()));

        try {
            FileOutputStream fos = new FileOutputStream(this.fileName);
            DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fos));

            for (String str : topStudents) {
                outStream.writeUTF(str + "\n");
            }

            outStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}