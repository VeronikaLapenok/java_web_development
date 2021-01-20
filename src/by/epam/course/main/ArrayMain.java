package by.epam.course.main;

import by.epam.course.action.ArithmeticalMean;
import by.epam.course.action.MinAndMaxElements;
import by.epam.course.action.PositiveAndNegativeElements;
import by.epam.course.action.Replacement;
import by.epam.course.action.Sum;
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

    MinAndMaxElements min = new MinAndMaxElements();
    logger.debug("Minimum element of array is: " + min.getMinElement(array));

    MinAndMaxElements max = new MinAndMaxElements();
    logger.debug("Maximum element of array is: " + max.getMaxElement(array));

    PositiveAndNegativeElements positives = new PositiveAndNegativeElements();
    logger.debug("Number of positive elements in the array is: "
        + positives.getNumberOfPositives(array));

    PositiveAndNegativeElements negatives = new PositiveAndNegativeElements();
    logger.debug("Number of negative elements in the array is: "
        + negatives.getNumberOfNegatives(array));

    Replacement replacement = new Replacement();
    logger.debug("New array is: " + replacement.replaceNegativeElements(array));

    ArithmeticalMean mean = new ArithmeticalMean();
    logger.debug("Arithmetical mean of all elements of the array is: "
        + mean.getArithmeticalMean(array));

    Sum sum = new Sum();
    logger.debug("Sum of all elements of the array is " + sum.getSum(array));
  }
}
