package me.erano.com.example1.factories;

import me.erano.com.example1.products.MotifScrollBar;
import me.erano.com.example1.products.MotifWindow;
import me.erano.com.example1.products.ScrollBar;
import me.erano.com.example1.products.Window;

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