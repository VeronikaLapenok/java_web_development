package test.epam.course.action;

import by.epam.course.action.ArithmeticalAction;
import by.epam.course.entity.Array;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ArithmeticalTest {
  ArithmeticalAction arithmeticalAction;
  
  @BeforeClass
  public void setUp() {
    arithmeticalAction = new ArithmeticalAction();
  }
  
  @Test (dataProvider = "minData")
  public void testMin(int expected, int [] actualArray) {
    Array array = new Array(actualArray);  
    int actual = arithmeticalAction.min(array);
    
    Assert.assertEquals(actual, expected);
  }
  
  @Test (dataProvider = "maxData")
  public void testMax(int expected, int [] actualArray) {
    Array array = new Array(actualArray);  
    int actual = arithmeticalAction.max(array);

    Assert.assertEquals(actual, expected);
  }
  
  @Test (dataProvider = "averageData")
  public void testAverage(double expected, int [] actualArray) {
    Array array = new Array(actualArray);  
    double actual = arithmeticalAction.average(array);

    Assert.assertEquals(actual, expected, 0.001);
  }
  
  @Test (dataProvider = "sumData")
  public void testSum(int expected, int [] actualArray) {
    Array array = new Array(actualArray);  
    int actual = arithmeticalAction.sum(array);

    Assert.assertEquals(actual, expected);
  }
  
  @Test (dataProvider = "positivesData")
  public void testPositives(int expected, int [] actualArray) {
    Array array = new Array(actualArray);  
    int actual = arithmeticalAction.positives(array);

    Assert.assertEquals(actual, expected);
  }
  
  @Test (dataProvider = "negativesData")
  public void testNegatives(int expected, int [] actualArray) {
    Array array = new Array(actualArray);  
    int actual = arithmeticalAction.negatives(array);

    Assert.assertEquals(actual, expected);
  }
  
  /**
   * data for testMin.
   * @return test data array 
   */
  @DataProvider
  public Object[][] minData() {
    return new Object[][] {
      {-62, new int [] {42, -62, -55, 19, -17, 1, 7, 49}},
      {-76, new int [] {-15, 31, 86, -31, 38, -45, 92, -76, -41}},
      {-63, new int [] {52, 52, -21, -31, -63}}
    };
  }
  
  
  /**
   * data for testMax.
   * @return test data array 
   */
  @DataProvider
  public Object[][] maxData() {
    return new Object[][] {
      {99, new int [] {-95, 2, 99, 13, -97, -96, -74}},
      {36, new int [] {-17, 11, 36, -44, 16, -67, -17, -31, 15, 2}},
      {96, new int [] {51, 29, 34, -13, 96, 2}}
    };
  }
  
  /**
   * data for testAverage.
   * @return test data array 
   */
  @DataProvider
  public Object[][] averageData() {
    return new Object[][] {
      {22.5, new int [] {59, 84, 16, -17, 38, -29, 18, 10, 66, -20}},
      {-15.9, new int [] {64, -21, -41, -79, -11, -9, -31, -40, 37, -28}},
      {22.0, new int [] {6, 58, -59, 38, 76, 21, -87, 98, 36, 33}}
    };
  }
  
  /**
   * data for testSum.
   * @return test data array 
   */
  @DataProvider
  public Object[][] sumData() {
    return new Object[][] {
      {-189, new int [] {13, -62, -33, -96, -69, -59, 49, 39, 33, -4}},
      {45, new int [] {20, 25, 0, -66, 33, -24, 42, -97, 56, 56}},
      {219, new int [] {10, -72, 4, 63, -24, 89, -14, 73, 44, 46}}
    };
  }
  
  /**
   * data for testPositives.
   * @return test data array 
   */
  @DataProvider
  public Object[][] positivesData() {
    return new Object[][] {
      {4, new int [] {39, -32, -25, -17, 26, -9, 3, 33}},
      {3, new int [] {-62, -11, -9, -1, 75, 84, 92}},
      {4, new int [] {-88, -24, -22, -13, -9, -1, 9, 56, 75, 79}}
    };
  }
  
  /**
   * data for testNegatives.
   * @return test data array 
   */
  @DataProvider
  public Object[][] negativesData() {
    return new Object[][] {
      {7, new int [] {-63, 89, -45, -11, -1, -19, -81, -86}},
      {5, new int [] {-77, -5, 85, -93, -32, 27, 34, -19}},
      {4, new int [] {-11, 92, 73, -62, -1, 84, -9, 68, 75, 22}}
    };
  }
  
  @AfterClass
  public void tierDown() {
    arithmeticalAction = null;
  }
}
