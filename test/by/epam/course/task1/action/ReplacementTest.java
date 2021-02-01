package by.epam.course.task1.action;

import by.epam.course.task1.entity.Array;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ReplacementTest {
  private static Logger logger = LogManager.getLogger();
  
  ReplacementAction replacementAction;

  @BeforeClass
  public void setUp() {
    replacementAction = new ReplacementAction();
  }

  @Test (dataProvider = "replacementData")
  public void testReplacement(int [] expectedArray, int [] actualArray) {
    logger.debug("Enter testReplacement");
    
    Array actual = new Array(actualArray);
    Array expected = new Array(expectedArray);

    actual = replacementAction.replaceNegatives(actual);
    
    logger.debug("Actual: " + actual);
    logger.debug("Expected: " + expected);

    Assert.assertEquals(actual.toString(), expected.toString());
    
    logger.debug("Exit testReplacement");
  }
  
  /**
   * data for testReplacement.
   * @return test data array
   */
  @DataProvider
  public Object[][] replacementData() {
    return new Object[][] {
      {new int [] {0, 79, 0, 62, 2, 43, 0, 0, 6, 0},
          new int [] {-13, 79, -61, 62, 2, 43, -79, -54, 6, -34}},
      {new int [] {17, 0, 0, 0, 7, 0, 36, 49, 0, 15},
          new int [] {17, -93, -52, -92, 7, -22, 36, 49, -95, 15}},
      {new int [] {0, 98, 0, 0, 0, 49, 0, 0, 78, 92},
          new int [] {-27, 98, -50, -82, -68, 49, -46, 0, 78, 92}}
    };
  }
  
  @AfterClass
  public void tierDown() {
    replacementAction = null;
  }
}
