package fil.rouge;
// https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/ArithmeticException.html
public class JoueurException extends ArithmeticException {
  /**
	 * 
	 */
	private static final long serialVersionUID = 6088396107132165800L;

JoueurException(String message) {
    super(message);
  }

}
 