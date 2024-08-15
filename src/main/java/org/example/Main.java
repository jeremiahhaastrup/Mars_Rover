package org.example;

import org.example.input.CompassParser;
import org.example.input.InstructionParser;
import org.example.input.PlateauParser;

public class Main {
    public static void main(String[] args) {

        InstructionParser instructionParser = new InstructionParser();
        instructionParser.instructionInput();

//        PlateauParser plateauParser = new PlateauParser();
//        plateauParser.plateauInput();


//        CompassParser compassParser = new CompassParser();
//        compassParser.compassInput();
    }
}