package me.raupach.dungeon;

import java.io.Serializable;
import java.util.Objects;

/**
 * A room is basically a rectangle with four right angles at four coordinates.
 */
public class Room implements Serializable {
    
    private final Coordinate topLeft;
    private final Coordinate topRight;
    private final Coordinate bottomLeft;
    private final Coordinate bottomRight;
    
    public Room(int width, int height) {
        this(new Coordinate(0, 0), width, height);
    }
    
    public Room(Coordinate coordinate, int width, int height) {
        
    }

    public Room(Coordinate topLeft, Coordinate topRight, Coordinate bottomLeft, Coordinate bottomRight) {
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
        
        if (topLeft.getY() != topRight.getY()) {
            throw new IllegalArgumentException("topLeft.y != topRight.y");
        }
        if (bottomLeft.getY() != bottomRight.getY()) {
            throw new IllegalArgumentException("bottomLeft.y != bottomRight.y");
        }
        if (topLeft.getX() != bottomLeft.getX()) {
            throw new IllegalArgumentException("topLeft.x != bottomLeft.x");
        }
        if (topRight.getX() != bottomRight.getX()) {
            throw new IllegalArgumentException("topRight.x != bottomRight.x");
        }
        if (topLeft.equals(topRight)) {
            throw new IllegalArgumentException("topLeft == topRight");
        }
        if (topLeft.equals(bottomRight)) {
            throw new IllegalArgumentException("topLeft == bottomRight");
        }
        if (topLeft.equals(bottomLeft)) {
            throw new IllegalArgumentException("topLeft == bottomLeft");
        }
        if (topRight.equals(bottomRight)) {
            throw new IllegalArgumentException("topRight == bottomRight");
        }
        if (topRight.equals(bottomLeft)) {
            throw new IllegalArgumentException("topRight == bottomLeft");
        }
        if (topLeft.equals(bottomRight)) {
            throw new IllegalArgumentException("topLeft == bottomRight");
        }
    }
    
    public Coordinate getTopLeft() {
        return topLeft;
    }

    public Coordinate getTopRight() {
        return topRight;
    }

    public Coordinate getBottomLeft() {
        return bottomLeft;
    }

    public Coordinate getBottomRight() {
        return bottomRight;
    }
    
    public int getX() {
        return getTopLeft().getX();
    }
    
    public int getY() {
        return getTopLeft().getY();
    }
    
    public int getWidth() {
        return topRight.getX() - topLeft.getX();
    }
    
    public int getHeight() {
        return bottomLeft.getY() - topLeft.getY();
    }
    
    public Room moveTo(Coordinate coordinate) {
        return new Room(coordinate, getWidth(), getHeight());
    }
    
    public Room moveTo(int x, int y) {
        return new Room(new Coordinate(x, y), getWidth(), getHeight());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.topLeft);
        hash = 43 * hash + Objects.hashCode(this.topRight);
        hash = 43 * hash + Objects.hashCode(this.bottomLeft);
        hash = 43 * hash + Objects.hashCode(this.bottomRight);
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
        final Room other = (Room) obj;
        if (!Objects.equals(this.topLeft, other.topLeft)) {
            return false;
        }
        if (!Objects.equals(this.topRight, other.topRight)) {
            return false;
        }
        if (!Objects.equals(this.bottomLeft, other.bottomLeft)) {
            return false;
        }
        if (!Objects.equals(this.bottomRight, other.bottomRight)) {
            return false;
        }
        return true;
    }
    
}
