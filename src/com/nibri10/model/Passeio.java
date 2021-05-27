/*
 * Copyright (c) 2021. Todos os direitos reservados.
 */

package com.nibri10.model;


import com.nibri10.abst.Veiculo;



public final class Passeio extends Veiculo {

    private int numberOfPassengers;

   
    public Passeio(String plate, String brand,String model, String color, float maximumSpeed, int numberOfPassengers) {
        super(plate, brand, model, color,maximumSpeed);
        this.numberOfPassengers = numberOfPassengers;
    }



    /**
     * @return Integer numberOfPassengers
     */
    public final int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    /**
     * @param numberOfPassengers
     */
    public final void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }


    /**
     * @param maximumSpeed
     * @return maximumSpeed m/h
     */
    @Override
    public final float calcSpeed(float maximumSpeed) {
        return (maximumSpeed * 10000);
    }

    /**
     * @return length for all Strings
     */

    @Override
    public final int calc() {
        return getPlate().length() + getBrand().length() + getModel().length() + getColor().length();
    }



}
