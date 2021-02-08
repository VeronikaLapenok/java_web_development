package by.epam.course.builder;

import by.epam.course.entity.Postcard;
import by.epam.course.handler.PostcardErrorHandler;
import by.epam.course.handler.PostcardHandler;

import java.io.IOException;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class PostcardsSaxBuilder extends PostcardsAbstractBuilder {
  private static Logger logger = LogManager.getLogger();
  
  private PostcardHandler handler = new PostcardHandler();
  private XMLReader reader;
  
  public PostcardsSaxBuilder() {
    SAXParserFactory factory = SAXParserFactory.newInstance();
    try {
      SAXParser saxParser = factory.newSAXParser();
      reader = saxParser.getXMLReader();
    } catch (ParserConfigurationException | SAXException e) {
      e.printStackTrace();
    }
    reader.setErrorHandler(new PostcardErrorHandler());
    reader.setContentHandler(handler);
  }
  
  public PostcardsSaxBuilder(Set<Postcard> postcards) {
    super(postcards);
  }
  
  @Override
  public void buildSetPostcards(String fileName) {
    try {
      reader.parse(fileName);
    } catch (IOException | SAXException e) {
      e.printStackTrace();
    }
    postcards = handler.getPostcards();
  }
}
