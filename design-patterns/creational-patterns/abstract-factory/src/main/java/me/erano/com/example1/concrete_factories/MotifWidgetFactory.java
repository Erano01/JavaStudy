package me.erano.com.example1.concrete_factories;

import me.erano.com.example1.abstract_factories.WidgetFactory;
import me.erano.com.example1.abstract_products.ScrollBar;
import me.erano.com.example1.abstract_products.Window;
import me.erano.com.example1.concrete_products.MotifScrollBar;
import me.erano.com.example1.concrete_products.MotifWindow;

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