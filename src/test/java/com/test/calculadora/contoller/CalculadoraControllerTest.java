package com.test.calculadora.contoller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.test.calculadora.exception.ControllerExceptionHandler;
import com.test.calculadora.request.OperacionEnum;
import com.test.calculadora.request.OperacionResult;
import com.test.calculadora.request.ValueRequest;
import com.test.calculadora.service.CalculadoraService;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class CalculadoraControllerTest {
  @InjectMocks private CalculadoraController calculadoraController;
  @Mock private CalculadoraService calculadoraService;

  @Mock private ControllerExceptionHandler controllerExceptionHandler;

  @Test
  void calcularSumarOk()  {

    ValueRequest valueRequest =
        new ValueRequest(OperacionEnum.SUMAR, List.of(BigDecimal.ONE, BigDecimal.ONE));

    Mockito.when(calculadoraService.calcular(valueRequest))
        .thenReturn(new OperacionResult(BigDecimal.ZERO));
    ResponseEntity<OperacionResult> result = calculadoraController.calcular(valueRequest);
    assertEquals(BigDecimal.ZERO, result.getBody().result());
    assertEquals(HttpStatus.OK, result.getStatusCode());
  }
}
