package by.epam.course.composite;

import java.util.List;

public interface TextComponent {
  void add(TextComponent component);
  void remove(TextComponent component);
  int size();
  Character getSymbolValue();
  ComponentType getComponentType();
  SymbolType getSymbolType();
  List<TextComponent> getComponents();
  TextComponent getComponent(int index);
  String toString();
}
