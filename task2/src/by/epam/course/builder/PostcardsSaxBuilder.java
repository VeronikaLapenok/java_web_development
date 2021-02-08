package by.epam.course.builder;

import by.epam.course.entity.Postcard;
import by.epam.course.exception.XmlException;
import by.epam.course.handler.PostcardErrorHandler;
import by.epam.course.handler.PostcardHandler;
import by.epam.course.validation.XmlValidation;

import java.io.IOException;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class PostcardsSaxBuilder extends PostcardsAbstractBuilder {
  private static Logger logger = LogManager.getLogger();
  
  private PostcardHandler handler = new PostcardHandler();
  private XMLReader reader;
  
  /**
   * constructor for class PostcardsSaxBuilder.
   */
  public PostcardsSaxBuilder() {
    SAXParserFactory factory = SAXParserFactory.newInstance();
    try {
      SAXParser saxParser = factory.newSAXParser();
      reader = saxParser.getXMLReader();
    } catch (ParserConfigurationException | SAXException e) {
      logger.error("Parser configuration exception");
    }
    reader.setErrorHandler(new PostcardErrorHandler());
    reader.setContentHandler(handler);
  }
  
  /**
   * constructor for class PostcardsSaxBuilder.
   * @param postcards - set of elements postcards (type Set Postcard)
   */
  public PostcardsSaxBuilder(Set<Postcard> postcards) {
    super(postcards);
  }
  
  @Override
  public void buildSetPostcards(String xmlFileName) throws XmlException {
    if (!XmlValidation.isXmlValid(xmlFileName)) {
      throw new XmlException(xmlFileName + " is not correct or valid");
    }
    
    try {
      reader.parse(xmlFileName);
    } catch (IOException | SAXException e) {
      logger.error(xmlFileName + " file error or file not found");
    }
    postcards = handler.getPostcards();
  }
}
