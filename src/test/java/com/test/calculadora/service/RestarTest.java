package com.test.calculadora.service;

import static org.junit.jupiter.api.Assertions.*;

import com.test.calculadora.request.ValueRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class RestarTest {
  private Operacion operacionRestar = new Restar();

  @Test
  void calcularResta() {

    ValueRequest valueRequest =
        new ValueRequest("RESTAR",List.of(new BigDecimal("5.0"), new BigDecimal("10.0")));

    BigDecimal result = operacionRestar.calcular(valueRequest);

    assertEquals(new BigDecimal("-5.0"), result);
  }

  @Test
  void calcularRestaNegativo() {

    ValueRequest valueRequest =
            new ValueRequest("RESTAR",List.of(new BigDecimal("-1.0"), new BigDecimal("2.0"), new BigDecimal("3.0")));

    BigDecimal result = operacionRestar.calcular(valueRequest);

    assertEquals(new BigDecimal("-6.0"), result);
  }

  @Test
  void calcularZeroResta() {

    ValueRequest valueRequest = new ValueRequest("RESTAR",new ArrayList<>());

    BigDecimal result = operacionRestar.calcular(valueRequest);

    assertEquals(BigDecimal.ZERO, result);
  }

  @Test
  void calcularNullValueResta() {
    ValueRequest valueRequest = new ValueRequest(null,null
    );
    assertThrows(IllegalArgumentException.class, () -> operacionRestar.calcular(valueRequest));
  }
}
