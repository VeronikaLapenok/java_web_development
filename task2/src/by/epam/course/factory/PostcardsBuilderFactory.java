package by.epam.course.factory;

import by.epam.course.builder.PostcardsAbstractBuilder;
import by.epam.course.builder.PostcardsDomBuilder;
import by.epam.course.builder.PostcardsSaxBuilder;
import by.epam.course.builder.PostcardsStaxBuilder;

public class PostcardsBuilderFactory {
  public enum TypeParser {
    SAX, STAX, DOM
  }
  
  private PostcardsBuilderFactory() {
  }
  
  /**
   * create postcard builder for DOM, SAX and STAX parsers.
   * @param typeParser - type of the using parser (type TypeParser)
   * @return new PostcardsDomBuilder()/new PostcardsSaxBuilder()/PostcardsStaxBuilder()
   */
  public static PostcardsAbstractBuilder createPostcardBuilder(TypeParser typeParser) {
    switch (typeParser) {
      case DOM:
        return new PostcardsDomBuilder();
      case SAX:
        return new PostcardsSaxBuilder();
      case STAX:
        return new PostcardsStaxBuilder();
      default:
        throw new EnumConstantNotPresentException(typeParser.getDeclaringClass(),
            typeParser.name());
    }
  }
}
