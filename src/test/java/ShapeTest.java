import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ShapeTest {
  @ParameterizedTest
  @ValueSource(ints = { 3, 4, 5, 6, 8 })
  @DisplayName("Should create shape with specific side")
  void shouldCreateShapeWithSpecificSide(int sides) {
    Shape shape = new Shape(sides);
    assertEquals(sides, shape.getSides());
  }

  @ParameterizedTest
  @ValueSource(ints = { 0, 1, 2, Integer.MAX_VALUE })
  @DisplayName("Should not create shape with invalid side")
  void shouldNotCreateShapeWithInvalidSide(int sides) {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Shape(sides)
    );
  }
}