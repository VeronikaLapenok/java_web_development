package by.epam.course.specification.impl;

import by.epam.course.entity.Cone;
import by.epam.course.entity.ShapePoint;
import by.epam.course.specification.Specification;

public class PointsInTheFirstQuadrant implements Specification {
  private ShapePoint pointTop;
  private ShapePoint pointBottom;
  
  public boolean specify(Cone cone) {
    pointTop = cone.getPointTop();
    pointBottom = cone.getPointBottom();
    
    boolean result = pointTop.getX() > 0 && pointTop.getY() > 0 && pointTop.getZ() > 0
        && pointBottom.getX() > 0 && pointBottom.getY() > 0 && pointBottom.getZ() > 0;
    
    return result;
  }
}
