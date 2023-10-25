package com.test.calculadora.contoller;

import com.test.calculadora.request.OperacionEnum;
import com.test.calculadora.request.ValueRequest;
import com.test.calculadora.service.CalculadoraService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculadora")
public class CalculadoraController {

  @Autowired private CalculadoraService calculadoraService;



  @GetMapping
  public ResponseEntity<BigDecimal> calcular(
      @RequestParam("operacion") OperacionEnum operacionEnum, @RequestBody ValueRequest valueRequest) {
    return ResponseEntity.ok(this.calculadoraService.calcular(operacionEnum,valueRequest));
  }
}
