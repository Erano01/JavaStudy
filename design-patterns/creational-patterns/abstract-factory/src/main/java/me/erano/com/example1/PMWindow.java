package me.erano.com.example1;

import me.erano.com.example1.abstract_products.Window;

public class PMWindow implements Window {
    @Override
    public void render() {
        System.out.println("Rendering PM Window");
    }
}
