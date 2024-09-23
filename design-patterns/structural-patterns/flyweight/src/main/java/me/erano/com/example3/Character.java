package me.erano.com.example3;

//ConcreteFlyweight -> implements the Flyweight interface and adds storage for intrinsic state, if any.
//A ConcreteFlyweight object must be sharable. Any state it stores must be intrinsic; that is, 
//it must be independent ofthe ConcreteFlyweight object's context.
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
