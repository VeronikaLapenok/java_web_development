package by.epam.course.entity;

public class Size {
  private int length;
  private int width;
  
  public int getLength() {
    return length;
  }
  
  public void setLength(int length) {
    this.length = length;
  }
  
  public int getWidth() {
    return width;
  }
  
  public void setWidth(int width) {
    this.width = width;
  }
  
  
  @Override
  public boolean equals(Object obj) {
    // TODO Auto-generated method stub
    return true;
  }
  
  @Override
  public int hashCode() {
    // TODO Auto-generated method stub
    return super.hashCode();
  }
  
  
  
  @Override
  public String toString() {
    final StringBuilder stringBuilder = new StringBuilder("\nLength: ");
    stringBuilder.append(length).append("\nWidth: ").append(width);
    
    return stringBuilder.toString();
  }
}
