package by.epam.course.builder;

import by.epam.course.entity.AdvertisingPostcard;
import by.epam.course.entity.CommonPostcard;
import by.epam.course.entity.CongratulatoryPostcard;
import by.epam.course.entity.Paper;
import by.epam.course.entity.PaperSize;
import by.epam.course.entity.Postcard;
import by.epam.course.exception.XmlException;
import by.epam.course.handler.PostcardXmlTag;
import by.epam.course.validation.XmlValidation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
  public void buildSetPostcards(String xmlFileName) throws XmlException {
    if (!XmlValidation.isXmlValid(xmlFileName)) {
      throw new XmlException(xmlFileName + " is not correct or valid");
    }
    
    try (FileInputStream inputStream = new FileInputStream(new File(xmlFileName))) {
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
            default:
              break;
          }
        }
      }
    } catch (XMLStreamException |  IOException e) {
      logger.error(xmlFileName + " file error or file not found");;
    } 
  }
  
  private Postcard buildPostcard(XMLStreamReader reader, Postcard postcard) 
      throws XMLStreamException {
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
            default:
              break;
          }
          break;
        case XMLStreamConstants.END_ELEMENT:
          name = reader.getLocalName();
          if ((PostcardXmlTag.valueOf(name.toUpperCase()) == PostcardXmlTag.COMMON_POSTCARD)
              || (PostcardXmlTag.valueOf(name.toUpperCase()) == PostcardXmlTag
              .ADVERTISING_POSTCARD)
              || (PostcardXmlTag.valueOf(name.toUpperCase()) == PostcardXmlTag
              .CONGRATULATORY_POSTCARD)) {
            return postcard;
          }
        default:
          break;
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
            default:
              break;
          }
          break; 
        case XMLStreamConstants.END_ELEMENT:
          name = reader.getLocalName();
          if (PostcardXmlTag.valueOf(name.toUpperCase()) == PostcardXmlTag.PAPER) {
            return paper;
          }
        default:
          break;
      }
    }
    throw new XMLStreamException("Unknown element in tag <paper>");
  }
  
  private PaperSize getXmlSize(XMLStreamReader reader) throws XMLStreamException {
    PaperSize size = new PaperSize();
    
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
            default:
              break;
          }
          break;
        case XMLStreamConstants.END_ELEMENT:
          name = reader.getLocalName();
          if (PostcardXmlTag.valueOf(name.toUpperCase()) == PostcardXmlTag.SIZE) {
            return size;
          }
        default:
          break;
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
