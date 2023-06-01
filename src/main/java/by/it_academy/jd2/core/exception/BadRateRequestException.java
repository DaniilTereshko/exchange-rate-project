package by.it_academy.jd2.core.exception;

public class BadRateRequestException extends RuntimeException{
    public BadRateRequestException(String message) {
        super(message);
    }

    public BadRateRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
