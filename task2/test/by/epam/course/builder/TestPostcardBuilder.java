package by.epam.course.builder;

import by.epam.course.entity.AdvertisingPostcard;
import by.epam.course.entity.CommonPostcard;
import by.epam.course.entity.CongratulatoryPostcard;
import by.epam.course.entity.Paper;
import by.epam.course.entity.PaperSize;
import by.epam.course.exception.XmlException;
import by.epam.course.factory.PostcardsBuilderFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestPostcardBuilder {
  private final String FILE_NAME = "resources/data/postcard.xml";
  
  private PostcardsAbstractBuilder domBuilder;
  private PostcardsAbstractBuilder saxBuilder;
  private PostcardsAbstractBuilder staxBuilder;
  
  @BeforeClass
  public void setUp() throws XmlException {
    domBuilder  = PostcardsBuilderFactory.createPostcardBuilder(
        PostcardsBuilderFactory.TypeParser.DOM);
    saxBuilder  = PostcardsBuilderFactory.createPostcardBuilder(
        PostcardsBuilderFactory.TypeParser.SAX);
    staxBuilder  = PostcardsBuilderFactory.createPostcardBuilder(
        PostcardsBuilderFactory.TypeParser.STAX);
    
    domBuilder.buildSetPostcards(FILE_NAME);
    saxBuilder.buildSetPostcards(FILE_NAME);
    staxBuilder.buildSetPostcards(FILE_NAME);
  }
  
  //Test DOM Builder 
  @Test (dataProvider = "setCommandPostcards")
  public void testCommonPostcardsDomBuilder(String id, String name, String country, String year,
      String author, int density, boolean isGloss, int length, int width, String thema) {
    
    CommonPostcard actual = (CommonPostcard)domBuilder.getPostcard(id);
    
    PaperSize size = new PaperSize(length, width);
    Paper paper = new Paper(isGloss, density, size);
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate date = LocalDate.parse(year, dateTimeFormatter);
    CommonPostcard expected = new CommonPostcard(id, name, country, date, author, paper, thema);
    
    Assert.assertEquals(actual, expected);
  }
  
  @Test (dataProvider = "setAdvertisingPostcards")
  public void testAdvertisingPostcardsDomBuilder(String id, String name, String country, 
      String year, String author, int density, boolean isGloss, int length, int width,
      String company, String webSite) {
    
    AdvertisingPostcard actual = (AdvertisingPostcard)domBuilder.getPostcard(id);
    
    PaperSize size = new PaperSize(length, width);
    Paper paper = new Paper(isGloss, density, size);
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate date = LocalDate.parse(year, dateTimeFormatter);
    AdvertisingPostcard expected = new AdvertisingPostcard(id, name, country, date, author, 
        paper, company, webSite);
    
    Assert.assertEquals(actual, expected);
  }
  
  @Test (dataProvider = "setCongratulatoryPostcards")
  public void testCongratulatoryPostcardsDomBuilder(String id, String name, String country, 
      String year, String author, int density, boolean isGloss, int length, int width, 
      String holiday, String message) {
    
    CongratulatoryPostcard actual = (CongratulatoryPostcard)domBuilder.getPostcard(id);
    
    PaperSize size = new PaperSize(length, width);
    Paper paper = new Paper(isGloss, density, size);
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate date = LocalDate.parse(year, dateTimeFormatter);
    CongratulatoryPostcard expected = new CongratulatoryPostcard(id, name, country, date, 
        author, paper, holiday, message);
    
    Assert.assertEquals(actual, expected);
  }
  
  // Test SAX Builder 
  @Test (dataProvider = "setCommandPostcards")
  public void testCommonPostcardsSaxBuilder(String id, String name, String country, String year,
      String author, int density, boolean isGloss, int length, int width, String thema) {
    
    CommonPostcard actual = (CommonPostcard)saxBuilder.getPostcard(id);
    
    PaperSize size = new PaperSize(length, width);
    Paper paper = new Paper(isGloss, density, size);
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate date = LocalDate.parse(year, dateTimeFormatter);
    CommonPostcard expected = new CommonPostcard(id, name, country, date, author, paper, thema);
    
    Assert.assertEquals(actual, expected);
  }
  
  @Test (dataProvider = "setAdvertisingPostcards")
  public void testAdvertisingPostcardsSaxBuilder(String id, String name, String country, 
      String year, String author, int density, boolean isGloss, int length, int width, 
      String company, String webSite) {
    
    AdvertisingPostcard actual = (AdvertisingPostcard)saxBuilder.getPostcard(id);
    
    PaperSize size = new PaperSize(length, width);
    Paper paper = new Paper(isGloss, density, size);
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate date = LocalDate.parse(year, dateTimeFormatter);
    AdvertisingPostcard expected = new AdvertisingPostcard(id, name, country, date, author, paper,
        company, webSite);
    
    Assert.assertEquals(actual, expected);
  }
  
  @Test (dataProvider = "setCongratulatoryPostcards")
  public void testCongratulatoryPostcardsSaxBuilder(String id, String name, String country,
      String year, String author, int density, boolean isGloss, int length, int width, 
      String holiday, String message) {
    
    CongratulatoryPostcard actual = (CongratulatoryPostcard)saxBuilder.getPostcard(id);
    
    PaperSize size = new PaperSize(length, width);
    Paper paper = new Paper(isGloss, density, size);
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate date = LocalDate.parse(year, dateTimeFormatter);
    CongratulatoryPostcard expected = new CongratulatoryPostcard(id, name, country, date, author, 
        paper, holiday, message);
    
    Assert.assertEquals(actual, expected);
  }
  
  //Test STAX Builder 
  @Test (dataProvider = "setCommandPostcards")
  public void testCommonPostcardsStaxBuilder(String id, String name, String country, String year,
      String author, int density, boolean isGloss, int length, int width, String thema) {
   
    CommonPostcard actual = (CommonPostcard)staxBuilder.getPostcard(id);

    PaperSize size = new PaperSize(length, width);
    Paper paper = new Paper(isGloss, density, size);
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate date = LocalDate.parse(year, dateTimeFormatter);
    CommonPostcard expected = new CommonPostcard(id, name, country, date, author, paper, thema);

    Assert.assertEquals(actual, expected);
  }
 
  @Test (dataProvider = "setAdvertisingPostcards")
  public void testAdvertisingPostcardsStaxBuilder(String id, String name, String country, 
      String year, String author, int density, boolean isGloss, int length, int width, 
      String company, String webSite) {
   
    AdvertisingPostcard actual = (AdvertisingPostcard)staxBuilder.getPostcard(id);
   
    PaperSize size = new PaperSize(length, width);
    Paper paper = new Paper(isGloss, density, size);
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate date = LocalDate.parse(year, dateTimeFormatter);
    AdvertisingPostcard expected = new AdvertisingPostcard(id, name, country, date, author, paper,
        company, webSite);
   
    Assert.assertEquals(actual, expected);
  }
 
  @Test (dataProvider = "setCongratulatoryPostcards")
  public void testCongratulatoryPostcardsStaxBuilder(String id, String name, String country, 
      String year, String author, int density, boolean isGloss, int length, int width, 
      String holiday, String message) {
   
    CongratulatoryPostcard actual = (CongratulatoryPostcard)staxBuilder.getPostcard(id);
   
    PaperSize size = new PaperSize(length, width);
    Paper paper = new Paper(isGloss, density, size);
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate date = LocalDate.parse(year, dateTimeFormatter);
    CongratulatoryPostcard expected = new CongratulatoryPostcard(id, name, country, date, author, 
        paper, holiday, message);
   
    Assert.assertEquals(actual, expected);
  }
  
  /**
   * data for testCommonPostcards.
   * @return test data array 
   */
  @DataProvider
  public Object[][] setCommandPostcards() {
    return new Object[][] {
      {"card01", "Squirrel", "Great Britain", "2019-09-13", "Richard Hood", 300, true, 15, 10,
       "animals"},
      {"card02", "Vilnius", "Lithuania", "2013-10-09", "L. Jankauskas", 325, true, 15, 10,
       "architecture"},
      {"card03", "Harry Potter", "Russia", "2018-07-24", "Grape_Art_Com", 325, false, 15, 10,
       "movies"}
    };
  }
  
  /**
   * data for testAdvertisingPostcards.
   * @return test data array 
   */
  @DataProvider
  public Object[][] setAdvertisingPostcards() {
    return new Object[][] {
      {"card05", "Stroke", "Great Britain", "2009-03-13", "-", 300, true, 16, 11, "Stroke",
       "stroke.org.uk"}
    };
  }
  
  /**
   * data for testCongratulatoryPostcards.
   * @return test data array 
   */
  @DataProvider
  public Object[][] setCongratulatoryPostcards() {
    return new Object[][] {
      {"card07", "Happy birthday", "Russia", "1991-01-29", "I. Dergileva", 325, false, 15, 10,
       "Birthday", "Happy Birthday!!!"},
      {"card09", "Marry Christmas", "Germany", "2001-06-22", "Corazza", 325, false, 15, 10,
       "Christmas", "Marry Christmas!!!"}
    };
  }
  
  @AfterClass
  public void tierDown() {
    domBuilder = null;
    saxBuilder = null;
    staxBuilder = null;
  }
}
