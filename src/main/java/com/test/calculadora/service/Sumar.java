package com.test.calculadora.service;

import com.test.calculadora.request.ValueRequest;
import java.math.BigDecimal;
import java.util.Objects;

public class Sumar implements Operacion {
  @Override
  public BigDecimal calcular(ValueRequest valueRequest) {
    if (Objects.nonNull(valueRequest) && Objects.nonNull(valueRequest.values())) {
      return valueRequest.values().stream().reduce(BigDecimal.ZERO, BigDecimal::add);
    } else {
      throw new IllegalArgumentException();
    }
  }
}
