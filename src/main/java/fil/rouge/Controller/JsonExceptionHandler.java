package fil.rouge.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


import fil.rouge.Exceptions.ErrorResponse;
import fil.rouge.exception.WrongToolException;

@ControllerAdvice
public class JsonExceptionHandler{
    @ExceptionHandler(WrongToolException.class)   
    @ResponseBody
  public ResponseEntity<Object> handleWrongToolExceptions(WrongToolException ex){
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorResponse(ex.getMessage()));
   }
}
