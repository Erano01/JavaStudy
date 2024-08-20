package me.erano.com.example1.factories;

import me.erano.com.example1.products.PresentationManagerScrollBar;
import me.erano.com.example1.products.PresentationManagerWindow;
import me.erano.com.example1.products.ScrollBar;
import me.erano.com.example1.products.Window;

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
