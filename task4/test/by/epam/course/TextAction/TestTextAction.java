package by.epam.course.TextAction;

import by.epam.course.action.TextAction;
import by.epam.course.composite.TextComponent;
import by.epam.course.exception.TextException;
import by.epam.course.parser.CommonParser;
import by.epam.course.parser.impl.ParagraphParser;
import by.epam.course.reader.TextFileReader;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestTextAction {
  private static final String FILE_PATH = "resources/data/text.txt";
  TextFileReader reader;
  CommonParser parser;
  TextAction action;
  
  @BeforeClass
  public void setUp() throws TextException {
    reader = new TextFileReader();
    parser = new ParagraphParser();
    action = new TextAction();
  }
  
  @Test
  public void testSortParagraphs() throws TextException {
    String text = reader.readTextFile(FILE_PATH);
    TextComponent commonText = parser.parse(text);
    action.sortParagraphs(commonText);
    
    String actual = commonText.toString(); 
    String expected = "\n\tIt is a established fact that a reader will be of a page when looking at its layout...\n" + 
                      "\tBye бандерлоги.\n" + 
                      "\tIt has survived - not only (five) centuries, but also the leap into electronic typesetting, " +
                      "remaining essentially unchanged. It was popularised in the \"Динамо\" (Рига) with the release of " +
                      "Letraset sheets.toString() containing Lorem Ipsum passages, and more recently with desktop publishing " +
                      "software like Aldus PageMaker Faclon9 including versions of Lorem Ipsum!\n" + 
                      "\tIt is a long a!=b established fact that a reader will be distracted by the readable content of a " +
                      "page when looking at its layout. The point of using Ipsum is that it has a more-or-less normal " +
                      "distribution ob.toString(a?b:c), as opposed to using (Content here), content here's, making it look " +
                      "like readable English?";  
    
    System.out.println("\nActual: " + actual);
    System.out.println("\nExpected: " + expected);
    
    Assert.assertEquals(actual, expected);
  }
  
  @Test
  public void testDeleteSentences() throws TextException {
    String text = reader.readTextFile(FILE_PATH);
    TextComponent commonText = parser.parse(text);
    action.deleteSentences(commonText, 4);
    
    String actual = commonText.toString();
    String expected = "\n\tIt has survived - not only (five) centuries, but also the leap into electronic typesetting, " +
                      "remaining essentially unchanged. It was popularised in the \"Динамо\" (Рига) with the release of " +
                      "Letraset sheets.toString() containing Lorem Ipsum passages, and more recently with desktop publishing " +
                      "software like Aldus PageMaker Faclon9 including versions of Lorem Ipsum!\n" + 
                      "\tIt is a long a!=b established fact that a reader will be distracted by the readable content of " +
                      "a page when looking at its layout. The point of using Ipsum is that it has a more-or-less normal " +
                      "distribution ob.toString(a?b:c), as opposed to using (Content here), content here's, making it look " +
                      "like readable English?\n" +
                      "\tIt is a established fact that a reader will be of a page when looking at its layout...";
    
    Assert.assertEquals(actual, expected);
  }
  
  @Test
  public void testFindTheLongestWordInSentence() throws TextException {
    String text = reader.readTextFile(FILE_PATH);
    TextComponent commonText = parser.parse(text);
    
    String actual = action.findTheLongestWordInSentence(commonText);
    String expected = "The point of using Ipsum is that it has a more-or-less normal distribution ob.toString(a?b:c), " +
                      "as opposed to using (Content here), content here's, making it look like readable English?";
                      
    
    Assert.assertEquals(actual, expected);
  }
  
  @Test
  public void testFindSameWords() throws TextException {
    String text = reader.readTextFile(FILE_PATH);
    TextComponent commonText = parser.parse(text);
    
    Map<String, Integer> actual = action.findSameWords(commonText);
    Map<String, Integer> expected = new HashMap<>();
    expected.put("reader", 2);
    expected.put("when", 2);
    expected.put("that", 3);
    expected.put("lorem", 2);
    expected.put("has", 2);
    expected.put("readable", 2);
    expected.put("using", 2);
    expected.put("like", 2);
    expected.put("its", 2);
    expected.put("is", 3);
    expected.put("it", 6);
    expected.put("at", 2);
    expected.put("ipsum", 3);
    expected.put("looking", 2);
    expected.put("page", 2);
    expected.put("fact", 2);
    expected.put("be", 2);
    expected.put("content", 2);
    expected.put("of", 5);
    expected.put("established", 2);
    expected.put("a", 7);
    expected.put("will", 2);
    expected.put("the", 5);
    expected.put("layout", 2);
    expected.put("with", 2);
    
    Assert.assertEquals(actual, expected);
  }
  
  @AfterClass
  public void tierDown() {
    reader = null;
    parser = null;
    action = null;
  }
}
