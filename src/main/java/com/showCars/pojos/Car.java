package com.showCars.pojos;

public class Car {

    private int id;
    private String model;
    private String color;

    public Car(int id, String model, String color) {
        this.id = id;
        this.model = model;
        this.color = color;
    }

    public Car() {
    }

    public String getModel() {

        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
