package by.epam.course.specification.impl;

import by.epam.course.action.impl.ConeAction;
import by.epam.course.entity.Cone;
import by.epam.course.specification.Specification;


public class VolumeRangeSpecification implements Specification {
  private double volumeFrom;
  private double volumeTo;
  
  public VolumeRangeSpecification(double volumeFrom, double volumeTo) {
    this.volumeFrom = volumeFrom;
    this.volumeTo = volumeTo;
  }
  
  @Override
  public boolean specify(Cone cone) {
    ConeAction coneAction = new ConeAction();
    double coneSquare;
    boolean result;
    
    coneSquare = coneAction.findVolume(cone);
    result = coneSquare >= volumeFrom && coneSquare <= volumeTo;
    
    return result;
  }
}
