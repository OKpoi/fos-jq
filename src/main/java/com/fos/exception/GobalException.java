package com.fos.exception;

import com.fos.util.LogHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.ExecutionException;

@RestControllerAdvice
public class GobalException {

  @ExceptionHandler(CustomerException.class)
  public ResponseEntity handlerCustomerException(HttpServletRequest request, final Exception e) {
    CustomerException customerException = (CustomerException) e;
    LogHelper.createServerExcpetionLog(
        customerException.getMessage(), request.getRequestURL().toString());
    return new ResponseEntity(customerException.getMessage(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler({ExecutionException.class, InterruptedException.class})
  public ResponseEntity handleServiceException(HttpServletRequest request, final Exception e) {
    LogHelper.createServerExcpetionLog(e.getMessage(), request.getRequestURI().toString());
    return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
