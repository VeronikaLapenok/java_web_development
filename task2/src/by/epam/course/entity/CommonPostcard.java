package by.epam.course.entity;

import java.time.LocalDate;

public class CommonPostcard extends Postcard {
  private String thema;
  
  public CommonPostcard() {
    
  }
  
  public CommonPostcard (String id, String name, String country, 
                         LocalDate year, String author, Paper paper, String thema) {
    super (id, name, country, year, author, paper);
    setThema(thema);
  }
  
  public String getThema() {
    return thema;
  }
  
  public void setThema(String thema) {
    this.thema = thema;
  }
  
  @Override
  public boolean equals(Object object) {
    if (!super.equals(object)) {
      return false;
    }
    
    CommonPostcard other = (CommonPostcard) object;
    
    if (thema == null) {
      if (other.thema != null) {
        return false;
      }
    } else if (!thema.equals(other.thema)) {
      return false;
    }
    
     return true;
  }
  
  @Override
  public int hashCode() {
    final int PRIME = 31 + super.hashCode();
    int result = 1;
    
    result = PRIME * result + ((thema == null) ? 0 : thema.hashCode());
    
    return result;
  }
  
  @Override
  public String toString() {
    final StringBuilder stringBuilder = new StringBuilder();
    
    stringBuilder.append(super.toString());
    stringBuilder.append("\nThema: ").append(thema).append("\n");
    
    return stringBuilder.toString();
  }
}
