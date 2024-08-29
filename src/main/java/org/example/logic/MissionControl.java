package org.example.logic;

import org.example.type.Compass;
import org.example.type.Instruction;

import java.util.ArrayList;
import java.util.HashMap;

public class MissionControl {
    private final HashMap<String, Rover> rovers = new HashMap<>();
    private final Plateau plateau;

    public MissionControl(Plateau plateau) {
        this.plateau = plateau;
    }

    public void addRoverToPlateau(String roverName, Rover rover, Position position) {
        rover.plateau = plateau;
        rover.position = position;
        rovers.put(roverName, rover);
    }

    public String getRoverPosition(String roverName) {
        Rover rover = rovers.get(roverName);
        return rover != null ? rover.toString() : null;
    }

    public void executeCommandForRover(String roverName, ArrayList<Instruction> instructions) {
        Rover rover = rovers.get(roverName);
        if (rover != null) {
            rover.instructionCommands(instructions);
        } else {
            throw new IllegalArgumentException("Houston... This Rover Was Never Made 🧐");
        }
    }

}
