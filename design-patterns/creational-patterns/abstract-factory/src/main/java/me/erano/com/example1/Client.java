package me.erano.com.example1;

import me.erano.com.example1.factories.WidgetFactory;
import me.erano.com.example1.products.ScrollBar;
import me.erano.com.example1.products.Window;

public class Client {
    private Window window;
    private ScrollBar scrollBar;

    public Client(WidgetFactory factory) {
        this.window = factory.createWindow();
        this.scrollBar = factory.createScrollBar();
    }

    public void renderUI() {
        window.render();
        scrollBar.scroll();
    }
}
