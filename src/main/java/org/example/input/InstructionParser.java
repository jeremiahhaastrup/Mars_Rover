package org.example.input;

import org.example.Instruction;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InstructionParser {

    ArrayList<Instruction> result;
    private Scanner scanner;

    public InstructionParser(Scanner scanner) {
        this.scanner = scanner;
    }

    public ArrayList<Instruction> instructionInput() {
        result = new ArrayList<>();
        while(true) {
            try {
                String enteredInstruction = scanner.nextLine();

                for (char index : enteredInstruction.toCharArray()) {
                    if (index == 'R') {
                        result.add(Instruction.R);
                    } else if (index == 'L') {
                        result.add(Instruction.L);
                    } else if (index == 'M') {
                        result.add(Instruction.M);
                    } else {
                        throw new InputMismatchException("Invalid Instruction For Rover");
                    }
                }
                break;

            } catch (InputMismatchException e) {
                System.out.println("Incorrect Instructions Houston! Try Again.");
            }
        }
        return result;
    }
}
