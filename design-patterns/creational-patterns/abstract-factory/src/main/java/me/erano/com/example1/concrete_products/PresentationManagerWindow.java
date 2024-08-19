package me.erano.com.example1.concrete_products;

import me.erano.com.example1.abstract_products.Window;

//gof da yok
public class PresentationManagerWindow implements Window {
    @Override
    public void render() {
        System.out.println("Rendering PM Window");
    }
}
