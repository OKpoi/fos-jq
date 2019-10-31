package com.fos.exception;

import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GobalException {

  @ExceptionHandler(CustomerException.class)
  public ResponseEntity handlerException(HttpServletRequest request, final Exception e) {
    CustomerException customerException = (CustomerException) e;
    log.error(customerException.getMessage());
    return new ResponseEntity(customerException.getMessage(), HttpStatus.BAD_REQUEST);
  }
}
