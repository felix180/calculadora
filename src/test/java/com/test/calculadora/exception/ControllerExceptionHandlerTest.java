package com.test.calculadora.exception;

import static org.junit.jupiter.api.Assertions.*;

import com.test.calculadora.config.TracerLog;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;

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
}
