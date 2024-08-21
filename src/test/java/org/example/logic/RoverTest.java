package org.example.logic;

import org.example.Compass;
import org.example.Instruction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

    @Test
    @DisplayName("Test Rover turning left As It Faces North")
    void rotateLeftAsRoverFacesNorth() {
        Rover rover = new Rover(Compass.N);
        rover.rotate(Instruction.L);

        assertEquals(Compass.W, rover.getCompass());
    }

    @Test
    @DisplayName("Test Rover turning right As It Faces North")
    void rotateRightAsRoverFacesNorth() {
        Rover rover = new Rover(Compass.N);
        rover.rotate(Instruction.R);

        assertEquals(Compass.E, rover.getCompass());
    }

    @Test
    @DisplayName("Test Rover turning left As It Faces West")
    void rotateLeftAsRoverFacesWest() {
        Rover rover = new Rover(Compass.W);
        rover.rotate(Instruction.L);

        assertEquals(Compass.S, rover.getCompass());
    }

    @Test
    @DisplayName("Test Rover turning right As It Faces West")
    void rotateRightAsRoverFacesWest() {
        Rover rover = new Rover(Compass.W);
        rover.rotate(Instruction.R);

        assertEquals(Compass.N, rover.getCompass());
    }

    @Test
    @DisplayName("Test Rover turning left As It Faces South")
    void rotateLeftAsRoverFacesSouth() {
        Rover rover = new Rover(Compass.S);
        rover.rotate(Instruction.L);

        assertEquals(Compass.E, rover.getCompass());
    }

    @Test
    @DisplayName("Test Rover turning right As It Faces South")
    void rotateRightAsRoverFacesSouth() {
        Rover rover = new Rover(Compass.S);
        rover.rotate(Instruction.R);

        assertEquals(Compass.W, rover.getCompass());
    }

    @Test
    @DisplayName("Test Rover turning left As It Faces East")
    void rotateLeftAsRoverFacesEast() {
        Rover rover = new Rover(Compass.E);
        rover.rotate(Instruction.L);

        assertEquals(Compass.N, rover.getCompass());
    }

    @Test
    @DisplayName("Test Rover turning right As It Faces East")
    void rotateRightAsRoverFacesEast() {
        Rover rover = new Rover(Compass.E);
        rover.rotate(Instruction.R);

        assertEquals(Compass.S, rover.getCompass());
    }
}