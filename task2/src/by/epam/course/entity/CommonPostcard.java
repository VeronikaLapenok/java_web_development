package by.epam.course.entity;

import java.time.LocalDate;

public class CommonPostcard extends Postcard {
  private String thema;
  
  public CommonPostcard() {
    
  }
  
  public CommonPostcard (String id, String name, String country, 
                         LocalDate year, String author, Paper paper) {
    super (id, name, country, year, author, paper);
  }
  
  public String getThema() {
    return thema;
  }
  
  public void setThema(String thema) {
    this.thema = thema;
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
    stringBuilder.append("\nThema: ").append(thema).append("\n");
    
    return stringBuilder.toString();
  }
}
