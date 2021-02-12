package by.epam.course.factory;

import by.epam.course.entity.Shape;
import by.epam.course.entity.ShapePoint;
import by.epam.course.exception.ConeException;

public interface ShapeFactory {
  Shape createShape(double radius, ShapePoint top, ShapePoint bottom) throws ConeException;
}
