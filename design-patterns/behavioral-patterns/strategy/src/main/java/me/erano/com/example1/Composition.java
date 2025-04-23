package me.erano.com.example1;

public class Composition {
    private Compositor compositor;

    public Composition(Compositor compositor) {
        this.compositor = compositor;
    }

    public void repair(String[] text) {
        compositor.compose(text);
    }

    public void setCompositor(Compositor compositor) {
        this.compositor = compositor;
    }
}
