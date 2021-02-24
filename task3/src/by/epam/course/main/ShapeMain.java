package by.epam.course.main;

import java.util.*;
import by.epam.course.reader.DataReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.course.action.impl.ConeAction;
import by.epam.course.entity.ConeParameters;
import by.epam.course.entity.ShapePoint;
import by.epam.course.exception.*;
import by.epam.course.factory.impl.ConeFactory;
import by.epam.course.observer.impl.*;
import by.epam.course.parser.*;
import by.epam.course.parser.impl.*;
import by.epam.course.reader.impl.*;
import by.epam.course.repository.*;
import by.epam.course.specification.*;
import by.epam.course.specification.impl.*;
import by.epam.course.factory.ShapeFactory;
import by.epam.course.entity.Cone;
import by.epam.course.warehouse.ConeWarehouse;
import by.epam.course.comparator.*;

public class ShapeMain {
  private static final Logger logger = LogManager.getLogger();
  
  public static void main(String [] args) throws ConeException {
    ConeAction action = new ConeAction();
    DataReader dataReader = new ConeDataReader();
    List<String> dataFile = dataReader.readAllData("resources/data/cone.txt");
    DataParser dataParser = new ConeDataParser();
    List<Object[]> coneData = dataParser.parseData(dataFile);
    logger.debug("List object: " + coneData);
    ShapeFactory factory = new ConeFactory();
    ConeRepository repository = new ConeRepository();
    ConeWarehouse warehouse = ConeWarehouse.getInstance();
    for (Object[] item: coneData) {
      Cone cone = (Cone) factory.createShape((double)item[0], (ShapePoint)item[1], (ShapePoint)item[2]);
      repository.add(cone);
      ConeParameters parameters = new ConeParameters(action.findSquare(cone), action.findVolume(cone));
      warehouse.putConeParameters(cone.getConeId(), parameters);
    }
    
    Cone cone = (Cone) repository.get(2);
    cone.attach(new ConeObserver());
    cone.setPointTop(new ShapePoint(3.4, 6.7, 3.2));
//    logger.debug(cone);
    
    
    
//    Specification sp = new IdSpecification(5);
//    logger.debug(repository.query(sp));
    Specification sp = new PointsInTheFirstQuadrant();
//    repository.query(sp);
    sp = new RadiusMoreValue(7.6);
    logger.debug(repository.query(sp));
//    sp = new SquareRangeSpecification(1.3, 100.0);
//    repository.query(sp);
//    sp = new VolumeRangeSpecification(1.0, 100.0);
//    repository.query(sp);
//    
//    ConeIdComparator idComp = new ConeIdComparator();
//    logger.debug("\nSort ID:" + repository.sort(idComp));
//    ConeSquareComparator squareComp = new ConeSquareComparator();
//    logger.debug("\nSort Square: " + repository.sort(squareComp));
//    ConeRadiusComparator radComp = new ConeRadiusComparator();
//    logger.debug("\nSort radius: " + repository.sort(radComp));
    
    
  }

}
