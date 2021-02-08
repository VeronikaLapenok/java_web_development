package by.epam.course.main;

import by.epam.course.builder.*;
import by.epam.course.entity.Postcard;
import by.epam.course.factory.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class XmlMain {
  private static Logger logger = LogManager.getLogger();
  
  public static void main(String [] args) {
    String type = "stax";
    PostcardsAbstractBuilder builder = PostcardsBuilderFactory.createPostcardBuilder(type);
    builder.buildSetPostcards("resourses/data/postcard.xml");
    logger.debug(builder.getPostcards());
  }

  

}
