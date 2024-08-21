package org.example.input;

import org.example.PlateauSize;

import java.util.*;

public class PlateauParser {

    HashMap<PlateauSize, Integer> result;
    private Scanner scanner;

    public PlateauParser(Scanner scanner) {
        this.scanner = scanner;
    }

    public HashMap<PlateauSize, Integer> plateauInput() {

        while (true) {
            try {
                result = new HashMap<>();

                System.out.println("Please Provide The Plateau Size With Two Integers");
                System.out.println("First Integer: Width");
                System.out.println("Second Integer: Height");
                int enteredXPoint = scanner.nextInt();
                int enteredYPoint = scanner.nextInt();


                if (enteredXPoint < 2 || enteredYPoint < 2) {
                    throw new IllegalArgumentException();
                }

                result.put(PlateauSize.X, enteredXPoint);
                result.put(PlateauSize.Y, enteredYPoint);
                System.out.println(result);
                break;

            } catch (InputMismatchException | IllegalArgumentException e) {
                System.out.println("Incorrect Format Houston! Try Again.");
                scanner.nextLine();
            } catch (NoSuchElementException e) {
                System.out.println("No Input Provided. Please Provide The Plateau Size With Two Integers " + e);
                scanner.nextLine();
            }
        }
        return result;
    }
}
