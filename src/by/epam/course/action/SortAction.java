package by.epam.course.action;

import by.epam.course.entity.Array;

public class SortAction {
  /**
   * sort array by bubble sort method.
   * @param array - initial array (type Array)
   * @return - sorted array
   */
  public Array bubbleSort(Array array) {
    int size = array.size();
    for (int i = size - 1; i > 1; i--) {
      for (int j = 0; j < i; j++) {
        if (array.getValue(j) > array.getValue(j + 1)) {
          swap(array, j, j + 1);
        }
      }
    }
    return array;
  }
  
  /**
   * swap the current and the next element of the array.
   * @param array - array (type Array)
   * @param index - current index (type int)
   * @param nextIndex - next index (type int)
   */
  private void swap(Array array, int index, int nextIndex) {
    int buf = array.getValue(index);
    array.setValue(index, array.getValue(nextIndex));
    array.setValue(nextIndex, buf);
  }
  
  /**
   * sort array by insertion sort method.
   * @param array - initial array (type Array)
   * @return - sorted array
   */
  public Array insertSort(Array array) {
    int size = array.size();
    for (int i = 1; i < size; i++) {
      int buf = array.getValue(i);
      int startIndex = i;
      while (startIndex > 0 && array.getValue(startIndex - 1) > buf) {
        array.setValue(startIndex, array.getValue(startIndex - 1));
        startIndex--;
      }
      array.setValue(startIndex, buf);
    }
    return array;
  }
  
  /**
   * sort array by selection sort method.
   * @param array - initial array (type Array)
   * @return - sorted array
   */
  public Array selectSort(Array array) {
    int size = array.size();
    for (int i = 0; i < size; i++) {
      int min = i;
      for (int j = i + 1; j < size; j++) {
        if (array.getValue(j) < array.getValue(i)) {
          min = j;
        }
      }
      swap(array, i, min);
    }
    return array;
  }
}
