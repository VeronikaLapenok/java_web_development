package by.epam.course.task1.action;

import by.epam.course.task1.entity.Array;
import by.epam.course.task1.exception.ArrayException;
import by.epam.course.task1.validation.Validation;
import java.util.stream.IntStream;

public class SortActionIntStream {
  /**
   * sort the array using IntStream sort() method.
   * @param array - array (type Array)
   * @return sorted array (type Array)
   */
  public Array sort(Array array) throws ArrayException {
    if (Validation.isArrayEmpty(array)) {
      throw new ArrayException("Incorrect array " + array.toString());
    }
    
    int [] newArray = IntStream.of(array.getArray())
            .sorted()
            .toArray();
    Array sortedArray = new Array(newArray);
    return sortedArray;
  }
}
