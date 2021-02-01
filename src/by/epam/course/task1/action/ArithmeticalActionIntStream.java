package by.epam.course.task1.action;

import by.epam.course.task1.entity.Array;
import by.epam.course.task1.exception.ArrayException;
import by.epam.course.task1.validation.Validation;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class ArithmeticalActionIntStream {
  /**
   * find minimum element of the array using IntStream min() method.
   * @param array - array (type Array)
   * @return minimum element of the array (type int)
   */
  public int min(Array array) throws ArrayException {
    if (Validation.isArrayEmpty(array)) {
      throw new ArrayException("Incorrect array: " + array.toString());
    }
    
    OptionalInt min = IntStream.of(array.getArray())
        .min();
    return min.getAsInt();
  }
  
  /**
   * find maximum element of the array using IntStream max() method.
   * @param array array (type Array)
   * @return maximum element of the array (type int)
   */
  public int max(Array array) throws ArrayException {
    if (Validation.isArrayEmpty(array)) {
      throw new ArrayException("Incorrect array: " + array.toString());
    }
    
    OptionalInt max = IntStream.of(array.getArray())
            .max();
    return max.getAsInt();
  }
  
  /**
   * find sum of all elements in the array using IntStream sum() method.
   * @param array - array (type Array)
   * @return sum of elements (type int)
   */
  public int sum(Array array) throws ArrayException {
    if (Validation.isArrayEmpty(array)) {
      throw new ArrayException("Incorrect array: " + array.toString());
    }
    
    int sum = IntStream.of(array.getArray())
            .sum();
    return sum;
  }
  
  /**
   * find average of all elements of the array using IntStream average() method.
   * @param array - array (type Array)
   * @return average of elements (type int)
   */
  public double average(Array array) throws ArrayException {
    if (Validation.isArrayEmpty(array)) {
      throw new ArrayException("Incorrect array: " + array.toString());
    }
    
    OptionalDouble average = IntStream.of(array.getArray())
            .average();
    return average.getAsDouble();
  }
  
  /**
   * find number of positive elements in the array using IntStream count() method.
   * @param array - array (type Array)
   * @return number of positive elements (type int)
   */
  public long positives(Array array) throws ArrayException {
    if (Validation.isArrayEmpty(array)) {
      throw new ArrayException("Incorrect array: " + array.toString());
    }
    
    long positives = IntStream.of(array.getArray())
            .filter(i -> i > 0)
            .count();
    return positives;
  }
  
  /**
   * find number of negative elements in the array using IntStream count() method.
   * @param array - array (type Array)
   * @return number of negative elements (type int)
   */
  public long negatives(Array array) throws ArrayException {
    if (Validation.isArrayEmpty(array)) {
      throw new ArrayException("Incorrect array: " + array.toString());
    }
    
    long positives = IntStream.of(array.getArray())
            .filter(i -> i < 0)
            .count();
    return positives;
  }
}
