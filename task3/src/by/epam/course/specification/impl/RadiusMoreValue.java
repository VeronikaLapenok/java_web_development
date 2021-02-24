package by.epam.course.specification.impl;

import by.epam.course.entity.Cone;
import by.epam.course.specification.Specification;

public class RadiusMoreValue implements Specification {
  private double radius;
  private double value;
  
  public RadiusMoreValue(double value) {
    this.value = value;
  }
  
  public boolean specify(Cone cone) {
    radius = cone.getRadius();
    
    boolean result = radius > value;
    
    return result;
  }

}
