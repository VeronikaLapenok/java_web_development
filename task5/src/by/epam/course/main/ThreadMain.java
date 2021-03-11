package by.epam.course.main;

import by.epam.course.entity.Auto;
import by.epam.course.entity.Ferry;
import by.epam.course.exception.ThreadException;
import by.epam.course.reader.FileReader;
import by.epam.course.parser.DataParser;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThreadMain {
  private static Logger logger = LogManager.getLogger();
  
  public static void main(String[] args) throws ThreadException {
    Ferry ferry = Ferry.getInstance();
    ferry.setSquare(300);
    ferry.setCarring(150);
    ferry.setParkingPlaceSquare(13.25);
    ferry.setFreeParkingPlacesCount(ferry.findParkingPlacesCount(ferry.getSquare(), false));
    logger.debug("Ferry: " + ferry);
    logger.debug("Count of parking places = " + ferry.findParkingPlacesCount(ferry.getSquare(), false));
    ferry.start();
    
    final String FILE_PATH = "resources/data/data.txt";
    List<String> automobiles;
  
    FileReader reader = new FileReader();
    DataParser parser = new DataParser();
    
    automobiles = reader.readFile(FILE_PATH);
    
    logger.debug("----- Start loading automobiles ------");
    for (String item: automobiles) {
      Auto auto = parser.parser(item);
      auto.start();
    }
  }
}
