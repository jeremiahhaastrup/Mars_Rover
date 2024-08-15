package org.example.input;

import org.example.Compass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CompassParser {
    public HashMap<Compass, Character> compassInput() {

        HashMap<Compass, Character> result;

        while(true) {
            try {
                result = new HashMap<>();
                Scanner scanner = new Scanner(System.in);

                System.out.println("Enter The Compass Point For The Rover.");
                System.out.println("W: West.");
                System.out.println("E: East.");
                System.out.println("N: North.");
                System.out.println("S: South.");
                char enteredCompassPoint = scanner.next().charAt(0);

                if (enteredCompassPoint == 'W') {
                    result.put(Compass.W, enteredCompassPoint);
                } else if (enteredCompassPoint == 'E') {
                    result.put(Compass.W, enteredCompassPoint);
                } else if (enteredCompassPoint == 'S') {
                    result.put(Compass.S, enteredCompassPoint);
                } else if (enteredCompassPoint == 'N') {
                    result.put(Compass.N, enteredCompassPoint);
                } else {
                    throw new InputMismatchException();
                }
                System.out.println(result);
                scanner.close();
                break;

            } catch (InputMismatchException e) {
                System.err.println("Incorrect Format Houston! Try Again" + e);
            }
        }
        return result;
    }
}
