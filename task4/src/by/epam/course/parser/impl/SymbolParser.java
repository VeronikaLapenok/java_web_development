package by.epam.course.parser.impl;

import by.epam.course.composite.ComponentType;
import by.epam.course.composite.SymbolType;
import by.epam.course.composite.Symbol;
import by.epam.course.composite.TextComposite;
import by.epam.course.exception.TextException;
import by.epam.course.parser.CommonParser;

public class SymbolParser implements CommonParser {
  private static final String LETTER_REGEX = "[a-zA-Zа-яА-Я]";
  private static final String NUMBER_REGEX = "\\p{Digit}";
  private static final String PUNCTUATION_REGEX = "\\p{Punct}";
  
  @Override
  public TextComposite parse(String text) throws TextException {
    TextComposite lexeme = new TextComposite(ComponentType.LEXEME);
    
    for (int i = 0; i < text.length(); i++) {
      SymbolType type = SymbolType.UNKNOWN;
      char symbol = text.charAt(i);
      String string = String.valueOf(symbol);
      
      if (string.matches(NUMBER_REGEX)) {
        type = SymbolType.NUMBER;
      } else if (string.matches(LETTER_REGEX)) {
        type = SymbolType.LETTER;
      } else if (string.matches(PUNCTUATION_REGEX)) {
        type = SymbolType.PUNKTUATION;
      }
      
      if (type != SymbolType.UNKNOWN) {
        lexeme.add(new Symbol(type, symbol));
      }
    }
    
    return lexeme;
  }
}
