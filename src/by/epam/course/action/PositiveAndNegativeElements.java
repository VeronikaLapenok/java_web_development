package by.epam.course.action;

import by.epam.course.entity.Array;

public class PositiveAndNegativeElements {
  /**
   * get number of positive elements in the array.
   * @param array - array (type Array)
   * @return number of positive elements
   */
  public int getNumberOfPositives(Array array) {
    int positives = 0;
    for (int i = 0; i < array.getSize(); i++) {
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
  public int getNumberOfNegatives(Array array) {
    int negatives = 0;
    for (int i = 0; i < array.getSize(); i++) {
      if (array.getElement(i) < 0) {
        negatives++;
      }
    }
    return negatives;
  }
}
