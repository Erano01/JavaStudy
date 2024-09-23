package me.erano.com.example3;

import java.util.ArrayList;
import java.util.List;

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
