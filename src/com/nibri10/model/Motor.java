/*
 * Copyright (c) 2021. Todos os direitos reservados.
 */

package com.nibri10.model;

public class Motor {

    /**
     * initialize variables
     */
    private int numberOfPistons = 0;
    private int power = 0;

    public int getNumberOfPistons() {
        return numberOfPistons;
    }

    public void setNumberOfPistons(int numberOfPistons) {
        this.numberOfPistons = numberOfPistons;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
