package by.epam.course.creator;

import by.epam.course.entity.Array;

public class ArrayCreator {
  /**
   * create an array of random elements.
   * @param array - array which will be filled with random elements (type Array)
   * @param minValue - minimum value of random (type int)
   * @param maxValue - maximum value of random (type int)
   */
  public void fillRandomized(Array array, int minValue, int maxValue) {
    int size = array.size();
    for (int i = 0; i < size; i++) {
      int value = (int) ((Math.random() * (maxValue - minValue)) + minValue);
      array.setValue(i, value);
    }
  }
}
