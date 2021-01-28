package by.epam.course.action;

import by.epam.course.entity.Array;

public class ArithmeticalAction {
  /**
   * find minimum element of the array.
   * @param array - array (type Array)
   * @return min - minimum element of the array (type min)
   */
  public int min(Array array) {
    int min = 100;
    int size = array.size();
    for (int i = 0; i < size; i++) {
      if (array.getValue(i) < min) {
        min = array.getValue(i);
      }
    }
    return min;
  }

  /**
   * find maximum element of the array.
   * @param array - array (type Array)
   * @return max - maximum element of the array (type int)
   */
  public int max(Array array) {
    int max = -100;
    int size = array.size();
    for (int i = 0; i < size; i++) {
      if (array.getValue(i) > max) {
        max = array.getValue(i);
      }
    }
    return max;
  }
  
  /**
   * find average of all elements of the array.
   * @param array - array (type Array)
   * @return average - average of elements (type int)
   */
  public double average(Array array) {
    double sum = 0;
    int size = array.size();
    for (int i = 0; i < size; i++) {
      sum += array.getValue(i);
    }
    return sum / size;
  }

  /**
   * find sum of all elements in the array.
   * @param array - array (type Array)
   * @return sum - sum of elements (type int)
   */
  public int sum(Array array) {
    int sum = 0;
    int size = array.size();
    for (int i = 0; i < size; i++) {
      sum += array.getValue(i);
    }
    return sum;
  }
  
  /**
   * find number of positive elements in the array.
   * @param array - array (type Array)
   * @return positives - number of positive elements (type int)
   */
  public int positives(Array array) {
    int positives = 0;
    int size = array.size();
    for (int i = 0; i < size; i++) {
      if (array.getValue(i) > 0) {
        positives++;
      }
    }
    return positives;
  }

  /**
   * find number of negative elements in the array.
   * @param array - array (type Array)
   * @return negatives - number of negative elements (type int)
   */
  public int negatives(Array array) {
    int negatives = 0;
    int size = array.size();
    for (int i = 0; i < size; i++) {
      if (array.getValue(i) < 0) {
        negatives++;
      }
    }
    return negatives;
  }
}
