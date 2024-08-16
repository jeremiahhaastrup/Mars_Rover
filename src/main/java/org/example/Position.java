package org.example;

public class Position {
    private int x;
    private int y;
    private Compass facing;

    public Position(int x, int y, Compass facing) {
        this.x = x;
        this.y = y;
        this.facing = facing;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Compass getFacing() {
        return facing;
    }
}
