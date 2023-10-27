package com.test.calculadora.exception;

import com.test.calculadora.config.TracerLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.ErrorResponse;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
  @Autowired private TracerLog tracer;

  @ExceptionHandler(value = {IllegalArgumentException.class})
  public ErrorResponse illegalArgumentException(IllegalArgumentException ex, WebRequest request) {
    ErrorResponse message = ErrorResponse.create(ex, HttpStatus.BAD_REQUEST, ex.getMessage());
    tracer.tracerLog(message);
    return message;
  }

  @Override
  protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(
      HttpMediaTypeNotSupportedException ex,
      HttpHeaders headers,
      HttpStatusCode status,
      WebRequest request) {
    ErrorResponse message =
        ErrorResponse.create(ex, HttpStatus.UNSUPPORTED_MEDIA_TYPE, ex.getMessage());
    tracer.tracerLog(message);
    return new ResponseEntity<>(message.getBody(), new HttpHeaders(), message.getStatusCode());
  }

  @Override
  protected ResponseEntity<Object> handleHttpMessageNotReadable(
      HttpMessageNotReadableException ex,
      HttpHeaders headers,
      HttpStatusCode status,
      WebRequest request) {

    ErrorResponse message = ErrorResponse.create(ex, HttpStatus.BAD_REQUEST, ex.getMessage());
    tracer.tracerLog(message);
    return new ResponseEntity<>(message.getBody(), new HttpHeaders(), message.getStatusCode());
  }

  @Override
  protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
      HttpRequestMethodNotSupportedException ex,
      HttpHeaders headers,
      HttpStatusCode status,
      WebRequest request) {
    ErrorResponse message = ErrorResponse.create(ex, HttpStatus.NOT_FOUND, ex.getMessage());
    tracer.tracerLog(message);
    return new ResponseEntity<>(message.getBody(), new HttpHeaders(), message.getStatusCode());
  }

  @ExceptionHandler(value = {Exception.class})
  public ErrorResponse exception(Exception ex, WebRequest request) {
    ErrorResponse message =
        ErrorResponse.create(ex, HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    tracer.tracerLog(message);
    return message;
  }
}
