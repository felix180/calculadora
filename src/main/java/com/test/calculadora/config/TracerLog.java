package com.test.calculadora.config;

import io.corp.calculator.TracerImpl;
import org.springframework.stereotype.Component;

@Component
public class TracerLog {
  private TracerImpl tracer;

  public <T> void tracerLog(final T object) {
    if (tracer != null) {
      tracer.trace(object);

    } else {
      tracer = new TracerImpl();
        tracer.trace(object);
    }
  }
}
