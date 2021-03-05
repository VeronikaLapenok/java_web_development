package by.epam.course.entity;

public class Student extends Person {
  private String name;
  
  public Student(int id, String name) {
    super(id);
    this.name = name;
  }

  public String toString() {
    StringBuilder builder = new StringBuilder("\n");
    builder.append("id: ").append(super.getPersonId());
    builder.append(" Name: ").append(name);
    
    return builder.toString();
  }
}
