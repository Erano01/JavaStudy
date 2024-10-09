package me.erano.com.example1.factories;

import me.erano.com.example1.products.PMScrollBar;
import me.erano.com.example1.products.PMWindow;
import me.erano.com.example1.products.ScrollBar;
import me.erano.com.example1.products.Window;

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
