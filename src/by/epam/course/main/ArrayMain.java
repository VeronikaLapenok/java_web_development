package by.epam.course.main;

import by.epam.course.action.ArithmeticalAction;
import by.epam.course.action.ReplacementAction;
import by.epam.course.creator.ArrayCreator;
import by.epam.course.entity.Array;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayMain {
  static Logger logger = LogManager.getLogger();
  
  /**
   * program entry point.
   */
  public static void main(String[] args) {
    ArrayCreator creator = new ArrayCreator();
    Array array = new Array(10);
    creator.fillRandomized(array, -100, 100);
    logger.debug(array);

    ArithmeticalAction arithmeticalAction = new ArithmeticalAction();
    logger.debug("Minimum element of array is: " + arithmeticalAction.min(array));
    logger.debug("Maximum element of array is: " + arithmeticalAction.max(array));
    logger.debug("Number of positive elements in the array is: "
        + arithmeticalAction.positives(array));
    logger.debug("Number of negative elements in the array is: "
        + arithmeticalAction.negatives(array));
    logger.debug("Average of all elements of the array is: "
        + arithmeticalAction.average(array));
    logger.debug("Sum of all elements of the array is " + arithmeticalAction.sum(array));
    
    ReplacementAction replacement = new ReplacementAction();
    logger.debug("New array is: " + replacement.replaceNegatives(array));
  }
}
