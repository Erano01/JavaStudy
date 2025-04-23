package me.erano.com.example1;

public class Composition {

    private Compositor compositor;

    public Composition(Compositor compositor) {
        this.compositor = compositor;
    }

    public void traverse(){

    }
    public void repair(){
        compositor.compose();
    }
}
