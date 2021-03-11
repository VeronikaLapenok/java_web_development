package by.epam.course.exception;

public class ThreadException extends Exception {
  public ThreadException() {
    
  }
  
  public ThreadException(String message) {
    super(message);
  }
  
  public ThreadException(String mesage, Throwable cause) {
    super(mesage, cause);
  }
  
  public ThreadException(Throwable cause) {
    super(cause);
  }
}
