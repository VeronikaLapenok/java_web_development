package by.epam.course.validation;

public class Validation {
  /**
   * checks for a valid line in the file to initialize the array.
   * It is correct to consider a string, the array elements of 
   * which are separated by a space character.
   * @param string - a string to be checked for correctness 
   * @return isValid
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
  
  public static boolean isNumber(String string) {
    return string.matches("^\\-*\\d{1,}$");
  }
}
