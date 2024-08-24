package org.example;

import org.example.type.Compass;
import org.example.logic.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    @DisplayName("Test the rover moving forward whilst facing East")
    void moveForwardAndFacingEast() {
        Position position = new Position(3,3, Compass.E);

        var actual = position.moveForward(Compass.E);
        var expected = new Position(4,3,Compass.E);

        assertEquals(expected.getX(), actual.getX());
    }

    @Test
    @DisplayName("Test the rover moving forward whilst facing North")
    void moveForwardAndFacingNorth() {
        Position position = new Position(3,3,Compass.N);

        var actual = position.moveForward(Compass.N);
        var expected = new Position(3,4,Compass.N);

        assertEquals(expected.getY(), actual.getY());
    }

    @Test
    @DisplayName("Test the rover moving forward whilst facing West")
    void moveForwardAndFacingWest() {
        Position position = new Position(3,3,Compass.W);

        var actual = position.moveForward(Compass.W);
        var expected = new Position(2,3,Compass.W);

        assertEquals(expected.getX(), actual.getX());
    }

    @Test
    @DisplayName("Test the rover moving forward whilst facing South")
    void moveForwardAndFacingSouth() {
        Position position = new Position(3,3,Compass.S);

        var actual = position.moveForward(Compass.S);
        var expected = new Position(3,2,Compass.S);

        assertEquals(expected.getY(), actual.getY());
    }
}