package me.erano.com.example3;


import me.erano.com.example3.products.GPU;
import me.erano.com.example3.products.Monitor;

//Abstract Factory
public abstract class Company {

    public abstract GPU createGpu();

    public abstract Monitor createMonitor();

}