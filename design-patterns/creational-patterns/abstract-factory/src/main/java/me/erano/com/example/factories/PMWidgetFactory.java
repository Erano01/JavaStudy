package me.erano.com.example.factories;

import me.erano.com.example.products.PMScrollBar;
import me.erano.com.example.products.PMWindow;
import me.erano.com.example.products.ScrollBar;
import me.erano.com.example.products.Window;

//Concrete Factory.
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
