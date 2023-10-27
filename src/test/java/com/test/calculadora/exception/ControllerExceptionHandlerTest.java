package com.test.calculadora.exception;

import static org.junit.jupiter.api.Assertions.*;

import com.test.calculadora.config.TracerLog;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.ErrorResponse;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;

@ExtendWith(MockitoExtension.class)
class ControllerExceptionHandlerTest {

  @InjectMocks private ControllerExceptionHandler controllerExceptionHandler;

  @Mock private TracerLog tracerLog;

  @Test
  void illegalArgumentException() {
    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Test");

    ErrorResponse errorResponse =
        controllerExceptionHandler.illegalArgumentException(illegalArgumentException, null);

    assertEquals(HttpStatus.BAD_REQUEST, errorResponse.getStatusCode());
    assertEquals("Test", errorResponse.getBody().getDetail());
  }

  @Test
  void handleHttpMediaTypeNotSupported() {
    HttpMediaTypeNotSupportedException error = new HttpMediaTypeNotSupportedException("Test");

    ProblemDetail errorResponse =
        (ProblemDetail)
            controllerExceptionHandler
                .handleHttpMediaTypeNotSupported(error, null, null, null)
                .getBody();

    assertEquals(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(), errorResponse.getStatus());
    assertEquals("Test", errorResponse.getDetail());
  }

  @Test
  void handleHttpMessageNotReadable() {
    HttpMessageNotReadableException error = new HttpMessageNotReadableException("Test",new Throwable(),null);

    ProblemDetail errorResponse =
        (ProblemDetail)
            controllerExceptionHandler
                .handleHttpMessageNotReadable(error, null, null, null)
                .getBody();

    assertEquals(HttpStatus.BAD_REQUEST.value(), errorResponse.getStatus());
    assertEquals("Test", errorResponse.getDetail());
  }

  @Test
  void handleHttpRequestMethodNotSupported() {
    HttpRequestMethodNotSupportedException error =
        new HttpRequestMethodNotSupportedException("Test");

    ResponseEntity<Object> errorResponse =
        controllerExceptionHandler.handleHttpRequestMethodNotSupported(error, null, null, null);

    assertEquals(HttpStatus.NOT_FOUND, errorResponse.getStatusCode());
  }

  @Test
  void exception() {
    Exception exception = new Exception("Test");

    ErrorResponse errorResponse = controllerExceptionHandler.exception(exception, null);

    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, errorResponse.getStatusCode());
    assertEquals("Test", errorResponse.getBody().getDetail());
  }
}
