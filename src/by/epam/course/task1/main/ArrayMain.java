package by.epam.course.task1.main;

import by.epam.course.task1.action.ArithmeticalAction;
import by.epam.course.task1.action.ArithmeticalActionIntStream;
import by.epam.course.task1.action.FileAction;
import by.epam.course.task1.action.ReplacementAction;
import by.epam.course.task1.action.SortAction;
import by.epam.course.task1.creator.ArrayCreator;
import by.epam.course.task1.entity.Array;
import by.epam.course.task1.exception.ArrayException;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayMain {
  private static Logger logger = LogManager.getLogger();
  
  /**
   * program entry point.
   */
  public static void main(String[] args) throws ArrayException {
    ArrayCreator creator = new ArrayCreator();
    
    try {
      Array array = creator.random(-100, 100, 10);
      logger.info(array);
      
      ArithmeticalActionIntStream action = new ArithmeticalActionIntStream();
      logger.debug(action.average(array));
      

      ArithmeticalAction arithmeticalAction = new ArithmeticalAction();
      logger.info("Minimum element of array is: " + arithmeticalAction.min(array));
      logger.info("Maximum element of array is: " + arithmeticalAction.max(array));
      logger.info("Number of positive elements in the array is: "
          + arithmeticalAction.positives(array));
      logger.info("Number of negative elements in the array is: "
          + arithmeticalAction.negatives(array));
      logger.info("Average of all elements of the array is: "
          + arithmeticalAction.average(array));
      logger.info("Sum of all elements of the array is " + arithmeticalAction.sum(array));
    
      ReplacementAction replacement = new ReplacementAction();
      logger.info("New array is: " + replacement.replaceNegatives(array));
    } catch (ArrayException e) {
      logger.error(e.getMessage());
    }
    
    SortAction sort = new SortAction();
    
    try {
      Array arrayBubbleSorted = creator.random(-100, 100, 10);
      logger.info(arrayBubbleSorted);
      logger.info("Array sorted by bubble sort method: "
          + sort.bubbleSort(arrayBubbleSorted));
    } catch (ArrayException e) {
      logger.error("Bubble sort. " + e.getMessage());
    }
    
    try {
      Array arrayInsertSorted = creator.random(-100, 100, 10);
      logger.info(arrayInsertSorted);
      logger.info("Array sorted by insertion sort method: "
          + sort.insertSort(arrayInsertSorted));
    } catch (ArrayException e) {
      logger.error("Selection sort. " + e.getMessage());
    }
    
    try {
      Array arraySelectSorted = creator.random(-100, 100, 10);
      logger.info(arraySelectSorted);
      logger.info("Array sorted by selection sort method: "
          + sort.selectSort(arraySelectSorted));   
    } catch (ArrayException e) {
      logger.error("Insertion sort. " + e.getMessage());
    }
    
    FileAction file = new FileAction();
    try {
      String line = file.read("resources/data/arrayFile.txt");
      Array arrayFromFile = creator.fromString(line); 
      logger.info(arrayFromFile);
    } catch (IOException e) {
      logger.error("Error IO Exception");
    } catch (ArrayException e) {
      logger.error(e.getMessage());
    }
  }
}
