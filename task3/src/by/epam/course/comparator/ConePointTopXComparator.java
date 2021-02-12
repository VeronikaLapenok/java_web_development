package by.epam.course.comparator;

import by.epam.course.entity.Cone;
import by.epam.course.entity.ShapePoint;

import java.util.Comparator;

public class ConePointTopXComparator implements Comparator<Cone> {
  @Override
  public int compare(Cone cone1, Cone cone2) {
    ShapePoint pointTop1 = cone1.getPointTop();
    ShapePoint pointTop2 = cone2.getPointTop();
    return Double.compare(pointTop1.getX(), pointTop2.getX());
  }
}
