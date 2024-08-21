package org.example;

public class Position {
    private final int x;
    private final int y;
    private final Compass facing;

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

    public Position moveForward(Compass compass) {
        return switch (compass) {
            case Compass.N -> new Position(x, y + 1, facing);
            case Compass.E -> new Position(x + 1, y, facing);
            case Compass.W -> new Position(x - 1, y, facing);
            case Compass.S -> new Position(x, y - 1, facing);
        };
    }

    // is position empty method
    // does position exist
}
