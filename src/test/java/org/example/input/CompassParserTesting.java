package org.example.input;

import org.example.logic.Position;
import org.example.type.Compass;
import org.junit.jupiter.api.*;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class CompassParserTest {

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @AfterEach
    void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @Test
    @DisplayName("Test valid position input of rover facing North")
    void testValidPositionInputNorth() {
        provideInput("1 2 N\n");
        CompassParser parser = new CompassParser(new Scanner(System.in));
        HashMap<Compass, Position> result = parser.compassInput();

        Position expectedPosition = new Position(1, 2, Compass.N);

        assertAll(
                () -> assertEquals(expectedPosition.getX(), result.get(Compass.N).getX()),
                () -> assertEquals(expectedPosition.getY(), result.get(Compass.N).getY()),
                () -> assertEquals(expectedPosition.getFacing(), result.get(Compass.N).getFacing())
        );

    }

    @Test
    @DisplayName("Test valid position input of rover facing South")
    void testValidPositionInputSouth() {

        provideInput("1 2 S\n");
        CompassParser parser = new CompassParser(new Scanner(System.in));
        HashMap<Compass, Position> result = parser.compassInput();

        Position expectedPosition = new Position(1, 2, Compass.S);

        assertAll(
                () -> assertEquals(expectedPosition.getX(), result.get(Compass.S).getX()),
                () -> assertEquals(expectedPosition.getY(), result.get(Compass.S).getY()),
                () -> assertEquals(expectedPosition.getFacing(), result.get(Compass.S).getFacing())
        );
    }

    @Test
    @DisplayName("Test valid position input of rover facing East")
    void testValidPositionInputEast() {

        provideInput("1 2 E\n");
        CompassParser parser = new CompassParser(new Scanner(System.in));
        HashMap<Compass, Position> result = parser.compassInput();

        Position expectedPosition = new Position(1, 2, Compass.E);

        assertAll(
                () -> assertEquals(expectedPosition.getX(), result.get(Compass.E).getX()),
                () -> assertEquals(expectedPosition.getY(), result.get(Compass.E).getY()),
                () -> assertEquals(expectedPosition.getFacing(), result.get(Compass.E).getFacing())
        );
    }

    @Test
    @DisplayName("Test valid position input of rover facing West")
    void testValidPositionInputWest() {

        provideInput("1 2 W\n");
        CompassParser parser = new CompassParser(new Scanner(System.in));
        HashMap<Compass, Position> result = parser.compassInput();

        Position expectedPosition = new Position(1, 2, Compass.W);

        assertAll(
                () -> assertEquals(expectedPosition.getX(), result.get(Compass.W).getX()),
                () -> assertEquals(expectedPosition.getY(), result.get(Compass.W).getY()),
                () -> assertEquals(expectedPosition.getFacing(), result.get(Compass.W).getFacing())
        );
    }

    @Test
    @DisplayName("Test valid position input of rover facing West with invalid x-coordinate input")
    void testValidPositionInputAndInvalidInputOfXCoordinateInput() {

        provideInput("Invalid\n1 2 W\n");
        CompassParser parser = new CompassParser(new Scanner(System.in));
        HashMap<Compass, Position> result = parser.compassInput();

        Position expectedPosition = new Position(1, 2, Compass.W);

        String output = testOut.toString();

        assertAll(
                () -> assertEquals(expectedPosition.getX(), result.get(Compass.W).getX()),
                () -> assertEquals(expectedPosition.getY(), result.get(Compass.W).getY()),
                () -> assertEquals(expectedPosition.getFacing(), result.get(Compass.W).getFacing()),
                () -> assertTrue(output.contains("Incorrect Compass Coordinates Houston!! Please Try Again."))
        );
    }

    @Test
    @DisplayName("Test valid position input of rover facing West without an x-coordinate input")
    void testValidPositionInputAndNoXCoordinateInput() {

        provideInput("\n 2 W\n");
        CompassParser parser = new CompassParser(new Scanner(System.in));
        HashMap<Compass, Position> result = parser.compassInput();

        String output = testOut.toString();

        assertAll(
                () -> assertNull(result.get(Compass.W)),
                () -> assertTrue(output.contains("No Input Provided. Please Enter Two Integers (X and Y Coordinates) and Direction."))
        );
    }

}