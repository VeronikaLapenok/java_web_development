package by.epam.course.composite;

import java.util.List;

public class Symbol implements TextComponent {
  private SymbolType type;
  private Character value;
  
  public Symbol() {
  }
  
  public Symbol(SymbolType type, Character value) {
    this.type = type;
    this.value = value;
  }
  
  public SymbolType getSymbolType() {
    return type;
  }
  
  public void setType(SymbolType type) {
    this.type = type;
  }
  
  @Override
  public Character getSymbolValue() {
    return value;
  }
  
  public void setValue(Character value) {
    this.value = value;
  }
  
  @Override
  public void add(TextComponent component) {
    throw new UnsupportedOperationException("Symbol.add() method is not supported");
  }
  
  @Override
  public void remove(TextComponent component) {
    throw new UnsupportedOperationException("Symbol.remove() method is not supported");
  }
  
  @Override
  public int size() {
    return 1;
  }
  
  @Override
  public List<TextComponent> getComponents() {
    throw new UnsupportedOperationException("Symbol.getComponents() method is not supported");
  }
  
  @Override
  public TextComponent getComponent(int index) {
    throw new UnsupportedOperationException("Symbol.getComponent() method is not supported");
  }
  
  @Override
  public ComponentType getComponentType() {
    return ComponentType.SYMBOL;
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
    
    Symbol other = (Symbol) object;
    
    if (type == null) {
      if (other.type != null) {
        return false;
      }
    } else if (!type.equals(other.type)) {
      return false;
    }
    
    if (value == null) {
      if (other.value != null) {
        return false;
      }
    } else if (!value.equals(other.value)) {
      return false;
    }
    
    return true;
  }
  
  @Override
  public int hashCode() {
    final int PRIME = 37;
    int result = 1;
    result = PRIME * result + ((type == null) ? 0 : type.hashCode());
    result = PRIME * result + ((value == null) ? 0 : value.hashCode());
    return result;
  }
  
  @Override
  public String toString() {
    return value.toString();
  }
}
