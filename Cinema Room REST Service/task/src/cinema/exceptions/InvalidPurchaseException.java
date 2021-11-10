package cinema.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class InvalidPurchaseException extends RuntimeException {

    public InvalidPurchaseException() {
    }

    public InvalidPurchaseException(String message) {
        super(message);
    }
}
