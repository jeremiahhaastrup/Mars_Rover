package org.example.logic;

import org.example.type.Compass;
import org.example.type.Instruction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

    Rover rover;
    Plateau plateau;
    Position position;


    @BeforeEach
    void setUp() {
        rover = new Rover(Compass.N);
        plateau = new Plateau(7,7);
        position = new Position(5,5);
        rover.position = position;
        rover.plateau = plateau;
    }

    @Test
    @DisplayName("Test Rover Turning Left")
    void testRoverTurningLeft() {

        rover.turnLeft();
        assertEquals(Compass.W, rover.getCompass());

        rover.turnLeft();
        assertEquals(Compass.S, rover.getCompass());

        rover.turnLeft();
        assertEquals(Compass.E, rover.getCompass());
    }

    @Test
    @DisplayName("Test Rover Turning Right")
    void testRoverTurningRight() {

        rover.turnRight();
        assertEquals(Compass.E, rover.getCompass());

        rover.turnRight();
        assertEquals(Compass.S, rover.getCompass());

        rover.turnRight();
        assertEquals(Compass.W, rover.getCompass());
    }

    @Test
    @DisplayName("Test Rover Moving Forward")
    void testRoverMovingForward() {

        rover.moveForward();
        assertEquals(5, rover.position.getX());
        assertEquals(6, rover.position.getY());

        rover.compass = Compass.W;
        rover.moveForward();
        assertEquals(4, rover.position.getX());
        assertEquals(6, rover.position.getY());
    }

    @Test
    @DisplayName("Test Instruction Commands")
    public void testInstructionCommands() {

        ArrayList<Instruction> expectedInstruction = new ArrayList<>();

        expectedInstruction.add(Instruction.R);
        expectedInstruction.add(Instruction.M);
        expectedInstruction.add(Instruction.M);
        rover.instructionCommands(expectedInstruction);

        assertAll(
                () -> assertEquals(7, rover.position.getX()),
                () -> assertEquals(5, rover.position.getY()),
                () -> assertEquals(Compass.E, rover.getCompass())
        );

    }

    @Test
    @DisplayName("Test Calculating Rover Position")
    void testCalculateRoverPosition() {

        Position newPosition = rover.calculatePosition();
        assertEquals(5, newPosition.getX());
        assertEquals(6, newPosition.getY());

        rover.compass = Compass.E;
        newPosition = rover.calculatePosition();
        assertEquals(6, newPosition.getX());
        assertEquals(5, newPosition.getY());
    }

}