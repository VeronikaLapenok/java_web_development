package by.epam.course.main;

import by.epam.course.builder.*;
import by.epam.course.exception.*;
import by.epam.course.factory.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class XmlMain {
  private static Logger logger = LogManager.getLogger();
  
  public static void main(String [] args) {
    PostcardsAbstractBuilder builder = PostcardsBuilderFactory.createPostcardBuilder(PostcardsBuilderFactory.TypeParser.DOM);
    try {
    builder.buildSetPostcards("resources/data/postcard.xml");
    logger.debug(builder.getPostcards());
  } catch (XmlException e) {
    logger.error(e.getMessage());
  }
  }
}
