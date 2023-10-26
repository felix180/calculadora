package com.test.calculadora.service;

import com.test.calculadora.config.OperacionInit;
import com.test.calculadora.config.TracerLog;
import com.test.calculadora.request.OperacionList;
import com.test.calculadora.request.OperacionResult;
import com.test.calculadora.request.ValueRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraServiceImpl implements CalculadoraService {

  @Autowired private TracerLog tracer;

  @Autowired private OperacionInit operacionInit;

  @Override
  public OperacionResult calcular(ValueRequest valueRequest) {
    Operacion operacion = this.operacionInit.getOperacion(valueRequest.operacion());
    OperacionResult resultado = new OperacionResult(operacion.calcular(valueRequest));
    tracer.tracerLog(resultado);
    return resultado;
  }

  @Override
  public OperacionList getOperaciones() {
    return new OperacionList(this.operacionInit.listOperaciones());
  }
}
