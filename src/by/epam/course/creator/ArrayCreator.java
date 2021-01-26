package by.epam.course.creator;

import by.epam.course.entity.Array;
import by.epam.course.exception.ArrayException;
import by.epam.course.validation.Validation;

public class ArrayCreator {
  /**
   * create an array of random elements.
   * @param minValue - minimum value of random (type int)
   * @param maxValue - maximum value of random (type int)
   * @param size - array size (type int)
   * @return array - array of random values
   */
  public Array random(int minValue, int maxValue, int size) throws ArrayException {
    Array array = new Array(size);  
 
    for (int i = 0; i < size; i++) {
      int value = (int) ((Math.random() * (maxValue - minValue)) + minValue);
      array.setValue(i, value);
    }
    return array;
  }
  
  /**
   * create an array of values from string.
   * @param string - string with data for initialize the array (type String)
   * @return array - array of values from string
   */
  public Array fromString(String string) throws ArrayException {
    if (!Validation.isString(string)) {
      throw new ArrayException("The string is incorrect");
    }

    string = string.trim();
    String [] items = string.split("\\s");
    Array array = new Array(items.length);
    for (int i = 0; i < items.length; i++) {
      array.setValue(i, Integer.parseInt(items[i]));
    }
    return array;
  }
}
