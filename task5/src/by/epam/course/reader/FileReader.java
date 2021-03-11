package by.epam.course.reader;

import by.epam.course.exception.ThreadException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileReader {
  private static Logger logger = LogManager.getLogger();
  
  public List<String> readFile(String filePath) throws ThreadException {
    final Path FILE_PATH = Paths.get(filePath);
    List<String> lines;
    
    try {
      Stream<String> lineStream = Files.lines(FILE_PATH);
      lines = lineStream.collect(Collectors.toList());
      lineStream.close();
    } catch (IOException e) {
      throw new ThreadException("File " + filePath + " not found");
    }
    
    logger.debug("Data from file: " + lines);
    return lines;
  }
}