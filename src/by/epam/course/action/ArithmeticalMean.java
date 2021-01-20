package by.epam.course.action;

import by.epam.course.entity.Array;

public class ArithmeticalMean {
  /**
   * get arithmetical mean of all elements of the array.
   * @param array - array (type Array)
   * @return arithmetical mean
   */
  public double getArithmeticalMean(Array array) {
    double sum = 0;
    for (int i = 0; i < array.getSize(); i++) {
      sum += array.getElement(i);
    }
    return sum / array.getSize();
  }
}
