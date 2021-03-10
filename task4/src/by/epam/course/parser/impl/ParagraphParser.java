package by.epam.course.parser.impl;

import by.epam.course.composite.ComponentType;
import by.epam.course.composite.TextComposite;
import by.epam.course.exception.TextException;
import by.epam.course.parser.CommonParser;

public class ParagraphParser implements CommonParser {
  private static final String DELIMITER = "\\s{2}|\\t";
  private CommonParser sentenceParser = new SentenceParser();
  
  @Override
  public TextComposite parse(String text) throws TextException {
    TextComposite commonText = new TextComposite(ComponentType.TEXT);
    String[] paragraphs = text.strip().split(DELIMITER);
    
    for (String item: paragraphs) {
      TextComposite paragraph = sentenceParser.parse(item);
      commonText.add(paragraph);
    }
    return commonText;
  }
}
