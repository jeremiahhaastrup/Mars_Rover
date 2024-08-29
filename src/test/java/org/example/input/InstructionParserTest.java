package org.example.input;

import org.example.type.Instruction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

class InstructionParserTest {

    InstructionParser instructionParser;

    @BeforeEach
    void setUp() {
        instructionParser = new InstructionParser();
    }


    @Test
    @DisplayName("Test valid instruction input for rover")
    void testValidInstructionInput() {
        var result = instructionParser.instructionInput("RLMRLM");

        ArrayList<Instruction> expectedInstruction = new ArrayList<>();
        expectedInstruction.add(Instruction.R);
        expectedInstruction.add(Instruction.L);
        expectedInstruction.add(Instruction.M);
        expectedInstruction.add(Instruction.R);
        expectedInstruction.add(Instruction.L);
        expectedInstruction.add(Instruction.M);

        assertEquals(expectedInstruction, result);
    }

    @Test
    @DisplayName("Test one invalid instruction input for rover")
    void testOneInvalidInstructionInput() {
        Throwable firstChar = assertThrows(InputMismatchException.class, () -> instructionParser.instructionInput("FLMRLM"));
        Throwable firstTwoChars = assertThrows(InputMismatchException.class, () -> instructionParser.instructionInput("RFFRLM"));
        Throwable allChars = assertThrows(InputMismatchException.class, () -> instructionParser.instructionInput("WRONG"));
        Throwable middleChars = assertThrows(InputMismatchException.class, () -> instructionParser.instructionInput("RTYULM"));
        Throwable lastChar = assertThrows(InputMismatchException.class, () -> instructionParser.instructionInput("RLMRLY"));

        assertAll(
                () -> assertNull(firstChar.getMessage()),
                () -> assertNull(firstTwoChars.getMessage()),
                () -> assertNull(allChars.getMessage()),
                () -> assertNull(middleChars.getMessage()),
                () -> assertNull(lastChar.getMessage())
        );
    }

    @Test
    @DisplayName("Test no instruction input")
    void testNoInstructionInput() {

        Throwable noChars = assertThrows(NullPointerException.class, () -> instructionParser.instructionInput(""));
        Throwable nullChars = assertThrows(NullPointerException.class, () -> instructionParser.instructionInput(null));

        assertAll(
                () -> assertNull(noChars.getMessage()),
                () -> assertNull(nullChars.getMessage())
        );
    }
}