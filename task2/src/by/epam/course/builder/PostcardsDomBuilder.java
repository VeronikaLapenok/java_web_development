package by.epam.course.builder;

import by.epam.course.entity.AdvertisingPostcard;
import by.epam.course.entity.CommonPostcard;
import by.epam.course.entity.CongratulatoryPostcard;
import by.epam.course.entity.Paper;
import by.epam.course.entity.Postcard;
import by.epam.course.entity.Size;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class PostcardsDomBuilder extends PostcardsAbstractBuilder {
  private static Logger logger = LogManager.getLogger();
  
  private DocumentBuilder documentBuilder;
  DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
  
  public PostcardsDomBuilder() {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    
    try {
      documentBuilder = factory.newDocumentBuilder();
    } catch (ParserConfigurationException e) {
      logger.error("Parser configuration exception" + e);
    }
  }
  
  public PostcardsDomBuilder(Set<Postcard> postcards) {
    super(postcards);
  }
  
  /**
   * create a set of postcards by tag name.
   * @param tagName - tag name of element
   * @param root - a root in the postcard.xml
   */
  public void buildSetByTagName(String tagName, Element root) {
    NodeList postcardsList = root.getElementsByTagName(tagName);
    for (int i = 0; i < postcardsList.getLength(); i++) {
      Element postcardElement = (Element) postcardsList.item(i);
      Postcard postcard = buildPostcard(postcardElement);
      postcards.add(postcard);
    }
  }
  
  @Override
  public void buildSetPostcards(String fileName) {
    Document document;
    
    try {
      document = documentBuilder.parse(fileName);
      Element root = document.getDocumentElement();
      buildSetByTagName("common_postcard", root);
      buildSetByTagName("advertising_postcard", root);
      buildSetByTagName("congratulatory_postcard", root);
    } catch (IOException | SAXException e) {
      e.printStackTrace();//File error or file not found
    }
  }
  
  private Postcard buildPostcard(Element postcardElement) {
    Postcard postcard;
    
    switch (postcardElement.getTagName()) {
    case "congratulatory_postcard":
      postcard = new CongratulatoryPostcard();
      
      ((CongratulatoryPostcard) postcard).setHoliday(String.valueOf(getElementTextContent(postcardElement, "holiday")));
      ((CongratulatoryPostcard) postcard).setMessage(String.valueOf(getElementTextContent(postcardElement, "message")));
      break;
    case "advertising_postcard":
      postcard = new AdvertisingPostcard();
      
      ((AdvertisingPostcard) postcard).setCompany(getElementTextContent(postcardElement, "company"));
      ((AdvertisingPostcard) postcard).setWebSite(String.valueOf(getElementTextContent(postcardElement, "web_site")));
      break;
    default:
      postcard = new CommonPostcard();
      
      ((CommonPostcard) postcard).setThema(String.valueOf(getElementTextContent(postcardElement, "thema")));
      break;
    }
    
    postcard.setId(postcardElement.getAttribute("id"));
    postcard.setName(postcardElement.getAttribute("name"));
    postcard.setCountry(getElementTextContent(postcardElement, "country"));
    LocalDate year = LocalDate.parse(getElementTextContent(postcardElement, "year"), dateTimeFormatter);
    postcard.setYear(year);
    postcard.setAuthor(getElementTextContent(postcardElement, "author"));
    
    Paper paper = postcard.getPaper();
    Element paperElement = (Element) postcardElement.getElementsByTagName("paper").item(0);
    Integer density = Integer.parseInt(getElementTextContent(paperElement, "density"));
    paper.setDensity(density);
    Boolean isGloss = Boolean.parseBoolean(getElementTextContent(paperElement, "is_gloss"));
    paper.setIsGloss(isGloss);
    
    Size size = paper.getSize();
    Element sizeElement = (Element) paperElement.getElementsByTagName("size").item(0);
    Integer length = Integer.parseInt(getElementTextContent(sizeElement, "length"));
    size.setLength(length);
    Integer width = Integer.parseInt(getElementTextContent(sizeElement, "width"));
    size.setWidth(width);
    
    return postcard;
  }
  
  private static String getElementTextContent(Element element, String elementName) {
    NodeList nodeList = element.getElementsByTagName(elementName);
    Node node = nodeList.item(0);
    String text = node.getTextContent();
    return text;
  }
}
