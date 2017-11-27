package me.raupach.dungeon;

import java.io.Serializable;

public class Dungeon implements Serializable {
    
    private final int width;
    private final int height;

    public Dungeon(int width, int height) {
        this.width = width;
        this.height = height;
        
        if (width < 1) {
            throw new IllegalArgumentException("width < 1");
        }
        if (height < 1) {
            throw new IllegalArgumentException("height < 1");
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.width;
        hash = 89 * hash + this.height;
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
        final Dungeon other = (Dungeon) obj;
        if (this.width != other.width) {
            return false;
        }
        if (this.height != other.height) {
            return false;
        }
        return true;
    }
    
    
    
}
