package com.test.calculadora.service;

import com.test.calculadora.config.TracerLog;
import com.test.calculadora.request.OperacionEnum;
import com.test.calculadora.request.OperacionResult;
import com.test.calculadora.request.ValueRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraServiceImpl implements CalculadoraService {

  @Autowired private TracerLog tracer;

  @Override
  public OperacionResult calcular(ValueRequest valueRequest) {
    Operacion operacion = getOperacion(valueRequest.operacion());
    OperacionResult resultado = new OperacionResult (operacion.calcular(valueRequest));
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
