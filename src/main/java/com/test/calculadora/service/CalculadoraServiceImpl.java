package com.test.calculadora.service;

import com.test.calculadora.request.OperacionEnum;
import com.test.calculadora.request.ValueRequest;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class CalculadoraServiceImpl implements CalculadoraService {

  @Override
  public BigDecimal calcular(OperacionEnum operacionEnum, ValueRequest valueRequest) {
    Operacion operacion = getOperacion(operacionEnum);
    return operacion.calcular(valueRequest) ;
  }

  private Operacion getOperacion(OperacionEnum operacionEnum){
    Operacion result = null;
    if (operacionEnum == OperacionEnum.SUMAR) {
      result = new Sumar();
    } else if (operacionEnum == OperacionEnum.RESTAR) {
      result = new Restar();
    } else {
      throw new IllegalArgumentException();
    }
  return result;
  }
}
