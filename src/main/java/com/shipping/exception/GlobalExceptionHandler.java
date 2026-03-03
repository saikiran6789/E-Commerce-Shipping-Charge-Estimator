package com.shipping.exception;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
 @ExceptionHandler(RuntimeException.class)
 public ResponseEntity<?> handle(RuntimeException ex){
  return ResponseEntity.status(HttpStatus.BAD_REQUEST)
   .body(Map.of("error",ex.getMessage(),"status",400));
 }
}