package com.onemount.tests.simple;

import com.onemount.SimpleApp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleAppTest {

  @Test
  void shouldShowHelloJUnit5() {
    String actual = SimpleApp.sayHello();
    String expected = "hello junit 5";
    Assertions.assertEquals(expected, actual);
  }
}
