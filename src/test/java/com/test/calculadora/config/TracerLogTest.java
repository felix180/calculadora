package com.test.calculadora.config;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TracerLogTest {
  private TracerLog tracerLog = new TracerLog();

  @Test
  void tracerLog() {
    assertDoesNotThrow(() -> tracerLog.tracerLog("TEST"));
  }
}
