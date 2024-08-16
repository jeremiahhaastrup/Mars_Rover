package org.example.input;

import org.example.Plateau;

import java.util.*;

public class PlateauParser {

    HashMap<Plateau, Integer> result;
    private Scanner scanner;

    public PlateauParser(Scanner scanner) {
        this.scanner = scanner;
    }

    public Map<Plateau, Integer> plateauInput() {

        while (true) {
            try {
                result = new HashMap();

                int enteredXPoint = scanner.nextInt();
                int enteredYPoint = scanner.nextInt();
                scanner.nextLine();

                if (enteredXPoint < 2 || enteredYPoint < 2) {
                    throw new IllegalArgumentException();
                }

                result.put(Plateau.X, enteredXPoint);
                result.put(Plateau.Y, enteredYPoint);

                break;

            } catch (InputMismatchException e) {
                System.err.println("Incorrect Format Houston! Try Again.");
                scanner.nextLine();
            }
        }
        return result;
    }
}
