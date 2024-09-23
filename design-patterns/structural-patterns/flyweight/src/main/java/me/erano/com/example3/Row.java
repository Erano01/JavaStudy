package me.erano.com.example3;

import java.util.ArrayList;
import java.util.List;

//UnsharedConcreteFlyweight -> not all Flyweight subclasses need to be shared. 
//The Flyweight interface enables sharing; it doesn't enforce it. 
//It's common for UnsharedConcreteFlyweight objects to have ConcreteFlyweight objects as children at some level in the 
//flyweight object structure (as the Row and Column classes have).
public class Row implements Glyph {
    
	private final List<Glyph> glyphs = new ArrayList<>();  // Contains flyweight objects

    public void add(Glyph glyph) {
        glyphs.add(glyph);
    }

    @Override
    public void draw(String font) {  // Pass the extrinsic state (font) to children
        for (Glyph glyph : glyphs) {
            glyph.draw(font);
        }
    }
}
