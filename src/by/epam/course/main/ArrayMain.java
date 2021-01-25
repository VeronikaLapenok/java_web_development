package by.epam.course.main;

import by.epam.course.action.ArithmeticalAction;
import by.epam.course.action.FileAction;
import by.epam.course.action.ReplacementAction;
import by.epam.course.action.SortAction;
import by.epam.course.creator.ArrayCreator;
import by.epam.course.entity.Array;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayMain {
  static Logger logger = LogManager.getLogger();
  
  /**
   * program entry point.
   */
  public static void main(String[] args) {
    ArrayCreator creator = new ArrayCreator();
    
    Array array = creator.random(-100, 100, 10);
    logger.info(array);

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
    
    Array arrayBubbleSorted = creator.random(-100, 100, 10);
    logger.info(arrayBubbleSorted);
    SortAction sort = new SortAction();
    logger.info("Array sorted by bubble sort method: " + sort.bubbleSort(arrayBubbleSorted));
    
    Array arrayInsertSorted = creator.random(-100, 100, 10);
    logger.info(arrayInsertSorted);
    logger.info("Array sorted by selection sort method: " + sort.insertSort(arrayInsertSorted));
    
    Array arraySelectSorted = creator.random(-100, 100, 10);
    logger.info(arraySelectSorted);
    logger.info("Array sorted by insertion sort method: " + sort.selectSort(arraySelectSorted));   
    
    
    FileAction file = new FileAction();
    try {
      String line = file.read("./src/main/resources/array.txt");
      logger.debug(line);
      Array arrayFromFile = creator.fromString(line);
      logger.info(arrayFromFile);
    } catch (IOException e) {
      logger.error("File not found!");
    }
  }
}
