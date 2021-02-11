package by.epam.course.entity;

public class PaperSize {
  private int length;
  private int width;
  
  public PaperSize() {
    
  }
  
  public PaperSize(int length, int width) {
    this.length = length;
    this.width = width;
  }
  
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
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    
    if (object == null) {
      return false;
    }
    
    if (getClass() != object.getClass()) {
      return false;
    }
    
    PaperSize other = (PaperSize) object;
    
    if (length != other.length) {
      return false;
    }
    
    if (width != other.width) {
      return false;
    }
    
     return true;
  }
  
  @Override
  public int hashCode() {
    final int PRIME = 31;
    int result = 1;
    
    result = PRIME * result + length;
    result = PRIME * result + width;
    
    return result;
  }
  
  @Override
  public String toString() {
    final StringBuilder stringBuilder = new StringBuilder("\nLength: ");
    stringBuilder.append(length).append("\nWidth: ").append(width);
    
    return stringBuilder.toString();
  }
}
