package by.epam.course.factory;

import by.epam.course.builder.PostcardsAbstractBuilder;
import by.epam.course.builder.PostcardsDomBuilder;
import by.epam.course.builder.PostcardsSaxBuilder;
import by.epam.course.builder.PostcardsStaxBuilder;

public class PostcardsBuilderFactory {
  private enum TypeParser {
    SAX, STAX, DOM
  }
  
  private PostcardsBuilderFactory() {
  }
  
  public static PostcardsAbstractBuilder createPostcardBuilder(String typeParser) {
    TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
    switch (type) {
      case DOM:
        return new PostcardsDomBuilder();
      case SAX:
        return new PostcardsSaxBuilder();
      case STAX:
        return new PostcardsStaxBuilder();
      default:
        throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
    }
  }
}
