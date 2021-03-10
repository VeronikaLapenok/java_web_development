package by.epam.course.parser.impl;

import by.epam.course.composite.ComponentType;
import by.epam.course.composite.TextComposite;
import by.epam.course.exception.TextException;
import by.epam.course.parser.CommonParser;

public class SentenceParser implements CommonParser {
  private static final String DELIMITER = "(?<=([.!?.{3}]\\s))";
  private CommonParser lexemeParser = new LexemeParser();
  
  @Override
  public TextComposite parse(String text) throws TextException {
    TextComposite paragraph = new TextComposite(ComponentType.PARAGRAPH);
    String[] sentences = text.strip().split(DELIMITER);
    
    for (String item: sentences) {
      TextComposite sentence = lexemeParser.parse(item);
      paragraph.add(sentence);
    }
    return paragraph;
  }
}
