package com.test.calculadora.config;

import static org.junit.jupiter.api.Assertions.*;

import com.test.calculadora.service.Operacion;
import com.test.calculadora.service.Sumar;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OperacionInitTest {
  private OperacionInit operacionInit;
  private Sumar sumar;

  @BeforeEach
  void setUp() {

    Map<String, Operacion> operacionMap = new HashMap<>();
    this.sumar = new Sumar();
    operacionMap.put("SUMAR", sumar);
    this.operacionInit = new OperacionInit(operacionMap);
  }

  @Test
  void getOperacionOk() {

    Operacion result = this.operacionInit.getOperacion("SUMAR");
    assertNotNull(result);
    assertEquals(sumar, result);
  }

  @Test
  void getOperacion_Error() {
    assertThrows(IllegalArgumentException.class, () -> operacionInit.getOperacion("RESTAR"));
  }
}
