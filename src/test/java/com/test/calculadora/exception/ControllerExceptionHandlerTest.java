package com.test.calculadora.exception;

import static org.junit.jupiter.api.Assertions.*;

import com.test.calculadora.config.TracerLog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;

@SpringBootTest
class ControllerExceptionHandlerTest {

  @Autowired private ControllerExceptionHandler controllerExceptionHandler;

  @MockBean private TracerLog tracerLog;

  @Test
  void illegalArgumentException() {
    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Test");

    ErrorResponse errorResponse =
        controllerExceptionHandler.illegalArgumentException(illegalArgumentException, null);

    assertEquals(HttpStatus.BAD_REQUEST, errorResponse.getStatusCode());
    assertEquals("Test", errorResponse.getBody().getDetail());
  }
}
