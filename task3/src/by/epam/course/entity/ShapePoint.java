package by.epam.course.entity;

public class ShapePoint {
  private double x;
  private double y; 
  private double z;
  
  public ShapePoint() {
  }
  
  public ShapePoint(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }
  
  public double getX() {
    return x;
  }
  
  public void setX(double x) {
    this.x = x;
  }
  
  public double getY() {
    return y;
  }
  
  public void setY(double y) {
    this.y = y;
  }
  
  public double getZ() {
    return z;
  }
  
  public void setZ(double z) {
    this.z = z;
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
    
    ShapePoint other = (ShapePoint) object;
    
    if (x != other.x) {
      return false;
    }
    
    if  (y != other.y) {
      return false;
    }
    
    if (z != other.z) {
      return false;
    }
    
    return true;
  }
  
  @Override
  public int hashCode() {
    final int PRIME = 37;
    int result = 1;
    
    result = PRIME * result + (int) x;
    result = PRIME * result + (int) y;
    result = PRIME * result + (int) z;
    
    return result;
  }
  
  @Override
  public String toString() {
    final StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("\ncoordinate x = ").append(x);
    stringBuilder.append("\ncoordinate y = ").append(y);
    stringBuilder.append("\ncoordinate z = ").append(z);
    
    return stringBuilder.toString();
  }

}
