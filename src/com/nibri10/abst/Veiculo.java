/*
 * Copyright (c) 2021. Todos os direitos reservados.
 */

package com.nibri10.abst;



import com.nibri10.model.Motor;

public abstract class Veiculo {
    private String plate = null;
    private String brand = null;
    private String model = null;
    private String color = null;
    private float maximumSpeed = 0;
    Motor motor;

    public Veiculo(String plate, String brand, String model, String color,float maximumSpeed) {
        this.plate = plate;
        this.brand = brand;
        this.model = model;
        this.maximumSpeed = maximumSpeed;
        this.color = color;
        this.motor = new Motor();
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

    public float getMaximumSpeed() {
        return maximumSpeed;
    }

    public void setMaximumSpeed(float maximumSpeed) {
        this.maximumSpeed = maximumSpeed;
    }

    public Motor getMotor() {
        return motor;
    }

    public final void setMotor(Motor motor) {
        this.motor = motor;
    }

    public abstract float calcSpeed(float maximumSpeed);

    public abstract int calc();



}
