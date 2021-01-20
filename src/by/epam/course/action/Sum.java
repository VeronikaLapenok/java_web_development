package by.epam.course.action;

import by.epam.course.entity.Array;

public class Sum {
  /**
   * get sum of all elements in the array.
   * @param array - array (type Array)
   * @return sum of elements
   */
  public int getSum(Array array) {
    int sum = 0;
    for (int i = 0; i < array.getSize(); i++) {
      sum += array.getElement(i);
    }
    return sum;
  }
}
