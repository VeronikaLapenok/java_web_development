package by.epam.course.task1.action;

import by.epam.course.task1.entity.Array;
import by.epam.course.task1.exception.ArrayException;
import by.epam.course.task1.validation.Validation;

public class ArithmeticalAction {

  /**
   * find minimum element of the array.
   * @param array - array (type Array)
   * @return minimum element of the array (type min)
   */
  public int min(Array array) throws ArrayException {
    if (Validation.isArrayEmpty(array)) {
      throw new ArrayException("Incorrect array: " + array.toString());
    }
    
    int min = array.getValue(0);
    int size = array.size();
    for (int i = 1; i < size; i++) {
      if (array.getValue(i) < min) {
        min = array.getValue(i);
      }
    }
    
    return min;
  }

  /**
   * find maximum element of the array.
   * @param array - array (type Array)
   * @return maximum element of the array (type int)
   */
  public int max(Array array) throws ArrayException {
    if (Validation.isArrayEmpty(array)) {
      throw new ArrayException("Incorrect array: " + array.toString());
    }
    
    int max = array.getValue(0);
    int size = array.size();
    for (int i = 1; i < size; i++) {
      if (array.getValue(i) > max) {
        max = array.getValue(i);
      }
    }
   
    return max;
  }
  
  /**
   * find average of all elements of the array.
   * @param array - array (type Array)
   * @return average of elements (type int)
   */
  public double average(Array array) throws ArrayException {
    double sum = sum(array);
    int size = array.size();
 
    double average = sum / size;

    return average;
  }

  /**
   * find sum of all elements in the array.
   * @param array - array (type Array)
   * @return sum of elements (type int)
   */
  public int sum(Array array) throws ArrayException {  
    if (Validation.isArrayEmpty(array)) {
      throw new ArrayException("Incorrect array: " + array.toString());
    }
    
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
   * @return number of positive elements (type int)
   */
  public int positives(Array array) throws ArrayException {
    if (Validation.isArrayEmpty(array)) {
      throw new ArrayException("Incorrect array: " + array.toString());
    }
    
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
   * @return number of negative elements (type int)
   */
  public int negatives(Array array) throws ArrayException {
    if (Validation.isArrayEmpty(array)) {
      throw new ArrayException("Incorrect array: " + array.toString());
    }
    
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
