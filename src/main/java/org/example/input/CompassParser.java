package org.example.input;

import org.example.Compass;
import org.example.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CompassParser {

    HashMap<Compass, Position> result;
    private Scanner scanner;

    public CompassParser(Scanner scanner) {
        this.scanner = scanner;
    }

    public HashMap<Compass, Position> compassInput() {

        while(true) {
            try {
                result = new HashMap<>();

                int xCoordinate = scanner.nextInt();
                int yCoordinate = scanner.nextInt();
                char enteredCompassPoint = scanner.next().toUpperCase().charAt(0);
                scanner.nextLine();

                Compass compassDirection = switch (enteredCompassPoint) {
                    case 'W' -> Compass.W;
                    case 'E' -> Compass.E;
                    case 'N' -> Compass.N;
                    case 'S' -> Compass.S;
                    default -> throw new InputMismatchException("Invalid Compass Direction Houston!! Try Again!");
                };

                Position position = new Position(xCoordinate, yCoordinate, compassDirection);
                result.put(compassDirection, position);
                break;

            } catch (InputMismatchException e) {
                System.out.println("Incorrect Compass Coordinates Houston! Try Again.");
                scanner.nextLine();
            }
        }
        return result;
    }
}
