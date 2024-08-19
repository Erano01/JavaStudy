package me.erano.com.example2.factories;

import me.erano.com.example2.products.*;

public class VeganMealFactory implements MealFactory {
    public Soup createSoup() {
        return new VeganSoup();
    }
    public MainCourse createMainCourse() {
        return new VeganMainCourse();
    }
    public Dessert createDessert() {
        return new VeganDessert();
    }
}