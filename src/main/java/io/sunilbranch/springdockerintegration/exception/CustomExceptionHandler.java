package io.sunilbranch.springdockerintegration.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest webRequest) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());

        ErrorResponse server_error = new ErrorResponse("Server Error", details);

        return new ResponseEntity<Object>(server_error, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(PlayerNotFoundException.class)
    public final ResponseEntity<Object> handleRecordNotFoundException(PlayerNotFoundException playerNotFoundException, WebRequest webRequest) {

        List<String> details = new ArrayList<>();
        details.add(playerNotFoundException.getLocalizedMessage());
        details.add("status-code : " + HttpStatus.NOT_FOUND);

        ErrorResponse player_not_found = new ErrorResponse("Player with specified ID not found", details);

        return new ResponseEntity<Object>(player_not_found, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = new ArrayList<>();
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        for (FieldError fieldError : fieldErrors) {
            errors.add("objectName : " + fieldError.getObjectName());
            errors.add("fieldName : " + fieldError.getField());
            errors.add("defaultMessage : " + fieldError.getDefaultMessage());
            errors.add("rejectedValue : " + fieldError.getRejectedValue());
        }

        ErrorResponse validation_failed = new ErrorResponse("Validation Failed", errors);

        return new ResponseEntity<Object>(validation_failed, HttpStatus.BAD_REQUEST);
    }


}
