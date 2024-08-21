package org.example.input;

import org.example.PlateauSize;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class PlateauParserTest {

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
    @DisplayName("Test valid plateau coordinates that are more than 1")
    void testValidPlateauCoordinates() {
        provideInput("5 5\n");
        PlateauParser parser = new PlateauParser(new Scanner(System.in));
        HashMap<PlateauSize, Integer> result = parser.plateauInput();

        HashMap<PlateauSize, Integer> expected = new HashMap<>();
        expected.put(PlateauSize.X, 5);
        expected.put(PlateauSize.Y, 5);

        assertAll(
                () -> assertEquals(expected.get(PlateauSize.X), result.get(PlateauSize.X)),
                () -> assertEquals(expected.get(PlateauSize.Y), result.get(PlateauSize.Y))
        );

    }

    @Test
    @DisplayName("Test invalid plateau X coordinate that is less than 2")
    void testInvalidPlateauXCoordinates() {
        provideInput("1 3\n");
        PlateauParser parser = new PlateauParser(new Scanner(System.in));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, parser::plateauInput);

        assertEquals("Incorrect Format Houston! Try Again.", exception.getMessage());
    }

    @Test
    @DisplayName("Test both invalid plateau coordinates that are less than 2")
    void testBothInvalidPlateauCoordinates() {
        provideInput("1 1\n");
        PlateauParser parser = new PlateauParser(new Scanner(System.in));
        HashMap<PlateauSize, Integer> result = parser.plateauInput();

        assertAll(

        );

    }

    @Test
    @DisplayName("Test no plateau X coordinate input")
    void testNoPlateauXCoordinatesInput() {
        provideInput("1 1\n");
        PlateauParser parser = new PlateauParser(new Scanner(System.in));
        HashMap<PlateauSize, Integer> result = parser.plateauInput();

        assertTrue(result.isEmpty(), "Result should be empty for completely invalid input coordinates");

    }

}