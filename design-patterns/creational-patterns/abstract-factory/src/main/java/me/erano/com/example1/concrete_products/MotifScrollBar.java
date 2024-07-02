package me.erano.com.example1.concrete_products;

import me.erano.com.example1.abstract_products.ScrollBar;

public class MotifScrollBar implements ScrollBar {
    @Override
    public void scroll() {
        System.out.println("Scrolling Motif ScrollBar");
    }
}
