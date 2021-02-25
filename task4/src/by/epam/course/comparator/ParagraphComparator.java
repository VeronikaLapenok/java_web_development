package by.epam.course.comparator;

import by.epam.course.composite.TextComponent;
import java.util.Comparator;

public class ParagraphComparator implements Comparator<TextComponent>{
  @Override
  public int compare(TextComponent paragraph1, TextComponent paragraph2) {
    int paragraphSize1 = paragraph1.getComponents().size();
    int paragraphSize2 = paragraph2.getComponents().size();
    
    return paragraphSize1 - paragraphSize2;
   }
}
