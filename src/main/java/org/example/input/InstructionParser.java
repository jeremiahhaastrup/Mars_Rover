package org.example.input;

import org.example.Instruction;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InstructionParser {
    public ArrayList<Instruction> instructionInput() {
        ArrayList<Instruction> result = new ArrayList<>();

        while(true) {
            try {
                Scanner scanner = new Scanner(System.in);

                System.out.println("Enter The Instructions For The Rover.");
                System.out.println("R: Spin Right at 90 degrees.");
                System.out.println("L: Spin Left at 90 degrees.");
                System.out.println("M: Move Forward by One Grid Point");
                String enteredInstruction = scanner.nextLine();

                for (char index : enteredInstruction.toCharArray()) {
                    if (index == 'R') {
                        result.add(Instruction.R);
                    } else if (index == 'L') {
                        result.add(Instruction.L);
                    } else if (index == 'M') {
                        result.add(Instruction.M);
                    } else {
                        throw new InputMismatchException();
                    }
                }

                scanner.close();
                break;

            } catch (InputMismatchException e) {
                System.out.println("Incorrect Format Houston. Try Again " + e);
            }
        }
        return result;
    }
}
