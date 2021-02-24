package by.epam.course.comparator;

import by.epam.course.entity.Cone;

import java.util.Comparator;

public class ConeIdComparator implements Comparator<Cone> {
  @Override
  public int compare(Cone cone1, Cone cone2) {
    return Integer.compare(cone1.getConeId(), cone2.getConeId());
  }
}
