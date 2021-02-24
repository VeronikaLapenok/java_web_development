package by.epam.course.validation;

import by.epam.course.action.impl.ConeAction;
import by.epam.course.entity.Cone;
import by.epam.course.exception.ConeException;

public class ConeValidation {
  public static boolean isConeValid(Cone cone) throws ConeException {
    boolean result = false;
    ConeAction action = new ConeAction();
    double height = action.findHeight(cone);
    double slantHeight = action.findSlantHeight(cone);
    
    if (slantHeight > height) {
      result = true;
    }
    return result;
  }
}
