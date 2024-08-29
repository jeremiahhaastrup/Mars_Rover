package org.example.logic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {

    @Test
    @DisplayName("Test getWidth Method")
    public void testGetWidth() {
        Plateau plateau1 = new Plateau(5, 5);
        Plateau plateau2 = new Plateau(9, 9);
        Plateau plateau3 = new Plateau(15, 15);
        Plateau plateau4 = new Plateau(12, 12);
        Plateau plateau5 = new Plateau(7, 7);

        assertAll(
                () -> assertEquals(5, plateau1.getWidth()),
                () -> assertEquals(9, plateau2.getWidth()),
                () -> assertEquals(15, plateau3.getWidth()),
                () -> assertEquals(12, plateau4.getWidth()),
                () -> assertEquals(7, plateau5.getWidth())
        );
    }

    @Test
    @DisplayName("Test getHeight Method")
    public void testGetHeightMethod() {
        Plateau plateau1 = new Plateau(5, 5);
        Plateau plateau2 = new Plateau(9, 9);
        Plateau plateau3 = new Plateau(15, 15);
        Plateau plateau4 = new Plateau(12, 12);
        Plateau plateau5 = new Plateau(7, 7);

        assertAll(
                () -> assertEquals(5, plateau1.getHeight()),
                () -> assertEquals(9, plateau2.getHeight()),
                () -> assertEquals(15, plateau3.getHeight()),
                () -> assertEquals(12, plateau4.getHeight()),
                () -> assertEquals(7, plateau5.getHeight())
        );
    }

    @Test
    @DisplayName("Test Valid and Invalid Rover Position")
    public void testRoverPositionValidity() {
        Plateau plateau = new Plateau(7,7);
        Position validPosition = new Position(6, 6);
        Position invalidPosition = new Position(8,8);

        assertTrue(plateau.isRoverPositionValid(validPosition));
        assertFalse(plateau.isRoverPositionValid(invalidPosition));
    }
}