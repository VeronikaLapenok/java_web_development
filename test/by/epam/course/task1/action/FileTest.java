package by.epam.course.task1.action;

import by.epam.course.task1.exception.ArrayException;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileTest {
  private static final String testFile = "resources/data/testArrayFile.txt";
  FileAction file;
  
  @BeforeClass
  public void setUp() {
    file = new FileAction();
  }
  
  @Test
  public void readFileTest() throws ArrayException {
    final String expected = "13 8 70 63 14 9";  

    boolean success = true;

    try {
      String actual = file.read(testFile);
      Assert.assertEquals(actual, expected);
    } catch (IOException e) {
      success = false;
    }
  
    Assert.assertTrue(success);
  }
}
