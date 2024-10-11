package me.erano.com.example1;

//Concrete Component
public class TextView implements VisualComponent {
    @Override
    public void draw() {
        System.out.println("Drawing TextView");
    }
}
