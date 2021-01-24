package by.epam.course.main;

import by.epam.course.action.ArithmeticalAction;
import by.epam.course.action.ReplacementAction;
import by.epam.course.action.SortAction;
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
    
    Array arrayBubbleSorted = new Array(10);
    creator.fillRandomized(arrayBubbleSorted, -100, 100);
    logger.info(arrayBubbleSorted);
    SortAction sort = new SortAction();
    logger.info("Array sorted by bubble sort method: " + sort.bubbleSort(arrayBubbleSorted));
    
    Array arrayInsertSorted = new Array(10);
    creator.fillRandomized(arrayInsertSorted, -100, 100);
    logger.info(arrayInsertSorted);
    logger.info("Array sorted by selection sort method: " + sort.insertSort(arrayInsertSorted));
    
    Array arraySelectSorted = new Array(10);
    creator.fillRandomized(arraySelectSorted, -100, 100);
    logger.info(arraySelectSorted);
    logger.info("Array sorted by insertion sort method: " + sort.selectSort(arraySelectSorted));
  }
}
