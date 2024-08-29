package org.example.input;

import org.example.type.Instruction;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class InstructionParser {

    ArrayList<Instruction> result;

    public ArrayList<Instruction> instructionInput(String input) {

        if (input == null || input.isEmpty()) {
            throw new NullPointerException();
        }

        result = new ArrayList<>();

        for (char index : input.toCharArray()) {
                    if (index == 'R' || index == 'r') {
                        result.add(Instruction.R);
                    } else if (index == 'L' || index == 'l') {
                        result.add(Instruction.L);
                    } else if (index == 'M' || index == 'm') {
                        result.add(Instruction.M);
                    } else {
                        throw new InputMismatchException();
                    }
                }

        return result;

    }
}