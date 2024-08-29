package org.example.logic;

public class Plateau {
    private final int width;
    private final int height;

    public Plateau(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isRoverPositionValid(Position position) {
        int x = position.getX();
        int y = position.getY();
        return x >= 0 && x <= width && y >= 0 && y <= height;
    }
}
