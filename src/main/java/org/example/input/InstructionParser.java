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
//        while(true) {
//            try {
//
//                System.out.println("Please Provide The Rover With Instructions.");
//                System.out.println("Key:");
//                System.out.println("L -> Spins the Rover 90 degrees Left without moving from the current coordinate point.");
//                System.out.println("R -> Spins the Rover 90 degrees Right without moving from the current coordinate point");
//                System.out.println("M -> Moves the Rover forward by one grid point, maintaining the same heading/orientation");
//
//                String enteredInstruction = scanner.nextLine();
//
//                for (char index : enteredInstruction.toCharArray()) {
//                    if (index == 'R' || index == 'r') {
//                        result.add(Instruction.R);
//                    } else if (index == 'L' || index == 'l') {
//                        result.add(Instruction.L);
//                    } else if (index == 'M' || index == 'm') {
//                        result.add(Instruction.M);
//                    } else {
//                        throw new InputMismatchException();
//                    }
//                }
//                break;
//            } catch (InputMismatchException e) {
//                System.out.println("Incorrect Instructions Houston! Try Again.");
//            } catch (NoSuchElementException e) {
//                System.out.println("No Input Provided. Please Provide The Rover With Instructions.");
//                scanner.nextLine();
//            }
//        }
//        return result;
//    }
//}
