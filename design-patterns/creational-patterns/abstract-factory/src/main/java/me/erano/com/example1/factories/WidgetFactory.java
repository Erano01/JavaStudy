package me.erano.com.example1.factories;

import me.erano.com.example1.products.ScrollBar;
import me.erano.com.example1.products.Window;

public interface WidgetFactory {
    Window createWindow();
    ScrollBar createScrollBar();
}