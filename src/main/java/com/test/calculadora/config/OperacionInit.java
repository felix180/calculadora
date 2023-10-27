package com.test.calculadora.config;

import com.test.calculadora.service.Operacion;
import jakarta.annotation.PostConstruct;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OperacionInit {
  private final Map<String, Operacion> operacionMap;

  Logger logger = LoggerFactory.getLogger(OperacionInit.class);

  @Autowired
  public OperacionInit(Map<String, Operacion> operacionMap) {
    this.operacionMap = operacionMap;
  }

  @PostConstruct
  public void logOperaciones() {
    operacionMap.forEach(
            (id, storageService) -> logger.info(id + ": " + storageService.getClass().getSimpleName()));
  }

  public Operacion getOperacion(String operacion) {
    if (this.operacionMap.containsKey(operacion)) {
      return this.operacionMap.get(operacion);
    } else {
      throw new IllegalArgumentException("Error al crear operacion");
    }
  }

  public Set<String> listOperaciones() {
    return this.operacionMap.keySet();
  }
}
