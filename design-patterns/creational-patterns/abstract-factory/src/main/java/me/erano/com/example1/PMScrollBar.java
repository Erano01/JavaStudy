package me.erano.com.example1;

import me.erano.com.example1.abstract_products.ScrollBar;

public class PMScrollBar implements ScrollBar {
    @Override
    public void scroll() {
        System.out.println("Scrolling PM ScrollBar");
    }
}
