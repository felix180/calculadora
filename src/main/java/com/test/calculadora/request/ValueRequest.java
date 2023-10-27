package com.test.calculadora.request;

import java.math.BigDecimal;
import java.util.List;

public record ValueRequest(String operacion, List<BigDecimal> values) {}
