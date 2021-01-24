package by.epam.course.action;

import by.epam.course.entity.Array;

public class ReplacementAction {
  /**
   * replace elements with negative value by 0.
   * @param array - array (type Array)
   * @return new array
   */
  public Array replaceNegatives(Array array) {
    final int replacement = 0;
    int size = array.size();
    for (int i = 0; i < size; i++) {
      if (array.getValue(i) < 0) {
        array.setValue(i, replacement);
      }
    }
    return array;
  }
}
