package by.epam.course.entity;

public class Array {
  private int [] array;

  public Array(int [] array) {
    this.array = array;
  }

  public Array(int size) {
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

  @Override
  public String toString() {
    StringBuilder string = new StringBuilder();
    for (int i: array) {
      string.append(i + " ");
    }
    return string.toString();
  }
}
