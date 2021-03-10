package by.epam.course.parser;

import by.epam.course.composite.TextComposite;
import by.epam.course.exception.TextException;

public interface CommonParser {
   TextComposite parse(String text) throws TextException;
}
