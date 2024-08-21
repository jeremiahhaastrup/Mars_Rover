package org.example.input;

import org.example.Compass;
import org.example.Instruction;
import org.example.Position;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class InstructionParserTest {

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
    @DisplayName("Test valid instruction input for rover")
    void testValidInstructionInput() {
        provideInput("RLMRML\n");
        InstructionParser parser = new InstructionParser(new Scanner(System.in));
        ArrayList<Instruction> result = parser.instructionInput();

        ArrayList<Instruction> expectedInstruction = new ArrayList<>();
        expectedInstruction.add(Instruction.R);
        expectedInstruction.add(Instruction.L);
        expectedInstruction.add(Instruction.M);
        expectedInstruction.add(Instruction.R);
        expectedInstruction.add(Instruction.M);
        expectedInstruction.add(Instruction.L);

        assertAll(
                () -> assertEquals(expectedInstruction.getFirst(), result.getFirst()),
                () -> assertEquals(expectedInstruction.get(1), result.get(1)),
                () -> assertEquals(expectedInstruction.get(2), result.get(2)),
                () -> assertEquals(expectedInstruction.get(3), result.get(3)),
                () -> assertEquals(expectedInstruction.get(4), result.get(4)),
                () -> assertEquals(expectedInstruction.get(5), result.get(5))
        );
    }

    @Test
    @DisplayName("Test one invalid instruction input for rover")
    void testOneInvalidInstructionInput() {
        provideInput("REMRML\n");
        InstructionParser parser = new InstructionParser(new Scanner(System.in));
        ArrayList<Instruction> result = parser.instructionInput();

        ArrayList<Instruction> expectedInstruction = new ArrayList<>();
        expectedInstruction.add(Instruction.R);
        expectedInstruction.add(Instruction.L);
        expectedInstruction.add(Instruction.M);
        expectedInstruction.add(Instruction.R);
        expectedInstruction.add(Instruction.M);
        expectedInstruction.add(Instruction.L);

        assertAll(
                () -> assertEquals(expectedInstruction.getFirst(), result.getFirst()),
                () -> assertNotEquals(expectedInstruction.get(1), result.get(1)),
                () -> assertEquals(expectedInstruction.get(2), result.get(2)),
                () -> assertEquals(expectedInstruction.get(3), result.get(3)),
                () -> assertEquals(expectedInstruction.get(4), result.get(4)),
                () -> assertEquals(expectedInstruction.get(5), result.get(5))
        );
    }

    @Test
    @DisplayName("Test complete invalid instruction input for rover")
    void testAllInvalidInstructionInput() {
        provideInput("NOTHING\n");
        InstructionParser parser = new InstructionParser(new Scanner(System.in));
        ArrayList<Instruction> result = parser.instructionInput();

        ArrayList<Instruction> expectedInstruction = new ArrayList<>();
        expectedInstruction.add(Instruction.R);
        expectedInstruction.add(Instruction.L);
        expectedInstruction.add(Instruction.M);
        expectedInstruction.add(Instruction.R);
        expectedInstruction.add(Instruction.M);
        expectedInstruction.add(Instruction.M);
        expectedInstruction.add(Instruction.M);

        assertAll(
                () -> assertNotEquals(expectedInstruction.getFirst(), result.getFirst()),
                () -> assertNotEquals(expectedInstruction.get(1), result.get(1)),
                () -> assertNotEquals(expectedInstruction.get(2), result.get(2)),
                () -> assertNotEquals(expectedInstruction.get(3), result.get(3)),
                () -> assertNotEquals(expectedInstruction.get(4), result.get(4)),
                () -> assertNotEquals(expectedInstruction.get(5), result.get(5)),
                () -> assertNotEquals(expectedInstruction.get(6), result.get(6))
        );
    }

    @Test
    @DisplayName("Test no instruction input")
    void testNoInstructionInput() {

        provideInput(" \n");
        InstructionParser parser = new InstructionParser(new Scanner(System.in));
        ArrayList<Instruction> result = parser.instructionInput();

        String output = testOut.toString();



        assertAll(
                () -> assertNull(result),
                () -> assertTrue(output.contains("No Input Provided. Please Provide The Rover With Instructions."))
        );
    }
}