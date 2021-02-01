package by.epam.course.task1.action;

import by.epam.course.task1.entity.Array;
import by.epam.course.task1.exception.ArrayException;
import by.epam.course.task1.validation.Validation;
import java.util.stream.IntStream;

public class ReplacementActionIntStream {
  /**
   * replace elements with negative value by 0.
   * @param array - array (type Array)
   * @return replaced array (type Array)
   */
  public Array replaceNegatives(Array array) throws ArrayException {
    if (Validation.isArrayEmpty(array)) {
      throw new ArrayException("Incorrect array " + array.toString());
    }
    
    int [] newArray = IntStream.of(array.getArray())
            .map(i -> i < 0 ? 0 : i)
            .toArray();
    Array replacedArray = new Array(newArray);
    return replacedArray;
  }
}
