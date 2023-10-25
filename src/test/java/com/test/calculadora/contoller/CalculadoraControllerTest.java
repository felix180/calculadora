package com.test.calculadora.contoller;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.test.calculadora.request.OperacionEnum;
import com.test.calculadora.request.ValueRequest;
import com.test.calculadora.service.CalculadoraService;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(CalculadoraController.class)
class CalculadoraControllerTest {

  @Autowired private MockMvc mvc;

  @MockBean private CalculadoraService calculadoraService;

  @Test
  void calcularSinOperadorError() throws Exception {

    this.mvc
        .perform(get("/api/calculadora").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest());
  }

  @Test
  void calcularSumarOk() throws Exception {

    ValueRequest valueRequest = new ValueRequest(List.of(BigDecimal.ONE, BigDecimal.ONE));
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
    ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
    String requestJson = ow.writeValueAsString(valueRequest);

    Mockito.when(calculadoraService.calcular(OperacionEnum.SUMAR, valueRequest))
            .thenReturn(BigDecimal.ZERO);

    this.mvc
        .perform(
            get("/api/calculadora?operacion=Sumar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", is(0)));
  }
}
