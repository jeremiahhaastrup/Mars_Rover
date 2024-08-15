package org.example.input;

import org.example.Compass;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CompassParser {
    public ArrayList<Compass> compassInput() {

        ArrayList<Compass> result = new ArrayList<>();

        while(true) {
            try {
                Scanner scanner = new Scanner(System.in);

                System.out.println("Enter The Compass Point For The Rover.");
                System.out.println("W: West.");
                System.out.println("E: East.");
                System.out.println("N: North.");
                System.out.println("S: South.");
                String enteredCompassPoint = scanner.nextLine();

                if (enteredCompassPoint.equals("W")) {
                    result.add(Compass.W);
                } else if (enteredCompassPoint.equals("E")) {
                    result.add(Compass.E);
                } else if (enteredCompassPoint.equals("S")) {
                    result.add(Compass.S);
                } else if (enteredCompassPoint.equals("N")) {
                    result.add(Compass.N);
                } else {
                    throw new InputMismatchException();
                }

                scanner.close();
                break;

            } catch (InputMismatchException e) {
                System.err.println("Incorrect Format Houston! Try Again" + e);
            }
        }
        return result;
    }
}
