package by.epam.course.action;

import by.epam.course.entity.Array;

public class MinAndMaxElements {
  /**
   * get minimum element of the array.
   * @param array - array (type Array)
   * @return minimum element of the array
   */
  public int getMinElement(Array array) {
    int min = 100;
    for (int i = 0; i < array.getSize(); i++) {
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
  public int getMaxElement(Array array) {
    int max = -100;
    for (int i = 0; i < array.getSize(); i++) {
      if (array.getElement(i) > max) {
        max = array.getElement(i);
      }
    }
    return max;
  }
}
