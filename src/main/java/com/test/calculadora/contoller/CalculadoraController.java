package com.test.calculadora.contoller;

import com.test.calculadora.request.OperacionList;
import com.test.calculadora.request.OperacionResult;
import com.test.calculadora.request.ValueRequest;
import com.test.calculadora.service.CalculadoraService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculadora")
@Tag(name = "CalculadoraController", description = "Metodos para operarar valores numericos")
public class CalculadoraController {

  @Autowired private CalculadoraService calculadoraService;

  @PostMapping
  @Operation(
      summary = "Calcula un resultado dependiendo del la operacion y los values",
      responses = {
        @ApiResponse(
            description = "Successful Operation",
            responseCode = "200",
            content =
                @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = OperacionResult.class))),
        @ApiResponse(
            responseCode = "400",
            description = "Bad Request",
            content = @Content(schema = @Schema(implementation = ProblemDetail.class)))
      })
  public ResponseEntity<OperacionResult> calcular(@RequestBody ValueRequest valueRequest) {
    return ResponseEntity.ok(this.calculadoraService.calcular(valueRequest));
  }

  @GetMapping(path = "/operaciones")
  @Operation(
      summary = "Devuelve la lista de operaciones",
      responses = {
        @ApiResponse(
            description = "Successful Operation",
            responseCode = "200",
            content =
                @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = OperacionList.class)))
      })
  public ResponseEntity<OperacionList> getOperaciones() {
    return ResponseEntity.ok(this.calculadoraService.getOperaciones());
  }
}
