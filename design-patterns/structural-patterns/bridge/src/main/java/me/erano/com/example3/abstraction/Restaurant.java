package me.erano.com.example3.abstraction;

import me.erano.com.example3.implementator.Pizza;

//Abstraction
public abstract class Restaurant {

    protected Pizza pizza;

    protected Restaurant(Pizza pizza) {
        this.pizza = pizza;
    }

    abstract void addSauce();
    abstract void addToppings();
    abstract void makeCrust();

    public void deliver() {
        makeCrust();
        addSauce();
        addToppings();
        pizza.assemble();
        pizza.qualityCheck();
        System.out.println("Order in Progress!");
    }

}
