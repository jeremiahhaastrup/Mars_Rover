package org.example;

import org.example.input.CompassParser;
import org.example.input.InstructionParser;
import org.example.input.PlateauParser;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PlateauParser plateauParser = new PlateauParser(scanner);
        CompassParser compassParser = new CompassParser(scanner);
        InstructionParser instructionParser = new InstructionParser(scanner);

        plateauParser.plateauInput();
        compassParser.compassInput();
        instructionParser.instructionInput();

        scanner.close();
    }
}