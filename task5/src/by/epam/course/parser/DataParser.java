package by.epam.course.parser;

import by.epam.course.entity.Auto;
import by.epam.course.exception.ThreadException;

public class DataParser {
  private final String DELIMITER = " ";
  
  public Auto parser(String autoParameters) throws ThreadException{
    if (autoParameters.isEmpty()) {
      throw new ThreadException("Auto parameters are empty.");
    }
    
    String[] array = autoParameters.split(DELIMITER);
    String number = array[0];
    double size = Double.parseDouble(array[1]);
    double weight = Double.parseDouble(array[2]);
    Auto.Type type;
    
    switch (array[3].toUpperCase()) {
     case "TRUCK":
       type = Auto.Type.TRUCK;
       break;
     case "CAR":
       type = Auto.Type.CAR;
       break;
     default :
       type = Auto.Type.UNKNOWN;
       break;
    }
    
    return new Auto(number, size, weight, type);
  }
}
