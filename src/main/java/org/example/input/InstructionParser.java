package org.example.input;

import org.example.Instruction;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InstructionParser {
    public void instructionInput() {
        while(true) {
            try {
                Scanner scanner = new Scanner(System.in);
                StringBuilder result = new StringBuilder();

                System.out.println("Enter The Instructions For The Rover.");
                System.out.println("R: Spin Right at 90 degrees.");
                System.out.println("L: Spin Left at 90 degrees.");
                System.out.println("M: Move Forward by One Grid Point");
                String enteredInstruction = scanner.nextLine();

                for (char index : enteredInstruction.toCharArray()) {
                    switch(index) {
                        case 'R':
                            result.append(Instruction.R);
                        break;
                        case 'L':
                            result.append(Instruction.L);
                        break;
                        case 'M':
                            result.append(Instruction.M);
                        break;
                        default:
                            System.err.println(index + " - Incorrect Format Houston. Try again");
                    }
                }
                System.out.println(result);
                scanner.close();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Incorrect Format Houston. Try Again" + e);
            }
        }
    }
}
