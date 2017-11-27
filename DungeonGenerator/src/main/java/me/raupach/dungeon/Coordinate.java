package me.raupach.dungeon;

import java.io.Serializable;

/**
 * A coordinate in a logical two-dimensional coordinate system.
 * The x coordinate increases to the right, and the y coordinate increases downward.
 * (0,0) is the upper left corner.
 */
public class Coordinate implements Serializable {
    
    public static final Coordinate ORIGIN = Coordinate.of(0, 0);
    
    private final int x;
    private final int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
        if (x < 0) {
            throw new IllegalArgumentException("x < 0");
        }
        if (y < 0) {
            throw new IllegalArgumentException("y < 0");
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public Coordinate withX(int x) {
        return new Coordinate(x, this.y);
    }
    
    public Coordinate withY(int y) {
        return new Coordinate(this.x, y);
    }
    
    public static Coordinate of(int x, int y) {
        return new Coordinate(x, y);
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.x;
        hash = 13 * hash + this.y;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Coordinate other = (Coordinate) obj;
        return (this.x == other.x && this.y == other.y);
    }
    
    @Override
    public String toString() {
        return new StringBuilder()
                .append('(')
                .append(x)
                .append(',')
                .append(y)
                .append(')')
                .toString();
    }
    
    
    
}
