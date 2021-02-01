package by.epam.course.task1.action;

import by.epam.course.task1.entity.Array;
import by.epam.course.task1.exception.ArrayException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ArithmeticalTestIntStream {
  private static Logger logger = LogManager.getLogger();
  
  ArithmeticalActionIntStream arithmeticalActionIntStream;
  
  @BeforeClass
  public void setUp() {
    arithmeticalActionIntStream = new ArithmeticalActionIntStream();
  }
  
  @Test (dataProvider = "minData")
  public void testMinIntStream(int expected, int [] actualArray) throws ArrayException {
    logger.debug("Enter testMinIntStream");
    
    Array array = new Array(actualArray);  
    int actual = arithmeticalActionIntStream.min(array);
    
    logger.debug("Actual: " + actual);
    logger.debug("Expected: " + expected);
    
    Assert.assertEquals(actual, expected);
    
    logger.debug("Exit testMinIntStream");
  }
  
  @Test (dataProvider = "maxData")
  public void testMaxIntStream(int expected, int [] actualArray) throws ArrayException {
    logger.debug("Enter testMaxIntStream");
    
    Array array = new Array(actualArray);  
    int actual = arithmeticalActionIntStream.max(array);
    
    logger.debug("Actual: " + actual);
    logger.debug("Expected: " + expected);
    
    Assert.assertEquals(actual, expected);
    
    logger.debug("Exit testMaxIntStream");
  }
  
  @Test (dataProvider = "averageData")
  public void testAverageIntStream(double expected, int [] actualArray) throws ArrayException {
    logger.debug("Enter testAverageIntStream");
    
    Array array = new Array(actualArray);  
    double actual = arithmeticalActionIntStream.average(array);
    
    logger.debug("Actual: " + actual);
    logger.debug("Expected: " + expected);
    
    Assert.assertEquals(actual, expected);
    
    logger.debug("Exit testAverageIntStream");
  }
  
  @Test (dataProvider = "sumData")
  public void testSumIntStream(int expected, int [] actualArray) throws ArrayException {
    logger.debug("Enter testSumIntStream");
    
    Array array = new Array(actualArray);  
    int actual = arithmeticalActionIntStream.sum(array);
    
    logger.debug("Actual: " + actual);
    logger.debug("Expected: " + expected);
    
    Assert.assertEquals(actual, expected);
    
    logger.debug("Exit testSumIntStream");
  }
  
  @Test (dataProvider = "positivesData")
  public void testPositivesIntStream(int expected, int [] actualArray) throws ArrayException {
    logger.debug("Enter testPositivesIntStream");
    
    Array array = new Array(actualArray);  
    long actual = arithmeticalActionIntStream.positives(array);
    
    logger.debug("Actual: " + actual);
    logger.debug("Expected: " + expected);
    
    Assert.assertEquals(actual, expected);
    
    logger.debug("Exit testPositivesIntStream");
  }
  
  @Test (dataProvider = "negativesData")
  public void testNegativesIntStream(int expected, int [] actualArray) throws ArrayException {
    logger.debug("Enter testNegativesIntStream");
    
    Array array = new Array(actualArray);  
    long actual = arithmeticalActionIntStream.negatives(array);
    
    logger.debug("Actual: " + actual);
    logger.debug("Expected: " + expected);
    
    Assert.assertEquals(actual, expected);
    
    logger.debug("Exit testNegativesIntStream");
  }
  
  /**
   * data for testMinIntStream.
   * @return test data array 
   */
  @DataProvider
  public Object[][] minData() {
    return new Object[][] {
      {3, new int [] {90, 3, 56, 76, 12}},
      {-76, new int [] {-31, 38, -45, 92, -76, -41}},
      {-87, new int [] {0, 78, -13, 9, -87, 22, 56}}
    };
  }
  
  /**
   * data for testMaxIntStream.
   * @return test data array 
   */
  @DataProvider
  public Object[][] maxData() {
    return new Object[][] {
      {49, new int [] {19, -17, 1, 7, 49}},
      {98, new int [] {0, 98, 23, 10, -29, -55, -2, 40, 73, 51}},
      {52, new int [] {52, 52, -21, -31, -63}}
    };
  }
  
  /**
   * data for testAverageIntStream.
   * @return test data array 
   */
  @DataProvider
  public Object[][] averageData() {
    return new Object[][] {
      {11.7, new int [] {94, 38, -71, 55, -58, 29, -84, 89, -55, 80}},
      {4.3, new int [] {-12, -57, 8, -80, 97, 93, 14, 4, -99, 75}},
      {19.3, new int [] {-12, -35, 96, 75, -41, 53, -37, 50, -11, 55}}
    };
  }
  
  
  /**
   * data for testSumIntStream.
   * @return test data array 
   */
  @DataProvider
  public Object[][] sumData() {
    return new Object[][] {
      {293, new int [] {60, 86, 56, -28, 12, 61, -99, 99, -9, 55}},
      {93, new int [] {-92, -76, -77, 98, 94, 87, 78, 49, -97, 29}},
      {-141, new int [] {-15, -22, 33, -50, -35, 70, -40, 23, -20, -85}}
    };
  }
  
  
  /**
   * data for testPositivesIntStream.
   * @return test data array 
   */
  @DataProvider
  public Object[][] positivesData() {
    return new Object[][] {
      {5, new int [] {-79, -41, -28, -28, -5, 26, 27, 29, 58, 89}},
      {9, new int [] {53, 65, 74, 4, 3, 69, 99, 38, 77}},
      {2, new int [] {92, 25, -52, -7, -36, -71 }}
    };
  }
  
  
  /**
   * data for testNegativesIntStream.
   * @return test data array 
   */
  @DataProvider
  public Object[][] negativesData() {
    return new Object[][] {
      {4, new int [] {-80, 3, -29, -82, -40}},
      {3, new int [] {86, 31, 81, 60, -27, -9, -83, 48, 69, 20}},
      {5, new int [] {-67, -19, 74, -43, -10, 93, -42}}
    };
  }
  
  @AfterClass
  public void tierDown() {
    arithmeticalActionIntStream = null;
  }

}
