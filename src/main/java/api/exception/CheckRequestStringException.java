package api.exception;

public class CheckRequestStringException extends RuntimeException {

    private String message;

    public CheckRequestStringException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
