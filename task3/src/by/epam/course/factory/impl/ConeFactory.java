package by.epam.course.factory.impl;

import by.epam.course.entity.Cone;
import by.epam.course.entity.Shape;
import by.epam.course.entity.ShapePoint;
import by.epam.course.exception.ConeException;
import by.epam.course.factory.ShapeFactory;
import by.epam.course.validation.ConeValidation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConeFactory implements ShapeFactory {
  private static Logger logger = LogManager.getLogger();
  
  @Override
  public Shape createShape(double radius, ShapePoint top, ShapePoint bottom) throws ConeException {
    if (top == null || bottom == null) {
      throw new ConeException("Point is null");
    }
    Cone cone = new Cone(radius, top, bottom);
    
    if (!ConeValidation.isConeValid(cone)) {
      throw new ConeException("Shape is not a cone");
    }
    logger.debug(cone.toString());
    return cone;
  }
}
