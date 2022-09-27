package fil.rouge.exception;

public class MailAlreadyUsedException extends Exception {
    public MailAlreadyUsedException(String message){
        super(message);
    }
}
