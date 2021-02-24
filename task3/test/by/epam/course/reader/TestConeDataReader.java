package by.epam.course.reader;

import by.epam.course.exception.ConeException;
import by.epam.course.reader.impl.ConeDataReader;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestConeDataReader {
  private static Logger logger = LogManager.getLogger();
  private static final String TEST_FILE_PATH = "resources/data/testCone.txt";
  ConeDataReader dataReader;
  
  @BeforeClass
  public void setUp() {
    dataReader = new ConeDataReader();
  }
  
  @Test
  public void testReadFile() throws ConeException {
    logger.debug("Enter testReadFile");
    
    List<String> expected = List.of("3 u 8.9 5",
                                    "12 6.8 9.9 4.0 6.2 5t5",
                                    "1.2 3.4 -5.8 3.2 1.0 5.0 3.5",
                                    "rytry",
                                    "2.3 1.2 7.6 -4.5 -3.4 3.8 4.0",
                                    "QWEE!@!!#!",
                                    "8.9 6.7 -0.9 7.4 -5.8 3.4 -2.1",
                                    "5.6 2.1 0.5 7.7 4.5 6.8 3.1",
                                    "0.4 -2.5 -5.4 -2.22 6.756 9.0 1.123",
                                    "     5.4 -8.7 3.2 1.2 7.6 8.9 5.6",
                                    "13.4 5.6 9.78 15.7 25.7 30.0 8.6",
                                    "4.6 3.4 -9.0",
                                    "%25355",
                                    "3.7 6.5 4.5 1.2 7.6 9.8 3.3");
    List<String> actual = dataReader.readAllData(TEST_FILE_PATH);
    
    logger.debug("Expected: " + expected);
    
    Assert.assertEquals(actual, expected);
    
    logger.debug("Exit testReadFile");
  }
  
  @AfterClass
  public void tierDown() {
    dataReader = null;
  }
}
