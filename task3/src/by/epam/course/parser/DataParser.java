package by.epam.course.parser;

import by.epam.course.exception.ConeException;

import java.util.List;

public interface DataParser {
  List<Object[]> parseData(List<String> lines) throws ConeException;
}
