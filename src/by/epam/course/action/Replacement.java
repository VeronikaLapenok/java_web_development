package by.epam.course.action;

import by.epam.course.entity.Array;

public class Replacement {
  /**
   * replace elements with negative value by 0.
   * @param array - array (type Array)
   * @return new array
   */
  public Array replaceNegativeElements(Array array) {
    final int replacement = 0;
    for (int i = 0; i < array.getSize(); i++) {
      if (array.getElement(i) < 0) {
        array.setElement(i, replacement);
      }
    }
    return array;
  }
}
