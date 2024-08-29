package org.example.input;

import org.example.type.Compass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

class CompassParserTest {

    CompassParser compassParser;

    @BeforeEach
    void setUp() {
        compassParser = new CompassParser();
    }

    @Test
    @DisplayName("Test valid position input of rover")
    void testValidPositionInputSouth() {

        var south = compassParser.compassInput("5 5 S");
        var west = compassParser.compassInput("5 5 W");
        var north = compassParser.compassInput("5 5 N");
        var east = compassParser.compassInput("5 5 E");

        assertAll(
                () ->  assertEquals(Compass.S, south.keySet().iterator().next()),
                () ->  assertEquals(Compass.W, west.keySet().iterator().next()),
                () ->  assertEquals(Compass.N, north.keySet().iterator().next()),
                () ->  assertEquals(Compass.E, east.keySet().iterator().next())
        );
    }

    @Test
    @DisplayName("Test invalid when either plateau coordinates are less than 2")
    void testInvalidPlateauCoordinatesThatAreLessThanTwo() {
        Throwable invalidX = assertThrows(IllegalArgumentException.class, () -> compassParser.compassInput("1 5 S"));
        Throwable invalidY = assertThrows(IllegalArgumentException.class, () -> compassParser.compassInput("5 1 S"));

        assertAll(
                () ->     assertNull(invalidX.getMessage()),
                () ->     assertNull(invalidY.getMessage())
        );
    }

    @Test
    @DisplayName("Test invalid plateau X and Y coordinates that are both less than 2")
    void testInvalidPlateauXAndYCoordinates() {
        Throwable result = assertThrows(IllegalArgumentException.class, () -> compassParser.compassInput("1 1 S"));
        assertNull(result.getMessage());
    }

    @Test
    @DisplayName("Test 1 or more inputs not inputted")
    void testOneOrMoreInputsNotInputted() {

        Throwable oneCoordinateNotInputted = assertThrows(NumberFormatException.class, () -> compassParser.compassInput("5 S"));
        Throwable bothCoordinatesNotInputted = assertThrows(NumberFormatException.class, () -> compassParser.compassInput("S"));
        Throwable allInputsNotInputted = assertThrows(NumberFormatException.class, () -> compassParser.compassInput(""));

        assertAll(
                () -> assertEquals("For input string: \"S\"", oneCoordinateNotInputted.getMessage()),
                () -> assertEquals("For input string: \"S\"", bothCoordinatesNotInputted.getMessage()),
                () -> assertEquals("For input string: \"\"", allInputsNotInputted.getMessage())
        );
    }

    @Test
    @DisplayName("Test invalid position inputted")
    void testInvalidPositionInputted() {

        Throwable result = assertThrows(InputMismatchException.class, () -> compassParser.compassInput("5 5 A"));
        assertNull(result.getMessage());
    }
}