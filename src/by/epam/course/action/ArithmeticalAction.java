package by.epam.course.action;

import by.epam.course.entity.Array;

public class ArithmeticalAction {
  /**
   * get minimum element of the array.
   * @param array - array (type Array)
   * @return minimum element of the array
   */
  public int min(Array array) {
    int min = 100;
    int size = array.size();
    for (int i = 0; i < size; i++) {
      if (array.getElement(i) < min) {
        min = array.getElement(i);
      }
    }
    return min;
  }

  /**
   * get maximum element of the array.
   * @param array - array (type Array)
   * @return maximum element of the array
   */
  public int max(Array array) {
    int max = -100;
    int size = array.size();
    for (int i = 0; i < size; i++) {
      if (array.getElement(i) > max) {
        max = array.getElement(i);
      }
    }
    return max;
  }
  
  /**
   * get arithmetical mean of all elements of the array.
   * @param array - array (type Array)
   * @return arithmetical mean
   */
  public double average(Array array) {
    double sum = 0;
    int size = array.size();
    for (int i = 0; i < size; i++) {
      sum += array.getElement(i);
    }
    return sum / size;
  }

  /**
   * get sum of all elements in the array.
   * @param array - array (type Array)
   * @return sum of elements
   */
  public int sum(Array array) {
    int sum = 0;
    int size = array.size();
    for (int i = 0; i < size; i++) {
      sum += array.getElement(i);
    }
    return sum;
  }
  
  /**
   * get number of positive elements in the array.
   * @param array - array (type Array)
   * @return number of positive elements
   */
  public int positives(Array array) {
    int positives = 0;
    int size = array.size();
    for (int i = 0; i < size; i++) {
      if (array.getElement(i) > 0) {
        positives++;
      }
    }
    return positives;
  }

  /**
   * get number of negative elements in the array.
   * @param array - array (type Array)
   * @return number of negative elements
   */
  public int negatives(Array array) {
    int negatives = 0;
    int size = array.size();
    for (int i = 0; i < size; i++) {
      if (array.getElement(i) < 0) {
        negatives++;
      }
    }
    return negatives;
  }
}
