package by.epam.course.entity;

public class ConeParameters {
  double square;
  double volume;
  
  public ConeParameters(double square, double volume) {
    this.square = square;
    this.volume = volume;
  }
  
  public double getSquare() {
    return square;
  }
  
  public void setSquare(double square) {
    this.square = square;
  }
  
  public double getVolume() {
    return volume;
  }
  
  public void setVolume(double volume) {
    this.volume = volume;
  }
  
  @Override
  public boolean equals(Object object) {
    if (!super.equals(object)) {
      return false;
    }
    
    if (this == object) {
      return true;
    }
    
    if (object == null) {
      return false;
    }
    
    if (getClass() != object.getClass()) {
      return false;
    }
    
    ConeParameters other = (ConeParameters) object;
    
    if (square != other.square) {
      return false;
    }
    
    if (volume != other.volume) {
      return false;
    }
    return true;
  }
  
  @Override
  public int hashCode() {
    final int PRIME = 41;
    int result = 1;
    
    result = PRIME * result + (int) square;
    result = PRIME * result + (int) volume;
    
    return result;
  }
  
  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Square = ").append(square);
    stringBuilder.append("Volume = ").append(volume);
    
    return stringBuilder.toString();
  }

}
