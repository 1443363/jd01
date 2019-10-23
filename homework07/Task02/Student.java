package homework07.Task02;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private int age;
    private String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }


    @Override
    public int compareTo(Student o) {
        if(this.getAge() > o.getAge()) return 1;
        if(this.getAge() < o.getAge()) return -1;
        return 0;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return age == student.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }

    public int getAge() {
        return age;
    }

}
