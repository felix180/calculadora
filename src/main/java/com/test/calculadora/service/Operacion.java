package com.test.calculadora.service;

import com.test.calculadora.request.ValueRequest;
import java.math.BigDecimal;

public interface Operacion {
  BigDecimal calcular(ValueRequest valueRequest);


}
