package me.erano.com.example3;

public class CarSchemaBuilder implements Builder {

    private int id;
    private int height;
    private String brand;
    private String model;
    private String color;
    private String engine;
    private int nbrOfDoors;

    @Override
    public CarSchemaBuilder id(int id) {
        this.id = id;
        return this;
    }

    @Override
    public CarSchemaBuilder brand(String brand) {
        this.brand = brand;
        return this;
    }

    @Override
    public CarSchemaBuilder model(String model) {
        this.model = model;
        return this;
    }

    @Override
    public CarSchemaBuilder color(String color) {
        this.color = color;
        return this;
    }

    @Override
    public CarSchemaBuilder height(int height) {
        this.height = height;
        return this;
    }

    @Override
    public CarSchemaBuilder engine(String engine) {
        this.engine = engine;
        return this;
    }

    @Override
    public CarSchemaBuilder nbrOfDoors(int nbrOfDoors) {
        this.nbrOfDoors = nbrOfDoors;
        return this;
    }

    public CarSchema build() {
        return new CarSchema(id, brand, model, color, height, engine, nbrOfDoors);
    }

}
