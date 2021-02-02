package by.epam.course.task1.validation;

import by.epam.course.task1.entity.Array;

public class Validation {
  /**
   * check for a valid line in the file to initialize the array.
   * It is correct to consider a string, the array elements of 
   * which are separated by a space character.
   * @param string - a string to be checked for correctness (type String)
   * @return true - if success else false
   */
  public static boolean isString(String string) {
    boolean isValid = true;

    string = string.trim();
    String [] items = string.split("\\s");
    
    for (String item: items) {
      if (!isNumber(item)) {
        isValid = false;
        break;
      }
    }
    return isValid;
  }
  
  /**
   * check if a string is a number.
   * @param string - a string to be checked for correctness (type String)
   * @return true - if success else false
   */
  public static boolean isNumber(String string) {
    return string.matches("^\\-*\\d{1,}$");
  }
  
  /**
   * check if an array if empty or null.
   * @param array - an array to be checked for correctness (type String)
   * @return true - if success else false
   */
  public static boolean isArrayEmpty(Array array) {
    return array == null || array.size() == 0;
  }
}
