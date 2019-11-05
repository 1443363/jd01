package homework09;

import homework09.reader.FileReader;

public class Main {

    public static void main(String[] args) {
        //Создаем файл с топ100 студентов по оценкам, отсортированный по именам
        FileCreator fileCreator = new FileCreator("topStudentsFile.txt");
        fileCreator.createFileOfTopStudents();

        //Читаем данный файл в консоль, выводим только последние 34 студента
        FileReader fileReader = new FileReader();
        fileReader.read(fileCreator.getFileName());
    }
}
