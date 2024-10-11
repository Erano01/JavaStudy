package me.erano.com.example1;

//concrete decorator
public class BorderDecorator extends Decorator {
    private int borderWidth;

    public BorderDecorator(VisualComponent component, int borderWidth) {
        super(component);
        this.borderWidth = borderWidth;
    }

    @Override
    public void draw() {
        super.draw();
        drawBorder();
    }

    private void drawBorder() {
        System.out.println("Drawing border with width: " + borderWidth);
    }
}