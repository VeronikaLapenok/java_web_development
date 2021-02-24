package by.epam.course.comparator;

import by.epam.course.entity.Cone;
import by.epam.course.entity.ShapePoint;

import java.util.Comparator;

public class ConePointBottomZComparator implements Comparator<Cone> {
  @Override
  public int compare(Cone cone1, Cone cone2) {
    ShapePoint pointBottom1 = cone1.getPointBottom();
    ShapePoint pointBottom2 = cone2.getPointBottom();
    
    return Double.compare(pointBottom1.getZ(), pointBottom2.getZ());   
  }
}
