package com.fos.exception;

import com.fos.util.LoggerHelper;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GobalException {

  @ExceptionHandler(CustomerException.class)
  public ResponseEntity handlerCustomerException(HttpServletRequest request, final Exception e) {
    CustomerException customerException = (CustomerException) e;
    LoggerHelper.createServerExcpetionLog(
        customerException.getMessage(), request.getRequestURL().toString());
    return new ResponseEntity(customerException.getMessage(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity handleServiceException(HttpServletRequest request, final Exception e) {
    LoggerHelper.createServerExcpetionLog(e.getMessage(), request.getRequestURI());
    return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
