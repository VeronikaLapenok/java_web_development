package by.epam.course.handler;

public enum PostcardXmlTag {
  POSTCARDS("postcards"),
  POSTCARD("postcard"),
  ID("id"),
  NAME("name"),
  COMMON_POSTCARD("common_postcard"),
  ADVERTISING_POSTCARD("advertising_postcard"),
  CONGRATULATORY_POSTCARD("congratulatory_postcard"),
  PAPER("paper"),
  SIZE("size"),
  THEMA("thema"),
  COMPANY("company"),
  WEB_SITE("web_site"),
  HOLIDAY("holiday"),
  MESSAGE("message"),
  DENSITY("density"),
  IS_GLOSS("is_gloss"),
  LENGTH("length"),
  WIDTH("width"),
  COUNTRY("COUNTRY"),
  YEAR("year"),
  AUTHOR("author");

  private String value;
  
  PostcardXmlTag(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
