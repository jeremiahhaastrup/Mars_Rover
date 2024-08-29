package org.example.input;

import org.example.logic.Position;
import org.example.type.Compass;

import java.util.*;

public class CompassParser {

    HashMap<Compass, Position> result;

    public HashMap<Compass, Position> compassInput(String input) {

        result = new HashMap<>();

        String[] compassInputParsed = input.split(" ");
        int enteredXPoint = Integer.parseInt(compassInputParsed[0]);
        int enteredYPoint = Integer.parseInt(compassInputParsed[1]);
        char compassDirection = compassInputParsed[2].charAt(0);

        if (enteredXPoint < 0 || enteredYPoint < 0 || !Character.isLetter(compassDirection)) {
            throw new IllegalArgumentException();
        }

        Compass inputToCompassDirection = switch (compassDirection) {
                    case 'W' -> Compass.W;
                    case 'E' -> Compass.E;
                    case 'N' -> Compass.N;
                    case 'S' -> Compass.S;
                    default -> throw new InputMismatchException();
                };

        Position position = new Position(enteredXPoint, enteredYPoint);
        result.put(inputToCompassDirection, position);
        return result;
    }
}

