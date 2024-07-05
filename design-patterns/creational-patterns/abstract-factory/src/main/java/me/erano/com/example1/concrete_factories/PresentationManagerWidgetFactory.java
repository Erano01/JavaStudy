package me.erano.com.example1.concrete_factories;

import me.erano.com.example1.abstract_factories.WidgetFactory;
import me.erano.com.example1.abstract_products.ScrollBar;
import me.erano.com.example1.abstract_products.Window;
import me.erano.com.example1.concrete_products.PresentationManagerScrollBar;
import me.erano.com.example1.concrete_products.PresentationManagerWindow;

public class PresentationManagerWidgetFactory implements WidgetFactory {
    @Override
    public Window createWindow() {
        return new PresentationManagerWindow();
    }

    @Override
    public ScrollBar createScrollBar() {
        return new PresentationManagerScrollBar();
    }
}
