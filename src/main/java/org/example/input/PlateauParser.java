package org.example.input;

import org.example.Plateau;

import java.util.*;

public class PlateauParser {
    public Map<Plateau, Integer> plateauInput() {

        Scanner scanner = new Scanner(System.in);

        HashMap<Plateau, Integer> result;
        while (true) {
            try {
                result = new HashMap();

                System.out.println("Enter The Measurements For The Plateau.");
                System.out.println("The Plateau Size Has To Be Equal Or More Than 2 For X and Y");
                System.out.println("X: Width");
                System.out.println("Y: Length");

                int enteredXPoint = scanner.nextInt();
                int enteredYPoint = scanner.nextInt();

                if (enteredXPoint < 2 || enteredYPoint < 2) {
                    throw new IllegalArgumentException();
                }

                result.put(Plateau.X, enteredXPoint);
                result.put(Plateau.Y, enteredYPoint);

                System.out.println(result);
                scanner.close();
                break;

            } catch (InputMismatchException e) {
                System.err.println("Incorrect Format Houston! Try Again");
            }
        }
        return result;
    }
}
