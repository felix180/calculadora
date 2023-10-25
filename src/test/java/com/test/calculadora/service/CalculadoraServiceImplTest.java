package com.test.calculadora.service;

import static org.junit.jupiter.api.Assertions.*;

import com.test.calculadora.request.OperacionEnum;import com.test.calculadora.request.ValueRequest;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CalculadoraServiceImplTest {

  @Autowired CalculadoraService calculadoraService;

  @Test
  void calcular_DebeSumar() {
    ValueRequest valueRequest =
        new ValueRequest(List.of(new BigDecimal("4.0"), new BigDecimal("2.0")));
    BigDecimal result = calculadoraService.calcular(OperacionEnum.SUMAR,valueRequest);
    assertEquals(new BigDecimal("6.0"), result);

  }

  @Test
  void calcular_DebeRestar() {
    ValueRequest valueRequest =
            new ValueRequest(List.of(new BigDecimal("-4.0"), new BigDecimal("2.0")));
    BigDecimal result = calculadoraService.calcular(OperacionEnum.RESTAR, valueRequest);
    assertEquals(new BigDecimal("2.0"), result);

  }


}
