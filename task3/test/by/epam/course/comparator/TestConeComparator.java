package by.epam.course.comparator;

import by.epam.course.entity.Cone;
import by.epam.course.entity.ShapePoint;

import org.testng.Assert;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestConeComparator {
  Cone cone1; 
  Cone cone2;
  Cone cone3;
  Cone cone4;
  ConeSquareComparator squareComparator;
  ConeRadiusComparator radiusComparator;
  ConePointTopXComparator pointTopXComparator;
  
  @BeforeClass
  public void setUp() {
    cone1 = new Cone(1.2, new ShapePoint(3.4, 6.7, 9.0), new ShapePoint(2.2, 1.4, 5.7));
    cone2 = new Cone(3.8, new ShapePoint(4.6, -7.5, 2.67), new ShapePoint(4.5, -3.2, -9.1));
    cone3 = new Cone(1.2, new ShapePoint(3.4, 6.7, 9.0), new ShapePoint(2.2, 1.4, 5.7));
    cone4 = new Cone(9.567, new ShapePoint(4.6, -4.65, 6.76), new ShapePoint(4.4, 7.0, 1.0));
  }
  
  @Test
  public void squareComparatorTest() {
    squareComparator = new ConeSquareComparator();
    int actual = squareComparator.compare(cone1, cone3);
    int expected = 0;
    
    Assert.assertEquals(actual, expected);
  }
  
  public void radiusComparatorTest() {
    radiusComparator = new ConeRadiusComparator();
    int actual = radiusComparator.compare(cone2, cone4);
    int expected = 1;
    
    Assert.assertEquals(actual, expected);
  }
  
  public void pointTopXComparatorTest() {
    pointTopXComparator = new ConePointTopXComparator();
    int actual = pointTopXComparator.compare(cone2, cone4);
    int expected = 0;
    
    Assert.assertEquals(actual, expected);
  }
  
  @AfterClass
  public void tierDown() {
    cone1 = null;
    cone2 = null;
    cone3 = null;
    cone4 = null;
  }
}
