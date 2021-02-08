package by.epam.course.entity;

import java.time.LocalDate;

public class CongratulatoryPostcard extends Postcard {
  String holiday;
  String message;
  
  public CongratulatoryPostcard() {
    
  }
  
  public CongratulatoryPostcard(String id, String name, String country, 
                             LocalDate year, String author, Paper paper) {
    super (id, name, country, year, author, paper);
  }
  
  public String getHoliday() {
    return holiday;
  }
  
  public void setHoliday(String holiday) {
    this.holiday = holiday;
  }
  
  public String getMessage() {
    return message;
  }
  
  public void setMessage(String message) {
    this.message = message;
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
    final StringBuilder stringBuilder = new StringBuilder();
    
    stringBuilder.append(super.toString());
    stringBuilder.append("\nHoliday: ").append(holiday);
    stringBuilder.append("\nMessage: ").append(message).append("\n");
    
    return stringBuilder.toString();
  }

}
