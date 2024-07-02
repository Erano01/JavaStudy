package me.erano.com.example1.concrete_products;

import me.erano.com.example1.abstract_products.Window;

public class MotifWindow implements Window {
    @Override
    public void render() {
        System.out.println("Rendering Motif Window");
    }
}
