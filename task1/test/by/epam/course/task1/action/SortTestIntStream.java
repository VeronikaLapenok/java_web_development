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

public class SortTestIntStream {
  private static Logger logger = LogManager.getLogger();
  
  SortActionIntStream sortActionIntStream;

  @BeforeClass
  public void setUp() {
    sortActionIntStream = new SortActionIntStream();
  }
  
  @Test (dataProvider = "sortData")
  public void testSort(int [] expectedArray, int [] actualArray) throws ArrayException {
    logger.debug("Enter testSortIntStream");
    
    Array actual = new Array(actualArray);
    Array expected = new Array(expectedArray);

    actual = sortActionIntStream.sort(actual);
    
    logger.debug("Actual: " + actual);
    logger.debug("Expected: " + expected);

    Assert.assertEquals(actual.toString(), expected.toString());
    
    logger.debug("Exit testSortIntStream");
  }
  
  /**
   * data for testSort.
   * @return test data array
   */
  @DataProvider
  public Object[][] sortData() {
    return new Object[][] {
      {new int [] {-80, -64, -60, -11, -10, -2, 27, 32, 47, 66},
          new int [] {-60, -10, -64, -11, 27, 47, -80, 66, 32, -2 }},
      {new int [] {-98, -48, -43, -3, 31, 33, 61, 62, 75, 87},
          new int [] {75, -3, -43, 33, -98, 62, 31, -48, 61, 87}},
      {new int [] {-97, -96, -33, -26, -17, 16, 20, 51, 78, 98},
          new int [] {98, 20, -26, -96, -97, -17, 51, -33, 78, 16}}
    };
  }

  @AfterClass
  public void tierDown() {
    sortActionIntStream = null;
  }

}
