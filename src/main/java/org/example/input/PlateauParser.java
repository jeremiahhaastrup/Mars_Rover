package org.example.input;

import org.example.Plateau;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PlateauParser {
    public ArrayList<Plateau> plateauInput() {

        ArrayList<Plateau> result = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {

                System.out.println("Enter The Measurements For The Plateau.");
                System.out.println("The Plateau Size Has To Be Equal Or More Than 2 For X and Y");
                System.out.println("X: Width");
                System.out.println("Y: Length");

                int enteredXPoint = scanner.nextInt();
                int enteredYPoint = scanner.nextInt();

                if (enteredXPoint < 2 || enteredYPoint < 2) {
                    throw new IllegalArgumentException();
                }


                String enteredCompassPoints = Integer.toString(enteredXPoint,enteredYPoint);

                for (char index : enteredCompassPoints.toCharArray()) {
                    if (enteredCompassPoints.indexOf(index) == 0) {
                        result.add(Plateau.X);
                    }
                    if (enteredCompassPoints.indexOf(index) == 1) {
                        result.add(Plateau.Y);
                    }
                }

                scanner.close();
                break;

            } catch (InputMismatchException e) {
                System.err.println("Incorrect Format Houston! Try Again");

            }
        }
        return result;
    }
}
