package by.epam.course.entity;

import java.time.LocalDate;

public class CongratulatoryPostcard extends Postcard {
  String holiday;
  String message;
  
  public CongratulatoryPostcard() {
    
  }
  
  public CongratulatoryPostcard(String id, String name, String country, 
                             LocalDate year, String author, Paper paper,
                             String holiday, String message) {
    super (id, name, country, year, author, paper);
    this.holiday = holiday;
    this.message = message;
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
  public boolean equals(Object object) {
    if (!super.equals(object)) {
      return false;
    }
    
    CongratulatoryPostcard other = (CongratulatoryPostcard) object;
    
    if (holiday == null) {
      if (other.holiday != null) {
        return false;
      }
    } else if (!holiday.equals(other.holiday)) {
      return false;
    }
    
    if (message == null) {
      if (other.message != null) {
        return false;
      }
    } else if (!message.equals(other.message)) {
      return false;
    }
    
     return true;
  }
  
  @Override
  public int hashCode() {
    final int PRIME = 31 + super.hashCode();
    int result = 1;
    
    result = PRIME * result + ((holiday == null) ? 0 : holiday.hashCode());
    result = PRIME * result + ((message == null) ? 0 : message.hashCode());
    
    return result;
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
