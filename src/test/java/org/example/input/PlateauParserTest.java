package org.example.input;

import org.example.type.PlateauSize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class PlateauParserTest {

    PlateauParser plateauParser;

    @BeforeEach
    void setUp() {
        plateauParser = new PlateauParser();
    }

    @Test
    @DisplayName("Test valid plateau coordinates that are more than 1")
    void testValidPlateauCoordinates() {
        var actual = plateauParser.plateauInput("5 5");

        HashMap<PlateauSize, Integer> expected = new HashMap<>();
        expected.put(PlateauSize.X, 5);
        expected.put(PlateauSize.Y, 5);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test invalid when either plateau coordinates are less than 2")
    void testInvalidPlateauCoordinatesThatAreLessThanTwo() {
        Throwable invalidX = assertThrows(IllegalArgumentException.class, () -> plateauParser.plateauInput("1 5"));
        Throwable invalidY = assertThrows(IllegalArgumentException.class, () -> plateauParser.plateauInput("5 1"));

        assertAll(
                () ->     assertNull(invalidX.getMessage()),
                () ->     assertNull(invalidY.getMessage())
        );
    }

    @Test
    @DisplayName("Test invalid plateau X and Y coordinates that are both less than 2")
    void testInvalidPlateauXAndYCoordinates() {
        Throwable result = assertThrows(IllegalArgumentException.class, () -> plateauParser.plateauInput("1 1"));
        assertNull(result.getMessage());
    }

    @Test
    @DisplayName("Test 1 plateau coordinate inputted")
    void testOnePlateauCoordinateInputted() {

        Throwable result = assertThrows(ArrayIndexOutOfBoundsException.class, () -> plateauParser.plateauInput("5"));
        assertEquals("Index 1 out of bounds for length 1", result.getMessage());
    }

    @Test
    @DisplayName("Test no plateau X coordinate input")
    void testNoPlateauCoordinatesInputted() {

        Throwable result = assertThrows(NumberFormatException.class, () -> plateauParser.plateauInput(""));
        assertEquals("For input string: \"\"", result.getMessage());
    }


}