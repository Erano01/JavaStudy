package me.erano.com.example2.factories;

import me.erano.com.example2.products.Dessert;
import me.erano.com.example2.products.MainCourse;
import me.erano.com.example2.products.NormalDessert;
import me.erano.com.example2.products.NormalMainCourse;
import me.erano.com.example2.products.NormalSoup;
import me.erano.com.example2.products.Soup;

public class NormalMealFactory implements MealFactory {
    public Soup createSoup() {
        return new NormalSoup();
    }
    public MainCourse createMainCourse() {
        return new NormalMainCourse();
    }
    public Dessert createDessert() {
        return new NormalDessert();
    }
}
