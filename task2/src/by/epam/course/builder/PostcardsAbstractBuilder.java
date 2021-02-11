package by.epam.course.builder;

import by.epam.course.entity.Postcard;
import by.epam.course.exception.XmlException;

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
  
  /**
   * get postcard.
   * @param id - id of the postcard (type String)
   * @return card
   */
  public Postcard getPostcard(String id) {   
    for (Postcard card: getPostcards()) {
      if (card.getId().equals(id)) {
        return card;
      }
    }
    
    return new Postcard();
  }
  
  public abstract void buildSetPostcards(String fileName) throws XmlException;

}
