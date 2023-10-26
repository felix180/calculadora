package com.test.calculadora.contoller;

import com.test.calculadora.request.OperacionResult;
import com.test.calculadora.request.ValueRequest;
import com.test.calculadora.service.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculadora")
public class CalculadoraController {

  @Autowired private CalculadoraService calculadoraService;

  @PostMapping
  public ResponseEntity<OperacionResult> calcular(@RequestBody ValueRequest valueRequest) {
    return ResponseEntity.ok(this.calculadoraService.calcular(valueRequest));
  }
}
