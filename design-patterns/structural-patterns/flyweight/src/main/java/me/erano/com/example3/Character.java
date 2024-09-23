package me.erano.com.example3;

public class Character implements Glyph {
    private final char charCode;  // Intrinsic state: doesn't change across contexts

    public Character(char charCode) {
        this.charCode = charCode;
    }

    @Override
    public void draw(String font) {  // Extrinsic state: changes in different contexts
        System.out.println("Drawing character '" + charCode + "' with font: " + font);
    }
}
