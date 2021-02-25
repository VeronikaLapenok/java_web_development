package by.epam.course.main;

import by.epam.course.action.*;
import by.epam.course.composite.*;
import by.epam.course.exception.TextException;
import by.epam.course.parser.*;
import by.epam.course.parser.impl.*;
import by.epam.course.reader.TextFileReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextMain {
  private static Logger logger = LogManager.getLogger();
  
  public static void main(String[] args) throws TextException {
    TextFileReader reader = new TextFileReader();
    String text = reader.readTextFile("resources/data/text.txt");
    
    CommonParser parser = new ParagraphParser();
    TextComponent commonText = parser.parse(text);
    logger.debug(commonText);
    
    
    TextAction action = new TextAction();
    action.sortParagraphs(commonText);
    action.deleteSentences(commonText, 5);
    action.findTheLongestWordInSentence(commonText);
    action.findSameWords(commonText);
  }
}
