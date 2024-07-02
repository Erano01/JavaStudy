package me.erano.com.example1.abstract_factories;

import me.erano.com.example1.abstract_products.ScrollBar;
import me.erano.com.example1.abstract_products.Window;

// WidgetFactory is 
public interface WidgetFactory {
    Window createWindow();
    ScrollBar createScrollBar();
}
