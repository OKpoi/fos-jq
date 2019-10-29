package com.fos.exception;

import com.fos.util.RestHelper;
import com.fos.vo.RestVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestControllerAdvice
public class GobalException {

  @ExceptionHandler(MovieTypeException.class)
  public RestVO handlerException(
      HttpServletRequest request, final Exception e, HttpServletResponse response) {
    MovieTypeException movieTypeException = (MovieTypeException) e;
    log.info(movieTypeException.getMessage());
    return RestHelper.fail(movieTypeException.getCode(), movieTypeException.getMessage());
  }
}
