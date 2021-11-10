package cinema.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class NoSuchRoomException extends RuntimeException {

    public NoSuchRoomException(String message) {
        super(message);
    }

    public NoSuchRoomException() {
    }
}
