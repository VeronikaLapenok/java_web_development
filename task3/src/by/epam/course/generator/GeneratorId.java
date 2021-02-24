package by.epam.course.generator;

public class GeneratorId {
  private static int counterId = 0;
  
  public static int getId() {
    return counterId++;
  }
}
