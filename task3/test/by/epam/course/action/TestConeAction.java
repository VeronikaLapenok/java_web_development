package by.epam.course.action;

import by.epam.course.action.impl.ConeAction;
import by.epam.course.entity.Cone;
import by.epam.course.entity.ShapePoint;
import by.epam.course.exception.ConeException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestConeAction {
  private static Logger logger = LogManager.getLogger();
  
  Cone cone;
  ConeAction coneAction;
  ShapePoint top;
  ShapePoint bottom;
  double radius;
  
  @BeforeClass
  public void setUp() {
    coneAction = new ConeAction();
  }
  
  @Test
  public void testSquare() throws ConeException {
    logger.debug("Enter testSquare");
    
    top = new ShapePoint(2.9, 4.5, -1.6);
    bottom = new ShapePoint(2.2, -8.6, 4.0);
    radius = 4.5;
    cone = new Cone(radius, top, bottom);
    double actual = coneAction.findSquare(cone);
    double expected = 275.066;
    
    logger.debug("Actual: " + actual);
    logger.debug("Expected: " + expected);
    
    Assert.assertEquals(actual, expected, 0.0001);
    
    logger.debug("Exit testSquare");
  }
  
  @Test
  public void testVolume() throws ConeException {
    logger.debug("Enter testVolume");
    
    top = new ShapePoint(7.2, 1.4, 3.3);
    bottom = new ShapePoint(-2.5, 1.1, -3.4);
    radius = 3.6;
    cone = new Cone(radius, top, bottom);
    double actual = coneAction.findVolume(cone);
    double expected = 160.048;
    
    logger.debug("Actual: " + actual);
    logger.debug("Expected: " + expected);
    
    Assert.assertEquals(actual, expected, 0.0001);
    
    logger.debug("Exit testVolume");
  }
  
  @Test
  public void testFindHight() throws ConeException {
    logger.debug("Enter testFindHight");
    
    top = new ShapePoint(10.5, -4.3, 6.2);
    bottom = new ShapePoint(1.7, -7.3, -2.45);
    radius = 5.68;
    cone = new Cone(radius, top, bottom);
    double actual = coneAction.findHeight(cone);
    double expected = 12.6989;
    
    logger.debug("Actual: " + actual);
    logger.debug("Expected: " + expected);
    
    Assert.assertEquals(actual, expected, 0.0001);
    
    logger.debug("Exit testFindHight");
  }
  
  @Test
  public void testFindSlantHight() throws ConeException {
    logger.debug("Enter testFindSlantHight");
    
    top = new ShapePoint(0.9, 2.234, 9.1);
    bottom = new ShapePoint(-2.9, 5.3, 1.3);
    radius = 8.7;
    cone = new Cone(radius, top, bottom);
    double actual = coneAction.findSlantHeight(cone);
    double expected = 12.6637;
    
    logger.debug("Actual: " + actual);
    logger.debug("Expected: " + expected);
    
    Assert.assertEquals(actual, expected, 0.0001);
    
    logger.debug("Exit testFindSlantHight");
  }
  
  @AfterClass
  public void tierDown() {
    coneAction = null;
  }

}
