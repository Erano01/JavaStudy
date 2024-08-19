package me.erano.com.example2;

import me.erano.com.example2.factories.MealFactory;
import me.erano.com.example2.products.Dessert;
import me.erano.com.example2.products.MainCourse;
import me.erano.com.example2.products.Soup;

public class Restaurant {
    private Soup soup;
    private MainCourse mainCourse;
    private Dessert dessert;

    public Restaurant(MealFactory factory) {
        soup = factory.createSoup();
        mainCourse = factory.createMainCourse();
        dessert = factory.createDessert();
    }

    public void serveMeal() {
        soup.prepare();
        mainCourse.prepare();
        dessert.prepare();
    }

}
