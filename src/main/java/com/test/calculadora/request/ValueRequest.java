package com.test.calculadora.request;

import java.math.BigDecimal;
import java.util.List;

public record ValueRequest(List<BigDecimal> values) {

}