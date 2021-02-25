package by.epam.course.parser.impl;

import by.epam.course.composite.ComponentType;
import by.epam.course.composite.TextComposite;
import by.epam.course.exception.TextException;
import by.epam.course.parser.CommonParser;

public class LexemeParser implements CommonParser {
  public static final String DELIMITER = "\\s";
  private CommonParser symbolParser = new SymbolParser();
  
  @Override 
  public TextComposite parse(String text) throws TextException {
    TextComposite sentence = new TextComposite(ComponentType.SENTENCE);
    String[] lexemes = text.strip().split(DELIMITER);
    
    for (String item: lexemes) {  
      TextComposite lexeme = symbolParser.parse(item);
      sentence.add(lexeme);
    }
    return sentence;
  }
}
