package me.erano.com.example1.concrete_products;

import me.erano.com.example1.abstract_products.ScrollBar;

//gof da yok
public class PresentationManagerScrollBar implements ScrollBar {
    @Override
    public void scroll() {
        System.out.println("Scrolling PM ScrollBar");
    }
}
