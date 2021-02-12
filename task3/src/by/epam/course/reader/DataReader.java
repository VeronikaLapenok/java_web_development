package by.epam.course.reader;

import by.epam.course.exception.ConeException;

import java.util.List;

public interface DataReader {
  List<String> readAllData(String path) throws ConeException;
}
