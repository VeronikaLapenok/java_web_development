package by.epam.course.entity;

import java.util.concurrent.TimeUnit;

public class Auto extends Thread {
  
  private static final int TIMEOUT = 300;
  
  String number;
  double size;
  double weight;
  Type type;
  
  public Auto() {
  }
  
  public Auto(String number, double size, double weight, Type type) {
    this.number = number;
    this.size = size;
    this.weight = weight;
    this.type = type;
  }
  
  public enum Type {
    UNKNOWN,
    CAR,
    TRUCK
  }
  
  public String getNumber() {
    return number;
  }
  
  public void setNumber(String number) {
    this.number = number;
  }
  
  public double getSize() {
    return size;
  }
  
  public void setSize(double size) {
    this.size = size;
  }
  
  public double getWeight() {
    return weight;
  }
  
  public void setWeight(double weight) {
    this.weight = weight;
  }
  
  public Type type() {
    return type;
  }
  
  public void setType(Type type) {
    this.type = type;
  }
  
  @Override
  public void run() {
    Ferry ferry = Ferry.getInstance();
    while (ferry.getStatus() != Ferry.Status.LOADING || !ferry.load(this)) {
      try {
        TimeUnit.MILLISECONDS.sleep(TIMEOUT);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
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
    
    Auto other = (Auto) object;
    
    if (number != other.number) {
      return false;
    }
    
    if (size != other.size) {
      return false;
    }
    
    if (weight != other.weight) {
      return false;
    }
    
    if (type != other.type) {
      return false;
    }
    
    return true;
  }
  
  @Override
  public int hashCode() {
    final int PRIME = 31;
    int result = 1;
    result = PRIME * result + ((number == null) ? 0 : number.hashCode());
    result = PRIME * result + (int) size;
    result = PRIME * result + (int) weight;
    result = PRIME * result + ((type == null) ? 0 : type.hashCode());
    
    return result;
  }
  
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    
    builder.append("Number of the auto: ").append(number);
    builder.append(", Size = ").append(size);
    builder.append(", Weight = ").append(weight);
    builder.append(", Type: ").append(type);
    
    return builder.toString();
  }
}
