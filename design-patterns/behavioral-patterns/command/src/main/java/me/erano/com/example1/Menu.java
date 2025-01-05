package me.erano.com.example1;

import java.util.List;
import java.util.ArrayList;

public class Menu {

    private List<MenuItem> menuItems = new ArrayList<>();

    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }

    public void showMenu() {
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i + 1) + ". " + menuItems.get(i).getName());
        }
    }

    public void select(int index) {
        if (index < 1 || index > menuItems.size()) {
            System.out.println("Invalid menu selection");
            return;
        }
        menuItems.get(index - 1).click();
    }
}
