package me.raupach.dungeon;

import org.junit.Test;

public class ConsolePrinterTest {
    
    @Test
    public void addChar() {
        ConsolePrinter cp = new ConsolePrinter();
        
        //Dungeon d1 = new Dungeon(4, 10);
        //cp.add(d1);
        
        
        Room r2 = new Room(10, 1);
        
        cp.add(r2);
        cp.print();
    }
    
}
