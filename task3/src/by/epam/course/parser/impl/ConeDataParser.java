package by.epam.course.parser.impl;

import by.epam.course.entity.ShapePoint;
import by.epam.course.exception.ConeException;
import by.epam.course.parser.DataParser;
import by.epam.course.validation.DataValidation;

import java.util.ArrayList;
import java.util.List;

public class ConeDataParser implements DataParser {
  
  public List<Object[]> parseData(List<String> lines) throws ConeException {
    final String SEPARATOR = "\\s";
    
    List<Object[]> coneData = new ArrayList<>();
    
    for (String item: lines) {
      item = item.strip();
      if (DataValidation.isStringValid(item)) {
        String [] data  = item.split(SEPARATOR);
        double radius = Double.parseDouble(data[0]);
        ShapePoint pointTop = new ShapePoint(Double.parseDouble(data[1]),
            Double.parseDouble(data[2]), Double.parseDouble(data[3]));
        ShapePoint pointBottom = new ShapePoint(Double.parseDouble(data[4]),
            Double.parseDouble(data[5]),Double.parseDouble(data[6]));
        
        coneData.add(new Object[] {radius, pointTop, pointBottom});    
        
      }
    }
    return coneData;
  }
}
