package by.epam.course.comparator;

import java.util.Comparator;

import by.epam.course.entity.Person;

public class IdComparator implements Comparator<Person>{
  @Override
  public int compare(Person p1, Person p2) {
    int idPerson1 = p1.getPersonId();
    int idPerson2 = p2.getPersonId();
    return idPerson1 - idPerson2;
  }
}
