package by.epam.course.entity;

import java.time.LocalDate;

public class Postcard {
  private String id;
  private String name;
  private String country;
  private LocalDate year;
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
    this.year = year;
    this.author = author;
    this.paper = paper;
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
  
  public LocalDate getYear() {
    return year;
  }
  
  public void setYear(LocalDate year) {
    this.year = year;
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
    final StringBuilder stringBuilder = new StringBuilder("\nID: ");
    stringBuilder.append(id).append("\nName: ").append(name).append("\n---------------");
    stringBuilder.append("\n\sPaper").append(paper).append("\n---------------");
    stringBuilder.append("\n\sInformation").append("\nCountry: ").append(country);
    stringBuilder.append("\nYear: ").append(year);
    stringBuilder.append("\nAuthor: ").append(author);
    
    return stringBuilder.toString();
  }
}
