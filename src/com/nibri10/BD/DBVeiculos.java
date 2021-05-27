/*
 * Copyright (c) 2021. Todos os direitos reservados.
 */

package com.nibri10.BD;

import com.nibri10.model.Carga;
import com.nibri10.model.Passeio;

import java.util.ArrayList;
import java.util.Optional;

public class DBVeiculos {

    ArrayList<Passeio> passengers = new ArrayList<>();
    ArrayList<Carga> cargos = new ArrayList<>();

    public boolean addCargo(Carga carga) {
       return cargos.add(carga);
    }

    public boolean addPassengers(Passeio passeio) {
        return passengers.add(passeio);
    }


    public Optional<Carga> findOrFailCargo(String plate) {
        return cargos.stream().filter(carga -> carga.getPlate().equalsIgnoreCase(plate)).findFirst();
    }

    public Optional<Passeio> findOrFailPassenger(String plate) {
        return passengers.stream().filter(passenger -> passenger.getPlate().equalsIgnoreCase(plate)).findFirst();
    }

    public ArrayList<Carga> allCargos() {
       return cargos;
    }

    public ArrayList<Passeio> allPassengers(){
        return passengers;
    }

    public int countPassengers(){
        return passengers.size();
    }

    public int countCargo(){
        return cargos.size();
    }

    public boolean removePassenger(Passeio passeio){
        return passengers.remove(passeio);
    }

    public boolean removeCargo(Carga carga){
        return cargos.remove(carga);
    }

    public boolean removeAllPassenger(){
        return  passengers.removeAll(passengers);
    }

    public boolean removeAllCargo(){
        return  cargos.removeAll(cargos);
    }

}
