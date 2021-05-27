/*
 * Copyright (c) 2021. Todos os direitos reservados.
 */

package com.nibri10.model;

import com.nibri10.abst.Veiculo;



/**
 *
 */
public final class Carga extends Veiculo {
    private float tara = 0;


    /**
     * @param plate
     * @param brand
     * @param model
     * @param color
     * @param tara
     * @param maximumSpeed
     */
    public Carga(String plate, String brand,String model, String color, float tara, float maximumSpeed) {
        super(plate, brand, model, color, maximumSpeed);
        this.tara = tara;
    }

    /**
     * @return tara
     */
    public final float getTara() {
        return tara;
    }

    /**
     * @param tara
     */
    public final void setTara(float tara) {
        this.tara = tara;
    }

    /**
     * @param maximumSpeed
     * @return maximumSpeed cm/h
     */
    @Override
    public final float calcSpeed(float maximumSpeed) {
        return (maximumSpeed * 100000);
    }

    /**
     * @return length for all Strings
     */

    @Override
    public final int calc() {
        return getPlate().length() + getBrand().length() + getModel().length() + getColor().length();
    }

}
