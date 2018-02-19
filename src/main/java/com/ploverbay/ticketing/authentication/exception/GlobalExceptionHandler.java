package com.ploverbay.ticketing.authentication.exception;

import java.util.Date;

import com.ploverbay.ticketing.authentication.model.ExceptionMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/**
 * Describe this class
 *
 * @author Keno San Pedro
 *
 */

@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionMessage> handleAllExceptions(Exception ex, WebRequest request) {
        ExceptionMessage exceptionMessage = new ExceptionMessage(new Date(), ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(exceptionMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}