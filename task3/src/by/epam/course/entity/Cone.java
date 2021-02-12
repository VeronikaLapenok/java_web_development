package by.epam.course.entity;

import by.epam.course.observer.ConeEvent;
import by.epam.course.observer.Observable;
import by.epam.course.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Cone extends Shape implements Observable {
  
  private ShapePoint pointTop;
  private ShapePoint pointBottom;
  private double radius;
  
  private List<Observer> observers = new ArrayList<>();
  
  public Cone() {
  }
  
  public Cone(double radius, ShapePoint pointTop, ShapePoint pointBottom) {
    this.radius = radius;
    this.pointTop = pointTop;
    this.pointBottom = pointBottom;
  }
  
  public double getRadius() {
    return radius;
  }
  
  public void setRadius(double radius) {
    this.radius = radius;
    notifyObserver();
  }
  
  public ShapePoint getPointTop() {
    return pointTop;
  }
  
  public void setPointTop(ShapePoint pointTop) {
    this.pointTop = pointTop;
    notifyObserver();
  }
  
  public ShapePoint getPointBottom() {
    return pointBottom;
  }
  
  public void setPointBottom(ShapePoint pointBottom) {
    this.pointBottom = pointBottom;
    notifyObserver();
  }
  
  @Override
  public void attach(Observer observer) {
    if (observer != null) {
      observers.add(observer);
    }
  }
  
  @Override
  public void detach(Observer observer) {
    observers.remove(observer);
  }
  
  @Override
  public void notifyObserver() {
    ConeEvent event = new ConeEvent(this);
    observers.forEach(o -> o.parameterChanged(event));
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
    
    Cone other = (Cone) object;
    
    if (radius != other.radius) {
      return false;
    }
    
    if (pointTop != other.pointTop) {
      return false;
    }
    
    if  (pointBottom != other.pointBottom) {
      return false;
    }
    
    return true;
  }
  
  @Override
  public int hashCode() {
    final int PRIME = 39 + super.hashCode();
    int result = 1;
    
    result = PRIME * result + (int) radius;
    result = PRIME * result + pointTop.hashCode();
    result = PRIME * result + pointBottom.hashCode();
    
    return result;
  }
  
  @Override
  public String toString() {
    final StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
    stringBuilder.append("\nRadius = ").append(radius);
    stringBuilder.append("\nTop point: ").append(pointTop);
    stringBuilder.append("\nBottom point: ").append(pointBottom);
    
    return stringBuilder.toString();
  }
}
