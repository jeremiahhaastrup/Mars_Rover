package org.example.logic;

import org.example.Compass;
import org.example.Instruction;
import org.example.Position;
import org.example.interfaces.Vehicle;

public class Rover implements Vehicle {
    private int id = 0;
    private String name;
    Position position;
    Instruction instruction;
    Compass compass;

    public Rover(Compass initialCompass) {
        this.compass = initialCompass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id++;
    }

    public void setId(int id) {
        this.id = id;
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

    public void rotate(Instruction instruction) {
        switch (instruction) {
            case Instruction.L -> turnLeft();
            case Instruction.R -> turnRight();
            default -> throw new IllegalArgumentException("Houston.. We Can't Rotate!");
        };
    }

    public Compass getCompass() {
        return compass;
    }
}
