package by.epam.course.action;

import by.epam.course.entity.Array;
import java.util.stream.IntStream;

public class ReplacementActionIntStream {
  /**
   * replace elements with negative value by 0.
   * @param array - array (type Array)
   * @return array - new array (type Array)
   */
  public Array replaceNegatives(Array array) {
    final int replacement = 0;
    int [] newArray = IntStream.of(array.getArray())
            .filter(i -> i < 0)
            .map(i -> i * replacement)
            .toArray();
    Array f = new Array(newArray);
    return f;
  }

}
