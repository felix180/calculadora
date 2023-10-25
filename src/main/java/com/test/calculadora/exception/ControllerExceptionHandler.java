package com.test.calculadora.exception;

import com.test.calculadora.config.TracerLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ControllerExceptionHandler {

  @Autowired private TracerLog tracer;

  @ExceptionHandler(value = {IllegalArgumentException.class})
  public ErrorResponse illegalArgumentException(IllegalArgumentException ex, WebRequest request) {
    ErrorResponse message = ErrorResponse.create(ex, HttpStatus.BAD_REQUEST, ex.getMessage());
    tracer.tracerLog(message);
    return message;
  }
}
