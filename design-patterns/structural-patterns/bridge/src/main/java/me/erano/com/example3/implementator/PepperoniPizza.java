package me.erano.com.example3.implementator;

//concrete implementator
public class PepperoniPizza extends Pizza {

    @Override
    public void assemble() {
        System.out.println("Adding Sauce: " + sauce);
        System.out.println("Adding Toppings: " + toppings);
        System.out.println("Adding Pepperoni");
    }

    @Override
    public void qualityCheck() {
        System.out.println("Crust is: " + crust);
    }

}
