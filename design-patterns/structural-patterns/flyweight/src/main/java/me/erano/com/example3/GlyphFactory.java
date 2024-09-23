package me.erano.com.example3;

import java.util.HashMap;
import java.util.Map;

public class GlyphFactory {
    private final Map<java.lang.Character, me.erano.com.example3.Character> characterMap = new HashMap<>();

    // Creates and returns shared flyweight objects (characters)
    public Character getCharacter(char charCode) {
        return characterMap.computeIfAbsent(charCode, Character::new);
    }

    // Unshared flyweight objects
    public Row createRow() {
        return new Row();
    }
}
