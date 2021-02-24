package by.epam.course.validation;

public class DataValidation {
  public static boolean isStringValid(String line) {
    final String PATTERN = 
        "^(\\d+\\.{1}\\d+\\s){1}(-?\\d+\\.{1}\\d+\\s){5}(-?\\d+\\.{1}\\d+){1}$";
    return line.matches(PATTERN);
  }
}
