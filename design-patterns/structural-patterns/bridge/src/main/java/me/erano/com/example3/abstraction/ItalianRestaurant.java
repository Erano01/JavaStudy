package me.erano.com.example3.abstraction;

import me.erano.com.example3.implementator.Pizza;

//Redefined Abstraction
public class ItalianRestaurant extends Restaurant {

    public ItalianRestaurant(Pizza pizza) {
        super(pizza);
    }

    @Override
    public void addToppings() {
        pizza.setToppings("-");
    }

    @Override
    public void addSauce() {
        pizza.setSauce("Oil");
    }

    @Override
    public void makeCrust() {
        pizza.setCrust("Thin");
    }

}
