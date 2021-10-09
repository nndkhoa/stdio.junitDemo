package com.onemount.tests;

import com.onemount.tests.complex.NumberFactoryTest;
import com.onemount.tests.simple.CalculatorTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ CalculatorTest.class, NumberFactoryTest.class })
public class CustomSuite {
}
