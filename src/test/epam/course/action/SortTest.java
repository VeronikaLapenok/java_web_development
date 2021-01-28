package test.epam.course.action;

import by.epam.course.action.SortAction;
import by.epam.course.entity.Array;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SortTest {
  SortAction sortAction;

  @BeforeClass
  public void setUp() {
    sortAction = new SortAction();
  }

  @Test (dataProvider = "bubbleSortData")
  public void testBubbleSort(int [] expectedArray, int [] actualArray) {
    Array actual = new Array(actualArray);
    Array expected = new Array(expectedArray);

    actual = sortAction.bubbleSort(actual);

    Assert.assertEquals(actual.toString(), expected.toString());
  }
  
  @Test (dataProvider = "insertSortData")
  public void testInsertSort(int [] expectedArray, int [] actualArray) {
    Array actual = new Array(actualArray);
    Array expected = new Array(expectedArray);
    
    actual = sortAction.insertSort(actual);

    Assert.assertEquals(actual.toString(), expected.toString());
  }

  @Test (dataProvider = "selectSortData")
  public void testSelectSort(int [] expectedArray, int [] actualArray) {
    Array actual = new Array(actualArray);
    Array expected = new Array(expectedArray);
    
    actual = sortAction.selectSort(actual);

    Assert.assertEquals(actual.toString(), expected.toString());
  }
  
  /**
   * data for testBubbleSort.
   * @return test data array
   */
  @DataProvider
  public Object[][] bubbleSortData() {
    return new Object[][] {
      {new int [] {-89, -77, -56, -50, -31, -13, 4, 60, 65, 83},
          new int [] {-89, -50, 83, 60, -13, -77, 65, 4, -31, -56}},
      {new int [] {-99, -16, -15, 2, 36, 36, 52, 55, 61, 63},
          new int [] {36, -16, 36, 2, -99, 63, -15, 61, 52, 55}},
      {new int [] {-90, -88, -66, -44, -27, -4, 18, 28, 76, 94},
          new int [] {-88, 94, 76, -27, 28, -66, -44, 18, -90, -4}}
    };
  }
  
  /**
   * data for testInsertSort.
   * @return test data array
   */
  @DataProvider
  public Object[][] insertSortData() {
    return new Object[][] {
      {new int [] {-69, -48, -43, -17, -5, 7, 47, 70, 90, 92},
          new int [] {90, 92, -17, -69, 7, -43, 47, -5, 70, -48}},
      {new int [] {-94, -72, -45, -27, -22, 0, 9, 13, 70, 97},
          new int [] {97, 0, 70, 13, -45, -27, 9, -94, -22, -72}},
      {new int [] {-82, -66, -35, -28, -4, -3, 9, 88, 89, 91},
          new int [] {-35, -66, -4, 88, -28, 9, -82, 89, 91, -3}}
    };
  }
  
  /**
   * data for testSelectSort.
   * @return test data array
   */
  @DataProvider
  public Object[][] selectSortData() {
    return new Object[][] {
      {new int [] {-97, -65, -60, -41, 6, 8, 23, 42, 42, 67},
          new int [] {42, 23, -60, -97, 8, 6, -41, 42, -65, 67}},
      {new int [] {-72, -45, -45, -29, -12, -10, 8, 12, 60, 63},
          new int [] {63, -10, 8, -12, -72, 12, -29, -45, -45, 60}},
      {new int [] {-94, -67, -50, -13, 0, 24, 36, 54, 85, 96},
          new int [] {85, -50, 96, 36, 24, -67, -13, -94, 0, 54}}
    };
  }

  @AfterClass
  public void tierDown() {
    sortAction = null;
  }
}
