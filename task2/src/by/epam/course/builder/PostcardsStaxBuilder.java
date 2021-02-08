package by.epam.course.builder;

import by.epam.course.entity.AdvertisingPostcard;
import by.epam.course.entity.CommonPostcard;
import by.epam.course.entity.CongratulatoryPostcard;
import by.epam.course.entity.Paper;
import by.epam.course.entity.Postcard;
import by.epam.course.entity.Size;
import by.epam.course.handler.PostcardXmlTag;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;;

public class PostcardsStaxBuilder extends PostcardsAbstractBuilder {
  private static Logger logger = LogManager.getLogger();
  
  private XMLInputFactory inputFactory;
  DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
  
  public PostcardsStaxBuilder() {
    inputFactory = XMLInputFactory.newInstance();
    postcards = new HashSet<Postcard>();
  }
  
  public PostcardsStaxBuilder(Set<Postcard> postcards) {
    super(postcards);
  }
  
  @Override
  public void buildSetPostcards(String fileName) {
    try (FileInputStream inputStream = new FileInputStream(new File(fileName))){
      XMLStreamReader reader = inputFactory.createXMLStreamReader(inputStream);
      
      String name;
      while (reader.hasNext()) {
        if (reader.next() == XMLStreamConstants.START_ELEMENT) {
          name = reader.getLocalName();
          switch (PostcardXmlTag.valueOf(name.toUpperCase())) {
            case COMMON_POSTCARD:
              postcards.add(buildPostcard(reader, new CommonPostcard()));
              break;
            case ADVERTISING_POSTCARD:
              postcards.add(buildPostcard(reader, new AdvertisingPostcard()));
              break;
            case CONGRATULATORY_POSTCARD:
              postcards.add(buildPostcard(reader, new CongratulatoryPostcard()));
              break;
            }
          }
      }
    } catch (XMLStreamException e) {
      e.printStackTrace();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  private Postcard buildPostcard(XMLStreamReader reader, Postcard postcard) throws XMLStreamException {
    postcard.setId(reader.getAttributeValue(null, PostcardXmlTag.ID.getValue()));
    postcard.setName(reader.getAttributeValue(null, PostcardXmlTag.NAME.getValue()));
    
    String name;
    while (reader.hasNext()) {
      switch (reader.next()) {
        case XMLStreamConstants.START_ELEMENT:
          name = reader.getLocalName();
          switch (PostcardXmlTag.valueOf(name.toUpperCase())) {
            case THEMA:
              ((CommonPostcard) postcard).setThema(getXmlText(reader));
              break;
            case COMPANY:
              ((AdvertisingPostcard) postcard).setCompany(getXmlText(reader));
              break;
            case WEB_SITE:
              ((AdvertisingPostcard) postcard).setWebSite(getXmlText(reader));
              break;
            case HOLIDAY:
              ((CongratulatoryPostcard) postcard).setHoliday(getXmlText(reader));
              break;
            case MESSAGE:
              ((CongratulatoryPostcard) postcard).setMessage(getXmlText(reader));
              break;
            case COUNTRY:
              postcard.setCountry(getXmlText(reader));
              break;
            case YEAR:
              postcard.setYear(LocalDate.parse(getXmlText(reader), dateTimeFormatter));
              break;
            case AUTHOR:
              postcard.setAuthor(getXmlText(reader));
              break;
            case PAPER:
              postcard.setPaper(getXmlPaper(reader));
              break;
          }
          break;
        case XMLStreamConstants.END_ELEMENT:
          name = reader.getLocalName();
          if ((PostcardXmlTag.valueOf(name.toUpperCase()) == PostcardXmlTag.COMMON_POSTCARD) ||
             (PostcardXmlTag.valueOf(name.toUpperCase()) == PostcardXmlTag.ADVERTISING_POSTCARD) ||
             (PostcardXmlTag.valueOf(name.toUpperCase()) == PostcardXmlTag.CONGRATULATORY_POSTCARD)) {
            return postcard;
          }
      }
    }
    throw new XMLStreamException("Unknown element");
  }
  
  private Paper getXmlPaper(XMLStreamReader reader) throws XMLStreamException {
    Paper paper = new Paper();
    
    String name;
    while (reader.hasNext()) {
      switch (reader.next()) {
        case XMLStreamConstants.START_ELEMENT:
          name = reader.getLocalName();
          switch (PostcardXmlTag.valueOf(name.toUpperCase())) {
            case DENSITY:
              paper.setDensity(Integer.parseInt(getXmlText(reader)));
              break;
            case IS_GLOSS:
              paper.setIsGloss(Boolean.parseBoolean(getXmlText(reader)));
              break;
            case SIZE:
              paper.setSize(getXmlSize(reader));
              break;
          }
          break;
        case XMLStreamConstants.END_ELEMENT:
          name = reader.getLocalName();
          if (PostcardXmlTag.valueOf(name.toUpperCase()) == PostcardXmlTag.PAPER) {
            return paper;
          }
      }
    }
    throw new XMLStreamException("Unknown element in tag <paper>");
  }
  
  private Size getXmlSize(XMLStreamReader reader) throws XMLStreamException {
    Size size = new Size();
    
    String name;
    while (reader.hasNext()) {
      switch (reader.next()) {
        case XMLStreamConstants.START_ELEMENT:
          name = reader.getLocalName();
          switch (PostcardXmlTag.valueOf(name.toUpperCase())) {
            case LENGTH:
              size.setLength(Integer.parseInt(getXmlText(reader)));
              break;
            case WIDTH:
              size.setWidth(Integer.parseInt(getXmlText(reader)));
              break;
          }
          break;
        case XMLStreamConstants.END_ELEMENT:
          name = reader.getLocalName();
          if (PostcardXmlTag.valueOf(name.toUpperCase()) == PostcardXmlTag.SIZE) {
            return size;
          }
      }
    }
    throw new XMLStreamException("Unknown element in tag <paper>");
  }
  
  private String getXmlText(XMLStreamReader reader) throws XMLStreamException {
    String text = null;
    if (reader.hasNext()) {
        reader.next();
        text = reader.getText();
    }
    return text;
}   
}
