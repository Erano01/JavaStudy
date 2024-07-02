package me.erano.com.example1.concrete_factories;

import me.erano.com.example1.PMScrollBar;
import me.erano.com.example1.PMWindow;
import me.erano.com.example1.abstract_factories.WidgetFactory;
import me.erano.com.example1.abstract_products.ScrollBar;
import me.erano.com.example1.abstract_products.Window;

public class PMWidgetFactory implements WidgetFactory {
    @Override
    public Window createWindow() {
        return new PMWindow();
    }

    @Override
    public ScrollBar createScrollBar() {
        return new PMScrollBar();
    }
}
