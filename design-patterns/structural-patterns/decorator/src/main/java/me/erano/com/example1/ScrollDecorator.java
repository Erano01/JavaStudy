package me.erano.com.example1;

//Concrete decorator
public class ScrollDecorator extends Decorator {
    public ScrollDecorator(VisualComponent component) {
        super(component);
    }

    @Override
    public void draw() {
        super.draw();
        addScroll();
    }

    private void addScroll() {
        System.out.println("Adding scroll functionality");
    }
}
