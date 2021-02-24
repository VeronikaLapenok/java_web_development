package by.epam.course.specification.impl;

import by.epam.course.action.ShapeAction;
import by.epam.course.action.impl.ConeAction;
import by.epam.course.entity.Cone;
import by.epam.course.specification.Specification;

public class SquareRangeSpecification implements Specification {
  private double squareFrom;
  private double squareTo;
  
  public SquareRangeSpecification(double squareFrom, double squareTo) {
    this.squareFrom = squareFrom;
    this.squareTo = squareTo;
  }
  
  @Override
  public boolean specify(Cone cone) {
    ShapeAction shapeAction = new ConeAction();
    double coneSquare;
    boolean result;
    
    coneSquare = shapeAction.findSquare(cone);
    result = coneSquare >= squareFrom && coneSquare <= squareTo;
    
    return result;
  }
  
}
