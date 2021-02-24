package by.epam.course.entity;

import by.epam.course.generator.GeneratorId;

public abstract class Shape {
  private int coneId;
  
  public Shape() {
    this.coneId = GeneratorId.getId();
  }
  
  public int getConeId() {
    return coneId;
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
    
    Shape other = (Shape) object;
    
    if (coneId != other.coneId) {
      return false;
    }
    return true;
  }
  
  @Override
  public int hashCode() {
    final int PRIME = 31;
    int result = 1;
    
    result = PRIME * result + coneId;
    System.out.println(result);
        
    return result;
  }
  
  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("\nID: ").append(coneId);
    
    return stringBuilder.toString();
  }
}
