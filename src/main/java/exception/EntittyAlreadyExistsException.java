package exception;

public class EntittyAlreadyExistsException extends RuntimeException {
    public EntittyAlreadyExistsException(String message) {
        super(message);
    }
}
