package org.example.logic;

import org.example.type.Compass;
import org.example.type.Instruction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MissionControlTest {

    private MissionControl missionControl;
    private Rover rover;

    @BeforeEach
    void setUp() {
        Plateau plateau = new Plateau(5, 5);
        missionControl = new MissionControl(plateau);
        rover = new Rover(Compass.N);
        Position position = new Position(2, 2);
        missionControl.addRoverToPlateau("RoverOne", rover, position);
    }

    @Test
    @DisplayName("Test Adding Rover To Plateau")
    void testAddRoverToPlateau() {

        Rover roverTwo = new Rover(Compass.E);
        Position position = new Position(1, 1);
        missionControl.addRoverToPlateau("RoverTwo", roverTwo, position);

        assertEquals("1 1 E", missionControl.getRoverPosition("RoverTwo"));
    }

    @Test
    @DisplayName("Test New Rover Position On Plateau")
    void testGetRoverPosition() {
        assertEquals("2 2 N", missionControl.getRoverPosition("RoverOne"));
    }

    @Test
    @DisplayName("Test Executing Command For Rover")
    void testExecuteCommandForRover() {
        ArrayList<Instruction> instructions = new ArrayList<>();
        instructions.add(Instruction.M);
        instructions.add(Instruction.R);
        instructions.add(Instruction.M);

        missionControl.executeCommandForRover("RoverOne", instructions);

        assertEquals("3 3 E", missionControl.getRoverPosition("RoverOne"));
    }

    @Test
    @DisplayName("Test Executing Command For Non-Existent Rover")
    void testExecuteCommandForNonExistentRover() {
        ArrayList<Instruction> instructions = new ArrayList<>();

        assertThrows(IllegalArgumentException.class, () -> missionControl.executeCommandForRover("NonExistentRover", instructions));
    }
}