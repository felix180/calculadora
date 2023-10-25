package com.test.calculadora.service;

import com.test.calculadora.request.ValueRequest;
import java.math.BigDecimal;

public class Restar implements Operacion {
  @Override
  public BigDecimal calcular(ValueRequest valueRequest) {

    try {
      return valueRequest.values().stream().reduce(BigDecimal.ZERO, BigDecimal::subtract);
    } catch (Exception exception) {
      throw new IllegalArgumentException("Error en restar valores: " + valueRequest, exception);
    }
  }
}
