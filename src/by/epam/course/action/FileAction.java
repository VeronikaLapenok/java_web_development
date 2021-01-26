package by.epam.course.action;

import by.epam.course.validation.Validation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileAction {
  /**
   * return the first valid string from file, otherwise return an empty string. 
   * @param path  - a file path (type String)
   * @return string
   * @throws IOException - file not found
   */
  public String read(String path) throws IOException {
    List<String> lines = new ArrayList<>();
    Path filePath = Paths.get(path);
    
    Stream<String> lineStream = Files.lines(filePath);
    lines = lineStream.collect(Collectors.toList());
    
    String string = "";
    for (String line: lines) {
      if (Validation.isString(line)) {
        string = line;
        break;
      }
    }
    lineStream.close();

    return string;
  }
}
