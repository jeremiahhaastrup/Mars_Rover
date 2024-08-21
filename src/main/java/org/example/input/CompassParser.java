package org.example.input;

import org.example.Compass;
import org.example.PlateauSize;
import org.example.Position;

import java.util.*;

public class CompassParser {

    HashMap<Compass, Position> result;
    private final Scanner scanner;
    PlateauParser plateauParser;

    public CompassParser(Scanner scanner) {
        this.scanner = scanner;
    }

    public HashMap<Compass, Position> compassInput() {

        while(true) {
            try {
                result = new HashMap<>();

                if (!scanner.hasNextLine()) {
                    System.out.println("No Input Provided. Please Enter Two Integers (X and Y Coordinates) and Direction.");
                    continue;
                }

                System.out.println("Please Enter Two Integers (X and Y Coordinates) and a Direction For The Rovers Starting Position:");
                System.out.println("Key:");
                System.out.println("W -> West");
                System.out.println("E -> East");
                System.out.println("N -> North");
                System.out.println("S -> South");
                int xCoordinate = scanner.nextInt();
                int yCoordinate = scanner.nextInt();
                char enteredCompassPoint = scanner.next().toUpperCase().charAt(0);

                if (xCoordinate < 2 || yCoordinate < 2) {
                    System.out.println("Please Enter Two Integers (X and Y Coordinates) that are more than 2");
                    continue;
                }

//                if (xCoordinate >= plateauParser.result.get(PlateauSize.X)
//                        || yCoordinate >= plateauParser.result.get(PlateauSize.Y)) {
//                    System.out.println("Please Enter Two Integers (X and Y Coordinates) less than the plateau coordinates.");
//                    continue;
//                }

                Compass compassDirection = switch (enteredCompassPoint) {
                    case 'W' -> Compass.W;
                    case 'E' -> Compass.E;
                    case 'N' -> Compass.N;
                    case 'S' -> Compass.S;
                    default -> throw new InputMismatchException();
                };

                Position position = new Position(xCoordinate, yCoordinate, compassDirection);
                result.put(compassDirection, position);
                scanner.nextLine();
                break;

            } catch (InputMismatchException | IllegalArgumentException e) {
                System.out.println("Incorrect Compass Coordinates Houston!! Please Try Again.");
                scanner.nextLine();
            } catch (NoSuchElementException e) {
                System.out.println("No Input Provided. Please Enter Two Integers (X and Y Coordinates) and Direction.");
                scanner.nextLine();
            }
        }
        return result;
    }
}
