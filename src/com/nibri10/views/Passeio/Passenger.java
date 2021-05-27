/*
 * Copyright (c) 2021. Todos os direitos reservados.
 */

package com.nibri10.views.Passeio;

import com.nibri10.model.Passeio;
import com.nibri10.views.Menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Passenger extends JFrame {
    private JPanel passengerPanel;
    private JTextField plate;
    private JTextField brand;
    private JTextField model;
    private JTextField color;
    private JTextField maximumSpeed;
    private JTextField numberOfPistons;
    private JTextField numberOfPassengers;
    private JTextField power;
    private JButton exit;
    private JButton save;
    private JButton clear;
    private static Passenger passenger;

    public static Passenger getPassenger() {
        if(passenger == null){
            passenger = new Passenger("Cadastrar Veiculo de Passeio");
        }
        return passenger;
    }



    private Passenger(String title) {
        this.setTitle(title);
        this.setContentPane(passengerPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.checkEnabledSaveButton();
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(plate.getText().length() >= 1) {
                    System.out.println(plate.getText());
                        if(Menu.getDBVehicles().allPassengers().size() > 0 && Menu.getDBVehicles().findOrFailPassenger(plate.getText()).isPresent()){
                        JOptionPane.showMessageDialog(null, "Placa já está sendo utilizada!");
                        }else{
                            addPassengerScreen();
                        }
                }
            }
        });
        maximumSpeed.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                try {
                  Long.parseLong(maximumSpeed.getText());

                } catch (NumberFormatException nfe) {
                    maximumSpeed.setText("");
                }
                checkEnabledSaveButton();
            }
        });
        numberOfPistons.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                try {
                     Long.parseLong(numberOfPistons.getText());
                    checkEnabledSaveButton();
                } catch (NumberFormatException nfe) {
                    numberOfPistons.setText("");
                }
            }
        });
        numberOfPassengers.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                try {

                     Long.parseLong(numberOfPassengers.getText());

                } catch (NumberFormatException nfe) {
                    numberOfPassengers.setText("");
                }
                checkEnabledSaveButton();
            }
        });
        power.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                try {

                    Long.parseLong(power.getText());

                } catch (NumberFormatException nfe) {
                    power.setText("");
                }
                checkEnabledSaveButton();
            }
        });
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearInputs();
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

    }

    private void checkEnabledSaveButton(){
        save.setEnabled(
                plate.getText().length() >= 1
                && brand.getText().length() >= 1
                && color.getText().length() >= 1
                && maximumSpeed.getText().length() >= 1
                && numberOfPassengers.getText().length() >= 1
                && numberOfPistons.getText().length() >= 1
                && power.getText().length() >= 1
        );
    }

    private void addPassengerScreen(){
        float maximumSpeedCast = Float.parseFloat(maximumSpeed.getText());
        int numberOfPassengersCast = Integer.parseInt(numberOfPassengers.getText());
        int numberOfPistonsCast = Integer.parseInt(numberOfPistons.getText());
        int powerCast = Integer.parseInt(power.getText());
        Passeio passeio = new Passeio(plate.getText(), brand.getText(), model.getText(), color.getText(), maximumSpeedCast, numberOfPassengersCast);
        passeio.getMotor().setNumberOfPistons(numberOfPistonsCast);
        passeio.getMotor().setPower(powerCast);
        if (Menu.getDBVehicles().addPassengers(passeio)) {
            JOptionPane.showMessageDialog(null, "Veiculo Salvo com sucesso");
            clearInputs();
        } else {
            JOptionPane.showMessageDialog(null, "Ocorreu um problema ao salvar tente novamente");
        }
    }

    private void clearInputs(){
        plate.setText("");
        brand.setText("");
        model.setText("");
        color.setText("");
        power.setText("");
        maximumSpeed.setText("");
        numberOfPassengers.setText("");
        numberOfPistons.setText("");
        checkEnabledSaveButton();
    }

}