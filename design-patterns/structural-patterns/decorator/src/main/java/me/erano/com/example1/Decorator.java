package me.erano.com.example1;

//decorator
public abstract class Decorator implements VisualComponent {
    protected VisualComponent component;

    public Decorator(VisualComponent component) {
        this.component = component;
    }

    @Override
    public void draw() {
        component.draw(); // Temel bileşenin draw() metodunu çağır
    }
}
