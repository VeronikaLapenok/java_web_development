package by.epam.course.comparator;

import by.epam.course.entity.Cone;

import java.util.Comparator;

public class ConeRadiusComparator implements Comparator<Cone> {
  @Override
  public int compare(Cone cone1, Cone cone2) {
    return Double.compare(cone1.getRadius(), cone2.getRadius());
  }
}
