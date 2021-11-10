package cinema.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class SeatExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidPurchaseException.class)
    public final ResponseEntity<Map<String, Object>> handleInvalidPurchaseException(InvalidPurchaseException ex,
                                                                                    WebRequest request) {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("error", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }

    @ExceptionHandler(InvalidStatsPasswordException.class)
    public final ResponseEntity<Map<String, Object>> handleInvalidStatsPasswordException(InvalidStatsPasswordException ex,
                                                                                    WebRequest request) {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("error", ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
    }
}
