package by.epam.course.reader;

import by.epam.course.exception.TextException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextFileReader {
  private static final String REGEX = "^\\s.*$";
  private static final String DELIMITER = " ";
  private static Logger logger = LogManager.getLogger();
  
  public String readTextFile(String filePath) throws TextException {
    final Path FILE_PATH = Paths.get(filePath);
    List<String> lines;
    
    try {
      Stream<String> lineStream = Files.lines(FILE_PATH);
      lines = lineStream.collect(Collectors.toList());
      lineStream.close();
    } catch (IOException e) {
      throw new TextException("File " + filePath + " not found");
    }
    
    String text = "";
    
    for (String line: lines) {
      if (!line.isEmpty() && !line.matches(REGEX)) {
        line = DELIMITER + line;
      }
      text = text + line;
    }
    
    logger.debug("Data from file:" + text);
    
    return text;
  }
}
