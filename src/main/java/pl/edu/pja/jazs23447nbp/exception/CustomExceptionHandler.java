package pl.edu.pja.jazs23447nbp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException(NullPointerException ex) {
        String resBody = "Exception occurred on request. Exception message \"" + ex.getMessage() +"\"";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resBody);
    }
}
