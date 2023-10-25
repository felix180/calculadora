package com.test.calculadora.service;

import com.test.calculadora.config.TracerLog;
import com.test.calculadora.request.OperacionEnum;
import com.test.calculadora.request.ValueRequest;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraServiceImpl implements CalculadoraService {

  @Autowired private TracerLog tracer;

  @Override
  public BigDecimal calcular(OperacionEnum operacionEnum, ValueRequest valueRequest) {
    Operacion operacion = getOperacion(operacionEnum);
    BigDecimal resultado = operacion.calcular(valueRequest);
    tracer.tracerLog(resultado);
    return resultado;
  }

  private Operacion getOperacion(OperacionEnum operacionEnum) {
    Operacion result = null;
    if (operacionEnum == OperacionEnum.SUMAR) {
      result = new Sumar();
    } else if (operacionEnum == OperacionEnum.RESTAR) {
      result = new Restar();
    } else {
      throw new IllegalArgumentException("Error al crear operacion");
    }
    return result;
  }
}
