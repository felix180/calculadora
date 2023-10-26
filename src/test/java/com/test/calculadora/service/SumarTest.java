package com.test.calculadora.service;

import static org.junit.jupiter.api.Assertions.*;

import com.test.calculadora.request.OperacionEnum;import com.test.calculadora.request.ValueRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class SumarTest {

  private Operacion operacion = new Sumar();

  @Test
  void calcularSuma() {

    ValueRequest valueRequest =
        new ValueRequest(OperacionEnum.SUMAR,List.of(new BigDecimal("5.0"), new BigDecimal("10.0")));

    BigDecimal result = operacion.calcular(valueRequest);


    assertEquals(new BigDecimal("15.0"), result);
  }

  @Test
  void calcularZero() {

    ValueRequest valueRequest = new ValueRequest(OperacionEnum.SUMAR,new ArrayList<>());

    BigDecimal result = operacion.calcular(valueRequest);

    assertEquals(BigDecimal.ZERO, result);
  }

    @Test
  void calcularNullValue(){
      ValueRequest valueRequest = new ValueRequest(OperacionEnum.SUMAR,null);
      assertThrows(IllegalArgumentException.class, () -> operacion.calcular(valueRequest));
    }
}
