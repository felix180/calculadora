package com.test.calculadora.contoller;

import com.test.calculadora.request.ValueRequest;
import java.math.BigDecimal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculadora")
public class CalculadoraController {

  public enum Operacion {
    Sumar,
    Restar
  }

  @GetMapping
  public ResponseEntity<BigDecimal> calcular(
      @RequestParam("operacion") Operacion operacion, @RequestBody ValueRequest valueRequest) {
    return ResponseEntity.ok(BigDecimal.ZERO);
  }
}
