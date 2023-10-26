package com.test.calculadora.service;

import com.test.calculadora.request.OperacionResult;
import com.test.calculadora.request.ValueRequest;

public interface CalculadoraService {
  OperacionResult calcular(ValueRequest valueRequest);
}
