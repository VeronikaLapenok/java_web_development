package by.epam.course.reader.impl;

import by.epam.course.exception.ConeException;
import by.epam.course.reader.DataReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConeDataReader implements DataReader {
  private static Logger logger = LogManager.getLogger();
  
  @Override
  public List<String> readAllData(String path) throws ConeException {
    final Path FILE_PATH = Paths.get(path);
    List<String> lines;
    
    try {
      Stream<String> lineStream = Files.lines(FILE_PATH);
      lines = lineStream.collect(Collectors.toList());
      lineStream.close();
    } catch (IOException e) {
      throw new ConeException("File " + path + " not found");
    }
    logger.debug("Data from file " + lines);
    
    return lines;
  }

}
