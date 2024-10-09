package me.erano.com.example.factories;

import me.erano.com.example.products.ScrollBar;
import me.erano.com.example.products.Window;

//Abstract Factory
public interface WidgetFactory {
    Window createWindow();
    ScrollBar createScrollBar();
}
