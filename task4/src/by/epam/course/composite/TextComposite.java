package by.epam.course.composite;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
  private static final String PARAGRAPH_DELIMITER = "\n\t";
  private static final String SENTENCE_AND_LEXEME_DELIMITER = " ";
  private ComponentType type;
  private List<TextComponent> components;
  
  public TextComposite() {
  }
  
  public TextComposite(ComponentType type) {
    this.type = type;
    this.components = new ArrayList<>();
  }
  
  public ComponentType getComponentType() {
    return type;
  }
  
  public void setType(ComponentType type) {
    this.type = type;
  }
  
  @Override
  public Character getSymbolValue() {
    throw new UnsupportedOperationException("Symbol.getSymbolValue() method is not supported");
  }
  
  @Override
  public List<TextComponent> getComponents() {
    return components;
  }
  
  @Override
  public void add(TextComponent component) {
    components.add(component);
  }
  
  @Override
  public void remove(TextComponent component) {
    components.remove(component);
  }
  
  @Override
  public int size() {
    return components.size();
  }
  
  @Override
  public TextComponent getComponent(int index) {
    return components.get(index);
  }
  
  @Override
  public SymbolType getSymbolType() {
    throw new UnsupportedOperationException("TextComposite.getSymbolType() method is not supported");
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
    
    TextComposite other = (TextComposite) object;
    
    if (!components.equals(other.components)) {
      return false;
    }
  
    if (type != other.type) {
      return false;
    }    
    
    return true;
  }
  
  @Override
  public int hashCode() {
    final int PRIME = 31;
    int result = 1;
    result = PRIME * result + ((type == null) ? 0 : type.hashCode());
    result = PRIME * result + ((components == null) ? 0 : components.hashCode());
    return result;
  }
  
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    
    for (TextComponent component: components) {
      String value = component.toString();
      if (component.getComponentType() == ComponentType.PARAGRAPH) {
        builder.append(PARAGRAPH_DELIMITER);
      } else if (!builder.toString().isEmpty() && component.getComponentType() != ComponentType.SYMBOL) {
        builder.append(SENTENCE_AND_LEXEME_DELIMITER);
      }
      builder.append(value);
    }
    return builder.toString();  
  }
}
