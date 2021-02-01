package by.epam.course.task1.action;

import by.epam.course.task1.entity.Array;

public class ReplacementAction {
  /**
   * replace elements with negative value by 0.
   * @param array - array (type Array)
   * @return new array (type Array)
   */
  public Array replaceNegatives(Array array) {
    final int REPLACEMENT = 0;
    int size = array.size();

    for (int i = 0; i < size; i++) {
      if (array.getValue(i) < 0) {
        array.setValue(i, REPLACEMENT);
      }
    }

    return array;
  }
}
