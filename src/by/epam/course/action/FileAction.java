package by.epam.course.action;

import java.io.IOException;
import java.io.FileReader;
import java.util.Scanner;

public class FileAction {
  public void readFile(String path) throws IOException {
    FileReader file = new FileReader(path);
    Scanner scan = new Scanner(file);
    
    System.out.println(scan.nextLine());    
    
    scan.close();
    file.close();
  }

}
