package ua.lviv.iot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {NoDataFoundException.class})
    public ResponseEntity<Object> handleNoDataFoundException(NoDataFoundException e) {
        // Create payload containing exception details
        HttpStatus notFound = HttpStatus.NOT_FOUND;

        ApiException apiException = new ApiException(
                e.getMessage(),
                notFound,
                ZonedDateTime.now()
        );

        // Return response entity
        return new ResponseEntity<>(apiException, notFound);
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException e) {
        // Create payload containing exception details
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        StringBuilder errors = new StringBuilder();
        e.getBindingResult().getAllErrors().forEach(error ->
                errors
                        .append("'")
                        .append(((FieldError) error).getField())
                        .append("': '")
                        .append(error.getDefaultMessage())
                        .append("';  ")
        );

        ApiException apiException = new ApiException(
                errors.toString(),
                badRequest,
                ZonedDateTime.now()
        );

        // Return response entity
        return new ResponseEntity<>(apiException, badRequest);
    }
}
