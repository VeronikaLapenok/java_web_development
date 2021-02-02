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

public class ReplacementTestIntStream {
  private static Logger logger = LogManager.getLogger();
  
  ReplacementActionIntStream replacementActionIntStream;

  @BeforeClass
  public void setUp() {
    replacementActionIntStream = new ReplacementActionIntStream();
  }
  
  @Test (dataProvider = "replacementData")
  public void testReplacementIntStream(int [] expectedArray, int [] actualArray) 
      throws ArrayException {
    logger.debug("Enter testReplacementIntStream");
    
    Array actual = new Array(actualArray);
    Array expected = new Array(expectedArray);

    actual = replacementActionIntStream.replaceNegatives(actual);
    
    logger.debug("Actual: " + actual);
    logger.debug("Expected: " + expected);

    Assert.assertEquals(actual.toString(), expected.toString());
    
    logger.debug("Exit testReplacementIntStream");
  }
  
  /**
   * data for testReplacement.
   * @return test data array
   */
  @DataProvider
  public Object[][] replacementData() {
    return new Object[][] {
      {new int [] {0, 0, 0, 0, 0, 3, 0, 80, 47, 71},
          new int [] {-78, -59, -85, -57, -14, 3, -54, 80, 47, 71}},
      {new int [] {0, 62, 0, 54, 0, 0, 38},
          new int [] {-19, 62, -23, 54, -39, -36, 38}},
      {new int [] {68, 44, 0, 56, 0},
          new int [] {68, 44, -9, 56, -89}}
    };
  }
  
  @AfterClass
  public void tierDown() {
    replacementActionIntStream = null;
  }
}
