package test.epam.course.action;

import by.epam.course.action.ReplacementAction;
import by.epam.course.entity.Array;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ReplacementTest {
  ReplacementAction replacementAction;

  @BeforeClass
  public void setUp() {
    replacementAction = new ReplacementAction();
  }

  @Test (dataProvider = "replacementData")
  public void testReplacement(int [] expectedArray, int [] actualArray) {
    Array actual = new Array(actualArray);
    Array expected = new Array(expectedArray);

    actual = replacementAction.replaceNegatives(actual);

    Assert.assertEquals(actual.toString(), expected.toString());
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
