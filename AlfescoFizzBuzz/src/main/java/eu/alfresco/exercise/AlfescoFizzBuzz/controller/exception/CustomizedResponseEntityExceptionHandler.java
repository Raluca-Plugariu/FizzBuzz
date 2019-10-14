package eu.alfresco.exercise.AlfescoFizzBuzz.controller.exception;

import eu.alfresco.exercise.AlfescoFizzBuzz.controller.dto.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
  @ExceptionHandler(InvalidRangeException.class)
  public final ResponseEntity<Object> handleAllExceptions(Exception ex) {
    ErrorDetails errorDetails = new ErrorDetails(new Date(), "Server cannot process your request.",
            ex.getMessage());
    return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
  }

}