package by.epam.course.action;

import by.epam.course.entity.Array;
import java.util.stream.IntStream;

public class ArithmeticalActionIntStream {
  /**
   * find minimum element of the array.
   * @param array - array (type Array)
   * @return min - minimum element of the array (type min)
   */
  public int min(Array array) {
    int min = IntStream.of(array.getArray())
            .min()
            .getAsInt();
    return min;
  }
  
  /**
   * find maximum element of the array.
   * @param array array (type Array)
   * @return maximum element of the array (type int)
   */
  public int max(Array array) {
    int max = IntStream.of(array.getArray())
            .max()
            .getAsInt();
    return max;
  }
  
  
  /**
   * find sum of all elements in the array.
   * @param array - array (type Array)
   * @return sum - sum of elements (type int)
   */
  public int sum(Array array) {
    int sum = IntStream.of(array.getArray())
            .sum();
    return sum;
  }
  
  /**
   * find average of all elements of the array.
   * @param array - array (type Array)
   * @return average - average of elements (type int)
   */
  public double average(Array array) {
    double average = IntStream.of(array.getArray())
            .average()
            .getAsDouble();
    return average;
  }
  
  /**
   * find number of positive elements in the array.
   * @param array - array (type Array)
   * @return positives - number of positive elements (type int)
   */
  public long positives(Array array) {
    long positives = IntStream.of(array.getArray())
            .filter(i -> i > 0)
            .count();
    return positives;
  }
  
  /**
   * find number of negative elements in the array.
   * @param array - array (type Array)
   * @return negatives - number of negative elements (type int)
   */
  public long negatives(Array array) {
    long positives = IntStream.of(array.getArray())
            .filter(i -> i < 0)
            .count();
    return positives;
  }
}
