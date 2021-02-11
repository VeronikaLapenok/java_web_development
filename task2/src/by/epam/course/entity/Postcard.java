package by.epam.course.entity;

import java.time.LocalDate;

public class Postcard {
  private String id;
  private String name;
  private String country;
  private LocalDate date;
  private String author;
  
  private Paper paper;
  
  public Postcard() {
    paper = new Paper();
  }
  
  public Postcard(String id, String name, String country,
                  LocalDate year, String author, Paper paper) {
    
    this.id = id;
    this.name = name;
    this.country = country;
    this.date = year;
    this.author = author;
    this.paper = paper;
  }
  
  public boolean isValid() {
    return (id != null && !id.isEmpty());
  }
  
  public String getId() {
    return id;
  }
  
  public void setId(String id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getCountry() {
    return country;
  }
  
  public void setCountry(String country) {
    this.country = country;
  }
  
  public LocalDate getDate() {
    return date;
  }
  
  public void setYear(LocalDate year) {
    this.date = year;
  }
  
  public String getAuthor() {
    return author;
  }
  
  public void setAuthor(String author) {
    this.author = author;
  }
  
  public Paper getPaper() {
    return paper;
  }
  
  public void setPaper(Paper paper) {
    this.paper = paper;
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
    
    Postcard other = (Postcard) object;
    
    if (!isValid() || !other.isValid()) {
      return false;
    } else if (!id.equals(other.id)) {
      return false;
    }
    
    if (name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!name.equals(other.name)) {
      return false;
    }
    
    if (country == null) {
      if (other.country != null) {
        return false;
      }
    } else if (!country.equals(other.country)) {
      return false;
    }
    
    if (date == null) {
      if (other.date != null) {
        return false;
      }
    } else if (!date.equals(other.date)) {
      return false;
    }
    
    if (author == null) {
      if (other.author != null) {
        return false;
      }
    } else if (!author.equals(other.author)) {
      return false;
    }
    
     return true;
  }
  
  @Override
  public int hashCode() {
    final int PRIME = 31;
    int result = 1;
    
    result = PRIME * result + ((id == null) ? 0 : id.hashCode());
    result = PRIME * result + ((name == null) ? 0 : name.hashCode());
    result = PRIME * result + ((country == null) ? 0 : country.hashCode());
    result = PRIME * result + ((date == null) ? 0 : date.hashCode());
    result = PRIME * result + ((author == null) ? 0 : author.hashCode());
    
    return result;
  }
  
  @Override
  public String toString() {
    final StringBuilder stringBuilder = new StringBuilder("\nID: ");
    stringBuilder.append(id).append("\nName: ").append(name).append("\n---------------");
    stringBuilder.append("\n\sPaper").append(paper).append("\n---------------");
    stringBuilder.append("\n\sInformation").append("\nCountry: ").append(country);
    stringBuilder.append("\nYear: ").append(date);
    stringBuilder.append("\nAuthor: ").append(author);
    
    return stringBuilder.toString();
  }
}
