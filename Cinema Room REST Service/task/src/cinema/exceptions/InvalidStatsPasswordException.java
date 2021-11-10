package cinema.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InvalidStatsPasswordException extends RuntimeException {

    public InvalidStatsPasswordException(String message) {
        super(message);
    }

    public InvalidStatsPasswordException() {
    }
}
