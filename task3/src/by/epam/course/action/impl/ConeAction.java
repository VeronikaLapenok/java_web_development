package by.epam.course.action.impl;

import by.epam.course.action.ShapeAction;
import by.epam.course.entity.Cone;
import by.epam.course.entity.ShapePoint;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConeAction implements ShapeAction {
  private static Logger logger = LogManager.getLogger();
  
  @Override
  public double findSquare(Cone cone) {
    double coneSquare = Math.PI * cone.getRadius() * findSlantHeight(cone) + Math.PI
        * Math.pow(cone.getRadius(), 2);
    logger.debug("Square of the cone = " + coneSquare);
    
    return coneSquare;        
  }
  
  public double findVolume(Cone cone) {
    final double COEFFICIENT = 1.0 / 3.0;
    
    double coneVolume = COEFFICIENT * Math.PI * findHeight(cone) * Math.pow(cone.getRadius(), 2);
    logger.debug("Volume of the cone = " + coneVolume);
    
    return coneVolume;
  }
  
  public double findHeight(Cone cone) {
    ShapePoint top = cone.getPointTop();
    ShapePoint bottom = cone.getPointBottom();
    double height = Math.sqrt(Math.pow((top.getX() - bottom.getX()), 2) + Math.pow((top.getY()
        - bottom.getY()), 2) + Math.pow((top.getZ() - bottom.getZ()), 2));
    
    return height;
  }
  
  public double findSlantHeight(Cone cone) {
    double slantHeight = Math.hypot(cone.getRadius(), findHeight(cone));
    
    return slantHeight;
  }

}
