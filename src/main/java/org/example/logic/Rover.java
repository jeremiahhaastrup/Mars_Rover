package org.example.logic;

import org.example.type.Compass;
import org.example.type.Instruction;

import java.util.ArrayList;

public class Rover {
    Position position;
    Plateau plateau;
    Compass compass;

    public Rover(Compass initialCompass) {
        this.compass = initialCompass;
    }

    public Compass getCompass() {
        return compass;
    }

    public void turnLeft() {
        switch(compass) {
            case Compass.W:
                compass = Compass.S;
                break;
            case Compass.S:
                compass = Compass.E;
                break;
            case Compass.E:
                compass = Compass.N;
                break;
            case Compass.N:
                compass = Compass.W;
                break;
            default: throw  new RuntimeException("Error with turning left!");
        }
    }

    public void turnRight() {
        switch(compass) {
            case Compass.W:
                compass = Compass.N;
                break;
            case Compass.N:
                compass = Compass.E;
                break;
            case Compass.E:
                compass = Compass.S;
                break;
            case Compass.S:
                compass = Compass.W;
                break;
            default: throw  new RuntimeException("Error with turning left!");
        }
    }

    public Position calculatePosition() {
        int x = position.getX();
        int y = position.getY();
        switch (compass) {
            case Compass.N -> y += 1;
            case Compass.E -> x += 1;
            case Compass.W -> x -= 1;
            case Compass.S -> y -= 1;
        }
        return new Position(x,y);
    }

    public void moveForward() {
        Position newPosition = calculatePosition();
            if (plateau.isRoverPositionValid(newPosition)) {
                position = newPosition;
            } else {
                System.out.println("Houston... I want to get home in one piece 😅. Please avoid the boundary and other rovers");
            }
    }

    public void instructionCommands(ArrayList<Instruction> instructions) {
        for (Instruction instruction : instructions) {
        switch (instruction) {
            case Instruction.L:
                turnLeft();
                break;
            case Instruction.R:
                turnRight();
                break;
            case Instruction.M:
                moveForward();
                break;
            default:
                throw new IllegalArgumentException("Houston... We Can't Rotate!");
        }
        }
    }

    @Override
    public String toString() {
        return position.getX()
                + " "
                + position.getY()
                + " "
                + compass;
    }
}
