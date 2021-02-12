package by.epam.course.specification.impl;

import by.epam.course.entity.Cone;
import by.epam.course.specification.Specification;

public class IdSpecification implements Specification {
  private int coneId;
  
  public IdSpecification(int coneId) {
    this.coneId = coneId;
  }
  
  @Override
  public boolean specify(Cone cone) {
    boolean result = cone.getConeId() == coneId;
    
    return result;
  }
}
