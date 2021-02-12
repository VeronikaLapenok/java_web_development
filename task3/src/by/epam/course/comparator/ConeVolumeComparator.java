package by.epam.course.comparator;

import by.epam.course.action.impl.ConeAction;
import by.epam.course.entity.Cone;

import java.util.Comparator;

public class ConeVolumeComparator implements Comparator<Cone> {
  @Override
  public int compare(Cone cone1, Cone cone2) {
    ConeAction coneAction = new ConeAction();
    int result = Double.compare(coneAction.findVolume(cone1), coneAction.findVolume(cone2));
    
    return result;
  }
}
