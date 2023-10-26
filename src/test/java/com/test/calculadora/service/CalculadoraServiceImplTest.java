package com.test.calculadora.service;

import static org.junit.jupiter.api.Assertions.*;

import com.test.calculadora.config.TracerLog;
import com.test.calculadora.request.OperacionEnum;
import com.test.calculadora.request.ValueRequest;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CalculadoraServiceImplTest {
  @Mock private TracerLog tracerLog;
  @InjectMocks private CalculadoraServiceImpl calculadoraService;

  @Test
  void calcular_DebeSumar() {
    ValueRequest valueRequest =
        new ValueRequest(
            OperacionEnum.SUMAR, List.of(new BigDecimal("4.0"), new BigDecimal("2.0")));
    BigDecimal result = calculadoraService.calcular(valueRequest).result();
    assertEquals(new BigDecimal("6.0"), result);
  }

  @Test
  void calcular_DebeRestar() {
    ValueRequest valueRequest =
        new ValueRequest(
            OperacionEnum.RESTAR, List.of(new BigDecimal("-4.0"), new BigDecimal("2.0")));
    BigDecimal result = calculadoraService.calcular(valueRequest).result();
    assertEquals(new BigDecimal("2.0"), result);
  }
}
