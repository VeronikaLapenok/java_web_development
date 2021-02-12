package by.epam.course.parser;

import by.epam.course.entity.Cone;
import by.epam.course.entity.ShapePoint;
import by.epam.course.exception.ConeException;
import by.epam.course.factory.impl.ConeFactory;
import by.epam.course.parser.impl.ConeDataParser;
import by.epam.course.reader.impl.ConeDataReader;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestConeDataParser {
  private static Logger logger = LogManager.getLogger();
  private static final String TEST_FILE_PATH = "resources/data/testCone.txt";
  private static final String SUBSTITUTE_STRING = "";
  private static final String REPLACEABLE_STRING = "\\nID:\\s\\d+";
  ConeDataParser dataParser;
  ConeDataReader dataReader;
  ConeFactory factory;
  
  @BeforeClass
  public void setUp() {
    dataParser = new ConeDataParser();
    dataReader = new ConeDataReader();
    factory = new ConeFactory();
  }
  
  @Test
  public void testParserData() throws ConeException {
    logger.debug("Enter testParserData");
    
    Cone coneExpected = (Cone)factory.createShape(1.2, new ShapePoint(3.4, -5.8, 3.2), 
        new ShapePoint(1.0, 5.0, 3.5));
           
    List<Object[]> list = dataParser.parseData(dataReader.readAllData(TEST_FILE_PATH));
    Object[] objects = list.get(0);
    Cone coneActual = (Cone)factory.createShape((double)objects[0], (ShapePoint)objects[1],(
        ShapePoint)objects[2]);
    
    String expectedString = coneExpected.toString();
    String actualString = coneActual.toString();
    
    expectedString = expectedString.replaceAll(REPLACEABLE_STRING, SUBSTITUTE_STRING);
    actualString = actualString.replaceAll(REPLACEABLE_STRING, SUBSTITUTE_STRING);
    
    Assert.assertEquals(actualString, expectedString);
    
    logger.debug("Exit testParserData");
  }
  
  @AfterClass
  public void tierDown() {
    dataParser = null;
    dataReader = null;
    factory = null;
  }
}
