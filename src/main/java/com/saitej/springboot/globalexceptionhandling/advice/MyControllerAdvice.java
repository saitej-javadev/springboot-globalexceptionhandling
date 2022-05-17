package com.saitej.springboot.globalexceptionhandling.advice;


import com.saitej.springboot.globalexceptionhandling.exceptions.InputEmptyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.NoSuchElementException;

@ControllerAdvice
public class MyControllerAdvice  {

    @ExceptionHandler(InputEmptyException.class)
    public ResponseEntity<String> handleInputReq(InputEmptyException e){
     return  new ResponseEntity<String>("Input field is empty..Please check into it!!", HttpStatus.BAD_REQUEST);
    }



    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleInputId(NoSuchElementException e){
        return  new ResponseEntity<String>("No value present for the given id", HttpStatus.BAD_REQUEST);
    }



    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<String> handleNumberFormatException(NumberFormatException e){
        return  new ResponseEntity<String>("Error:"+e.getMessage()+" please provide valid id", HttpStatus.NOT_FOUND);
    }

   @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
   protected ResponseEntity<String> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex){
        return ResponseEntity.badRequest().body("Error: "+ex.getMessage()+"!!!!! Please change the method");
   }


}
