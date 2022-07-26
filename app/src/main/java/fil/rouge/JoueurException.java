package fil.rouge;
// https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/ArithmeticException.html
public class JoueurException extends ArithmeticException {
  JoueurException(String message) {
    super(message);
  }

}
