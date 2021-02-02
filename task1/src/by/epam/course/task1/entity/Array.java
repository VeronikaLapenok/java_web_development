package by.epam.course.task1.entity;

import by.epam.course.task1.exception.ArrayException;
import java.util.Arrays;

public class Array {
  private int [] array;

  public Array(int [] array) {
    this.array = array;
  }

  /**
   * create an array of the given size.
   * @param size - size of the array (type int)
   * @throws ArrayException - work if size < 1
   */
  public Array(int size) throws ArrayException {
    if (size < 1) {
      throw new ArrayException("Incorrect size of array");
    }
    array = new int[size];
  }
  
  public int size() {
    return array.length;
  }

  public int getValue(int index) {
    return array[index];
  }

  public void setValue(int index, int value) {
    array[index] = value;
  }
  
  public int [] getArray() {
    return array;
  }
  
  @Override
  public int hashCode() {
    final int PRIME = 31;
    int result = 1;
    for (int item: array) {
      result = PRIME * result + item;
    }
    return result;
  }
  
  @Override 
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    Array objectArray = (Array) object;
    return Arrays.equals(array, objectArray.array);
  }

  @Override
  public String toString() {
    StringBuilder string = new StringBuilder();
    for (int i: array) {
      string.append(i + " ");
    }
    return string.toString();
  }
}
