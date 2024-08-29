package org.example;

import org.example.logic.Rover;
import org.example.type.Compass;
import org.example.logic.Position;
import org.example.type.Instruction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class PositionTest {

    Rover rover;
    Compass compass;

    @BeforeEach
    void setUp() {
        rover = new Rover(compass);
    }


    @Test
    @DisplayName("Test the rover moving forward whilst facing East")
    void moveForwardAndFacingEast() {
        Position position = new Position(3,3);

        ArrayList<Instruction> result = new ArrayList<>();
        result.add(Instruction.M);

        var actual = rover.instructionCommands(result);
        var expected = new Position(4,3);

        assertEquals(expected.getX(), actual.getX());
    }

    @Test
    @DisplayName("Test the rover moving forward whilst facing North")
    void moveForwardAndFacingNorth() {
        Position position = new Position(3,3);

        var actual = rover.moveForward(Compass.N);
        var expected = new Position(3,4);

        assertEquals(expected.getY(), actual.getY());
    }

    @Test
    @DisplayName("Test the rover moving forward whilst facing West")
    void moveForwardAndFacingWest() {
        Position position = new Position(3,3);

        var actual = rover.moveForward(Compass.W);
        var expected = new Position(2,3);

        assertEquals(expected.getX(), actual.getX());
    }

    @Test
    @DisplayName("Test the rover moving forward whilst facing South")
    void moveForwardAndFacingSouth() {
        Position position = new Position(3,3);

        var actual = rover.moveForward(Compass.S);
        var expected = new Position(3,2);

        assertEquals(expected.getY(), actual.getY());
    }
}