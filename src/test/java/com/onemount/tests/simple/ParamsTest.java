package com.onemount.tests.simple;

import com.onemount.Params;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.time.Month;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class ParamsTest {
  @ParameterizedTest
  @ValueSource(strings = { "", "     " })
  @DisplayName("Should return true for null or blank string")
  void shouldReturnTrueForNullOrBlankString(String input) {
    assertTrue(Params.isBlank(input));
  }

  @ParameterizedTest
  @MethodSource("provideStrings")
  @DisplayName("ShouldReturnTrueOrFalseBasedOnParameters")
  void shouldReturnTrueOrFalseBasedOnParameters(String input, boolean expected) {
    boolean actual = Params.isBlank(input);
    assertEquals(expected, actual);
  }

  private static Stream<Arguments> provideStrings() {
    return Stream.of(
      Arguments.of(null, true),
      Arguments.of("", true),
      Arguments.of("     ", true),
      Arguments.of("null", false)
    );
  }

  @ParameterizedTest
  @NullAndEmptySource
  @DisplayName("Should return true for null input")
  void shouldReturnTrueForNull(String input) {
    assertTrue(Params.isBlank(input));
  }

  @ParameterizedTest
  @EnumSource(
    value = Month.class,
    names = ".+BER",
    mode = EnumSource.Mode.MATCH_ANY)
  // @EnumSource(
  //   value = Month.class,
  //   names = { "APRIL", "JUNE" },
  //   mode = EnumSource.Mode.EXCLUDE)
  @DisplayName("Should always between 1 and 12")
  void shouldBetween1And12(Month month) {
    int value = month.getValue();
    assertTrue(value >= 1 && value <= 12);
  }

  @ParameterizedTest
  // @CsvSource({ "test,TEST", "tEst,TEST", "Java,JAVA" })
  @CsvSource(value = { "test:TEST", "tEst:TEST", "Java:JAVA" }, delimiter = ':')
  @DisplayName("Should generate expected uppercase value")
  void shouldGenerateExpectedUppercaseValue(String input, String expected) {
    String actual = input.toUpperCase();
    assertEquals(expected, actual);
  }
}
