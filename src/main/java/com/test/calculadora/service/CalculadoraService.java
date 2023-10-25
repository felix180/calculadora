package com.test.calculadora.service;

import com.test.calculadora.request.OperacionEnum;
import com.test.calculadora.request.ValueRequest;
import java.math.BigDecimal;

public interface CalculadoraService {
  BigDecimal calcular(OperacionEnum operacionEnum, ValueRequest valueRequest);
}
