package by.epam.course.validation;

import java.io.File;
import java.io.IOException;

import javax.xml.transform.Source;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

import by.epam.course.handler.PostcardErrorHandler;

public class XmlValidation {
  public static boolean isXmlValid(String xmlFilePath) {
    final String XSD_FILE_NAME = "resources/data/postcard.xsd";
    
    String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
    SchemaFactory factory = SchemaFactory.newInstance(language);
    File xsdLocation = new File(XSD_FILE_NAME);
    
    try {
      Schema schema = factory.newSchema(xsdLocation);
      Validator validator = schema.newValidator();
      Source source = new StreamSource(xmlFilePath);
      validator.setErrorHandler(new PostcardErrorHandler());
      validator.validate(source);
      return true;
    } catch (SAXException | IOException e) {
      return false;
    }
  }
}
