package fil.rouge.exception;

public class NeedAPasswordToRegisterException extends Exception {
    public NeedAPasswordToRegisterException(String message){
        super(message);
    }
}