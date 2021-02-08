package by.epam.course.builder;

import by.epam.course.entity.Postcard;

import java.util.HashSet;
import java.util.Set;

public abstract class PostcardsAbstractBuilder {
  protected Set<Postcard> postcards;
  
  public PostcardsAbstractBuilder() {
    postcards = new HashSet<Postcard>();
  }
  
  public PostcardsAbstractBuilder(Set<Postcard> postcards) {
    this.postcards = postcards;
  }
  
  public Set<Postcard> getPostcards() {
    return postcards;
  }
  
  public abstract void buildSetPostcards(String fileName);

}
