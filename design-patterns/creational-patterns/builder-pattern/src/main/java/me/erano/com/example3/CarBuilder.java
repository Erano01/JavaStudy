package me.erano.com.example3;

public class CarBuilder implements Builder {

    private int id;
    private int height;
    private String brand;
    private String model;
    private String color;
    private String engine;
    private int nbrOfDoors;

    @Override
    public CarBuilder id(int id) {
        this.id = id;
        return this;
    }

    @Override
    public CarBuilder brand(String brand) {
        this.brand = brand;
        return this;
    }

    @Override
    public CarBuilder model(String model) {
        this.model = model;
        return this;
    }

    @Override
    public CarBuilder color(String color) {
        this.color = color;
        return this;
    }

    @Override
    public CarBuilder height(int height) {
        this.height = height;
        return this;
    }

    @Override
    public CarBuilder engine(String engine) {
        this.engine = engine;
        return this;
    }

    @Override
    public CarBuilder nbrOfDoors(int nbrOfDoors) {
        this.nbrOfDoors = nbrOfDoors;
        return this;
    }

    public Car build() {
        return new Car(id, brand, model, color, height, engine, nbrOfDoors);
    }

}