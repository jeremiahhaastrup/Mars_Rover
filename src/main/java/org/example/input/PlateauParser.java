package org.example.input;

import org.example.type.PlateauSize;

import java.util.*;

public class PlateauParser {

    HashMap<PlateauSize, Integer> result;

    public HashMap<PlateauSize, Integer> plateauInput(String input) {

        String[] plateauCoordinates = input.split(" ");
        int enteredXPoint = Integer.parseInt(plateauCoordinates[0]);
        int enteredYPoint = Integer.parseInt(plateauCoordinates[1]);

        result = new HashMap<>();

        if (enteredXPoint <= 2 || enteredYPoint <= 2) {
            throw new IllegalArgumentException();
        }

        result.put(PlateauSize.X, enteredXPoint);
        result.put(PlateauSize.Y, enteredYPoint);

        return result;
    }
}
