package com.test.calculadora.service;

import static org.junit.jupiter.api.Assertions.*;

import com.test.calculadora.config.OperacionInit;import com.test.calculadora.config.TracerLog;
import com.test.calculadora.request.OperacionList;import com.test.calculadora.request.ValueRequest;
import java.math.BigDecimal;
import java.util.List;
import org.assertj.core.util.Sets;import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CalculadoraServiceImplTest {
  @Mock private TracerLog tracerLog;

  @Mock private OperacionInit operacionInit;
  @InjectMocks private CalculadoraServiceImpl calculadoraService;

  @Test
  void calcular_DebeSumar() {
    ValueRequest valueRequest =
        new ValueRequest(
            "SUMAR", List.of(new BigDecimal("4.0"), new BigDecimal("2.0")));
    Mockito.when(operacionInit.getOperacion("SUMAR")).thenReturn(new Sumar());

    BigDecimal result = calculadoraService.calcular(valueRequest).result();
    assertEquals(new BigDecimal("6.0"), result);
  }

  @Test
  void calcular_DebeRestar() {
    ValueRequest valueRequest =
        new ValueRequest(
            "RESTAR", List.of(new BigDecimal("-4.0"), new BigDecimal("2.0")));
    Mockito.when(operacionInit.getOperacion("RESTAR")).thenReturn(new Restar());

    BigDecimal result = calculadoraService.calcular(valueRequest).result();
    assertEquals(new BigDecimal("-6.0"), result);
  }

  @Test
  void getOperacionesOk(){

    Mockito.when(this.operacionInit.listOperaciones()).thenReturn(Sets.set("SUMAR","RESTAR"));
    OperacionList result = this.calculadoraService.getOperaciones();
    assertEquals(2,result.operaciones().size());

  }
}
