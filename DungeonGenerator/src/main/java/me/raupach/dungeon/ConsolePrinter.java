package me.raupach.dungeon;

import java.io.PrintStream;
import java.util.Arrays;

public class ConsolePrinter {
    
    private char[][] buffer;
    
    public ConsolePrinter() {
        this.buffer = new char[0][0];
    }
    
    public void add(Dungeon dungeon) {
        horizontal(0, 0, '#', dungeon.getWidth() + 2);
        vertical(0, 0, '#', dungeon.getHeight() + 2);
        horizontal(0, dungeon.getHeight() + 1, '#', dungeon.getWidth() + 2);
        vertical(dungeon.getWidth() + 1, 0, '#', dungeon.getHeight() + 2);
    }
    
    public void add(Room room) {
        add(room.getTopLeft(), '+');
        horizontal(room.getTopLeft().getX() + 1, room.getTopLeft().getY(), '-', room.getWidth() - 1);
        add(room.getTopRight(), '+');
        vertical(room.getTopLeft().getX(), room.getTopLeft().getY() + 1, '|', room.getHeight() - 1);
        add(room.getBottomLeft(), '+');
        horizontal(room.getBottomLeft().getX() + 1, room.getBottomLeft().getY(), '-', room.getWidth() - 1);
        add(room.getBottomRight(), '+');
        vertical(room.getTopRight().getX(), room.getTopRight().getY() + 1, '|', room.getHeight() - 1);
    }
    
    public void horizontal(int x, int y, char c, int width) {
        while (width-- > 0) {
            add(x++, y, c);
        }
    }
    
    public void vertical(int x, int y, char c, int height) {
        while (height-- > 0) {
            add(x, y++, c);
        }
    }
    
    public void add(Coordinate coordinate, char c) {
        add(coordinate.getX(), coordinate.getY(), c);
    }
    
    public void add(int x, int y, char c) {
        if (y >= buffer.length) {
            buffer = Arrays.copyOf(buffer, y + 1);
        }
        if (buffer[y] == null) {
            buffer[y] = new char[x + 1];
        } else if (x >= buffer[y].length) {
           buffer[y] = Arrays.copyOf(buffer[y], x + 1);
        }
        buffer[y][x] = c;
    }
    
    public void clear() {
        this.buffer = new char[0][0];
    }
    
    public void print() {
        PrintStream out = System.out;
        final char space = ' ';
        final char[] empty = new char[0];
        for (int i = 0; i < buffer.length; i++) {
            if (buffer[i] == null) {
                buffer[i] = empty;
            } else {
                for (int j = 0; j < buffer[i].length; j++) {
                    if (buffer[i][j] == '\u0000') {
                        buffer[i][j] = space;
                    }
                }
            }
        }
        for (char[] x : buffer) {
            out.println(x);
        }
    }
    
}
