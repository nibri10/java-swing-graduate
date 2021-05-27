/*
 * Copyright (c) 2021. Todos os direitos reservados.
 */

package com.nibri10.views.Passeio.Table;

import com.nibri10.model.Passeio;
import com.nibri10.views.Passeio.Passenger;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class PassengerTableModel extends AbstractTableModel {

    private final String[] columns = {
            "Placa",
            "Marca",
            "Modelo",
            "Cor",
            "Velocidade Máxima m/h",
            "Velocidade Máxima",
            "Número de pistões",
            "Número de passageiros",
            "Potência"
    };
    private final int COLUMN_PLATE = 0;
    private final int COLUMN_BRAND = 1;
    private final int COLUMN_MODEL = 2;
    private final int COLUMN_COLOR = 3;
    private final int COLUMN_MAXIMUM_SPEED_CALCULATE = 4;
    private final int COLUMN_MAXIMUM_SPEED = 5;
    private final int COLUMN_NUMBERS_OF_PISTONS = 6;
    private final int COLUMN_NUMBERS_OF_PASSENGERS = 7;
    private final int COLUMN_POWER = 8;

    private ArrayList<Passeio> passengers;

    public PassengerTableModel(ArrayList<Passeio> passengers) {
        this.passengers = passengers;
    }


    @Override
    public int getRowCount() {
        return passengers.size();
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
        Passeio passenger = this.passengers.get(rowIndex);

        switch (columnIndex) {
            case COLUMN_PLATE:
                return passenger.getPlate();
            case COLUMN_BRAND:
                return passenger.getBrand();
            case COLUMN_MODEL:
                return passenger.getModel();
            case COLUMN_COLOR:
                return passenger.getColor();
            case COLUMN_MAXIMUM_SPEED_CALCULATE:
                return passenger.calcSpeed(passenger.getMaximumSpeed());
            case COLUMN_MAXIMUM_SPEED:
                return passenger.getMaximumSpeed();
            case COLUMN_NUMBERS_OF_PASSENGERS:
                return passenger.getNumberOfPassengers();
            case COLUMN_NUMBERS_OF_PISTONS:
                return passenger.getMotor().getNumberOfPistons();
            case COLUMN_POWER:
                return passenger.getMotor().getPower();

        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case COLUMN_MAXIMUM_SPEED:
            case COLUMN_MAXIMUM_SPEED_CALCULATE:
                return Float.class;
            case COLUMN_NUMBERS_OF_PASSENGERS:
            case COLUMN_NUMBERS_OF_PISTONS:
            case COLUMN_POWER:
                return Integer.class;
            default:
                return String.class;
        }
    }
}
