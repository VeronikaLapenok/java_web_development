package by.epam.course.run;

import by.epam.course.comparator.IdComparator;
import by.epam.course.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<Student> students = new ArrayList<>();
    students.add(new Student(17, "Лапенок"));
    students.add(new Student(45, "Шабохова"));
    students.add(new Student(5, "Лаюшко"));
    students.add(new Student(28, "Сухоруков"));
    students.sort(new IdComparator());
    System.out.println(students.toString());
  }
}
