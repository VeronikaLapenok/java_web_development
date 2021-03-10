package by.epam.course.action;

import by.epam.course.comparator.ParagraphComparator;
import by.epam.course.composite.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextAction {
  public static final String WORD_REGEX = ".+\\p{Punct}$";
  private static Logger logger = LogManager.getLogger();
  
  public void sortParagraphs(TextComponent text) {
    List<TextComponent> paragraphs = text.getComponents();
    
    paragraphs.sort(new ParagraphComparator());
    logger.debug("Sorted paragraphs by number of sentences: " + text);
  }
  
  public void deleteSentences(TextComponent text, int numberOfWords) {
    List<TextComponent> paragraphs = text.getComponents();
    List<TextComponent> removedSentences = new ArrayList<>();
    List<TextComponent> removedParagraphs = new ArrayList<>();
    
    for (TextComponent paragraph: paragraphs) {
      List<TextComponent> sentences = paragraph.getComponents();
      for (TextComponent sentence: sentences) {
        if (sentence.getComponents().size() < numberOfWords) {
          removedSentences.add(sentence);
        }
      }
      
      for (TextComponent sentence: removedSentences) {
        paragraph.remove(sentence);
      }
      if (sentences.isEmpty()) {
        removedParagraphs.add(paragraph);
      }
      
      removedSentences.clear();
    }
    
    for (TextComponent paragraph: removedParagraphs) {
      paragraphs.remove(paragraph);
    }
    
    logger.debug("Text after deliting sentences where number of words less than " + numberOfWords + ": " + text);
  }
  
  public String findTheLongestWordInSentence(TextComponent text) {
    TextComponent resultSentence = text;
    int longestWordSize = 0;
    
    for (TextComponent paragraph: text.getComponents()) {
      for (TextComponent sentence: paragraph.getComponents()) {
        for (TextComponent lexeme: sentence.getComponents()) {
          if (lexeme.getComponents().size() > longestWordSize) {
            longestWordSize = lexeme.getComponents().size();
            resultSentence = sentence;
          }
        }
      }
    }
    logger.debug("Sentence with the longest word is: \n" + resultSentence.toString());
    return resultSentence.toString();
  }
  
  public Map<String, Integer> findSameWords(TextComponent text) {
    Map<String, Integer> map = new HashMap<>();
    
    for (TextComponent paragraph: text.getComponents()) {
      for (TextComponent sentence: paragraph.getComponents()) {
        for (TextComponent lexeme: sentence.getComponents()) {
          String word = lexeme.toString().toLowerCase();
          if (word.matches(WORD_REGEX)) {
            word = word.replaceAll("\\p{Punct}", "");
          }
          if (map.containsKey(word)) {
            map.put(word, map.get(word) + 1);
          } else {
            map.put(word, 1);
          }
        }
      }
    }
    
    List<String> singleWords = new ArrayList<>();
    for (Map.Entry<String, Integer> word: map.entrySet()) {
      if (word.getValue() < 2 || word.getKey() == "") {
        singleWords.add(word.getKey());
      }
    }
    
    for (String word: singleWords) {
      map.remove(word);
    }
    
    logger.debug(map);
    return map;
  }
}
