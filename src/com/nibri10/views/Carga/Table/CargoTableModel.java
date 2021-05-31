/*
 * Copyright (c) 2021. Todos os direitos reservados.
 */

package com.nibri10.views.Carga.Table;

import com.nibri10.model.Carga;



import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class CargoTableModel extends AbstractTableModel {

    private final String[] columns = {
            "Placa",
            "Marca",
            "Modelo",
            "Cor",
            "Velocidade Máxima cm/h",
            "Velocidade Máxima",
            "Número de pistões",
            "Tara",
            "Carga máxima",
            "Potência"
    };
    private final int COLUMN_PLATE = 0;
    private final int COLUMN_BRAND = 1;
    private final int COLUMN_MODEL = 2;
    private final int COLUMN_COLOR = 3;
    private final int COLUMN_MAXIMUM_SPEED_CALCULATE = 4;
    private final int COLUMN_MAXIMUM_SPEED = 5;
    private final int COLUMN_NUMBERS_OF_PISTONS = 6;
    private final int COLUMN_TARA = 7;
    private final int COLUMN_MAXIMUM_WEIGHT = 8;
    private final int COLUMN_POWER = 9;

    private  ArrayList<Carga> cargoArrayList;

    public CargoTableModel(ArrayList<Carga> cargoArrayList) {
        this.cargoArrayList = cargoArrayList;
    }

    @Override
    public int getRowCount() {
        return cargoArrayList.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int index) {
        return columns[index];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Carga cargo = this.cargoArrayList.get(rowIndex);
        switch (columnIndex) {
            case COLUMN_PLATE:
                return cargo.getPlate();
            case COLUMN_BRAND:
                return cargo.getBrand();
            case COLUMN_MODEL:
                return cargo.getModel();
            case COLUMN_COLOR:
                return cargo.getColor();
            case COLUMN_MAXIMUM_SPEED_CALCULATE:
                return cargo.calcSpeed(cargo.getMaximumSpeed());
            case COLUMN_MAXIMUM_SPEED:
                return cargo.getMaximumSpeed();
            case COLUMN_NUMBERS_OF_PISTONS:
                return cargo.getMotor().getNumberOfPistons();
            case COLUMN_TARA:
                return cargo.getTara();
            case COLUMN_MAXIMUM_WEIGHT:
                return cargo.getMaximumWeight();
            case COLUMN_POWER:
                return cargo.getMotor().getPower();

        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case COLUMN_MAXIMUM_SPEED:
            case COLUMN_MAXIMUM_SPEED_CALCULATE:
            case COLUMN_TARA:
            case COLUMN_MAXIMUM_WEIGHT:
                return Float.class;
            case COLUMN_NUMBERS_OF_PISTONS:
            case COLUMN_POWER:
                return Integer.class;
            default:
                return String.class;
        }
    }
}
