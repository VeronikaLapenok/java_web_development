package by.epam.course.validation;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import by.epam.course.handler.PostcardErrorHandler;

public class XmlValidation {
  public boolean isXmlValid() {
    //private static Logger logger = LogManager.getLogger();
    
    final String XML_FILE_NAME = "resourses/data/postcard.xml";
    final String XSD_FILE_NAME = "resourses/data/postcard.xsd";
    
    String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
    SchemaFactory factory = SchemaFactory.newInstance(language);
    File xsdLocation = new File(XSD_FILE_NAME);
    
    try {
      Schema schema = factory.newSchema(xsdLocation);
      Validator validator = schema.newValidator();
      validator.validate(new StreamSource(XML_FILE_NAME));
      return true;
    } catch (SAXException | IOException e) {
      //logger.error(XML_FILE_NAME + " is not correct or valid");
      return false;
    }
   
  }
  
  

}
