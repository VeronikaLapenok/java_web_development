package by.epam.course.handler;

import by.epam.course.entity.AdvertisingPostcard;
import by.epam.course.entity.CommonPostcard;
import by.epam.course.entity.CongratulatoryPostcard;
import by.epam.course.entity.Postcard;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class PostcardHandler extends DefaultHandler {
  private final String COMMON_POSTCARD = "common_postcard";
  private final String ADVERTISING_POSTCARD = "advertising_postcard";
  private final String CONGRATULATORY_POSTCARD = "congratulatory_postcard";
  private final String ID = "id";
  
  private Set<Postcard> postcards;
  private Postcard current;
  private PostcardXmlTag currentXmlTag;
  private EnumSet<PostcardXmlTag> withText;
  DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

  public PostcardHandler() {
    postcards = new HashSet<Postcard>();
    withText = EnumSet.range(PostcardXmlTag.THEMA, PostcardXmlTag.AUTHOR);
  }
  
  public Set<Postcard> getPostcards() {
    return postcards;
  }
  
  public void fillAttributes(Attributes attributes) {
    for (int i = 0; i < attributes.getLength(); i++) {
      if (attributes.getQName(i) == ID) {
        current.setId(attributes.getValue(i));
      } else {
        current.setName(attributes.getValue(i));
      }
    }
  }
  
  public void startElement(String uri, String localName, String qName, Attributes attributes) {
    if (COMMON_POSTCARD.equals(qName)) {
      current = new CommonPostcard();
      fillAttributes(attributes);
    } else if (ADVERTISING_POSTCARD.equals(qName)) {
      current = new AdvertisingPostcard();
      fillAttributes(attributes);
    } else if (CONGRATULATORY_POSTCARD.equals(qName)) {
      current = new CongratulatoryPostcard();
      fillAttributes(attributes);
    } else {
      PostcardXmlTag temp = PostcardXmlTag.valueOf(qName.toUpperCase());
      if (withText != null & withText.contains(temp)) {
        currentXmlTag = temp;
      }
    }
  }
  
  public void endElement(String uri, String localName, String qName) {
    if ((COMMON_POSTCARD.equals(qName)) || (ADVERTISING_POSTCARD.equals(qName)) || (CONGRATULATORY_POSTCARD.equals(qName))) {
      postcards.add(current);
    }
  }
  
  public void characters(char[] character, int start, int length) {
    String data = new String(character, start, length).strip();
    if (currentXmlTag != null) {
      switch (currentXmlTag) {
        case THEMA:
          ((CommonPostcard) current).setThema(data);
          break;
        case COMPANY:
          ((AdvertisingPostcard) current).setCompany(data);
          break;
        case WEB_SITE:
          ((AdvertisingPostcard) current).setWebSite(data);
          break;
        case HOLIDAY:
          ((CongratulatoryPostcard) current).setHoliday(data);
          break;
        case MESSAGE:
          ((CongratulatoryPostcard) current).setMessage(data);
          break;
        case DENSITY:
          current.getPaper().setDensity(Integer.parseInt(data));
        case IS_GLOSS:
          current.getPaper().setIsGloss(Boolean.parseBoolean(data));
          break;
        case LENGTH:
          current.getPaper().getSize().setLength(Integer.parseInt(data));
          break;
        case WIDTH:
          current.getPaper().getSize().setWidth(Integer.parseInt(data));
          break;
        case COUNTRY:
          current.setCountry(data);
          break;
        case YEAR:
          current.setYear(LocalDate.parse(data, dateTimeFormatter));
          break;
        case AUTHOR:
          current.setAuthor(data);
        default:
          break;
      }
      currentXmlTag = null;
    }
  }
}
