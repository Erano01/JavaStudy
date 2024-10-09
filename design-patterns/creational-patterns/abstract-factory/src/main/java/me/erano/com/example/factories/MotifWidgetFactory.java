package me.erano.com.example.factories;

import me.erano.com.example.products.MotifScrollBar;
import me.erano.com.example.products.MotifWindow;
import me.erano.com.example.products.ScrollBar;
import me.erano.com.example.products.Window;

//Concrete factory.
public class MotifWidgetFactory implements WidgetFactory {
    @Override
    public Window createWindow() {
        return new MotifWindow();
    }

    @Override
    public ScrollBar createScrollBar() {
        return new MotifScrollBar();
    }
}