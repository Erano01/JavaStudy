package me.erano.com.example2.factories;

import me.erano.com.example2.products.Dessert;
import me.erano.com.example2.products.MainCourse;
import me.erano.com.example2.products.Soup;

public interface MealFactory {
    Soup createSoup();
    MainCourse createMainCourse();
    Dessert createDessert();
}
