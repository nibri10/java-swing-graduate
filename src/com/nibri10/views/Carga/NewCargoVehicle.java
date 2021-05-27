/*
 * Copyright (c) 2021. Todos os direitos reservados.
 */

package com.nibri10.views.Carga;

import com.nibri10.BD.DBVeiculos;
import com.nibri10.model.Carga;
import com.nibri10.model.Passeio;
import com.nibri10.views.Menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NewCargoVehicle extends JFrame {
    private JPanel newCargoVehicleJPanel;
    private JTextField plate;
    private JTextField model;
    private JTextField color;
    private JTextField maximumSpeed;
    private JTextField numberOfPistons;
    private JTextField maximumWeight;
    private JButton exit;
    private JButton clear;
    private JButton save;
    private JTextField brand;
    private JTextField power;
    private static NewCargoVehicle newCargoVehicleFrame;


    public static NewCargoVehicle getNewCargoVehicle(){
        if(newCargoVehicleFrame == null ){
            newCargoVehicleFrame = new NewCargoVehicle("Cadastrar Veiculo de carga");
        }
        return newCargoVehicleFrame;
    }

    private NewCargoVehicle(String title){
        this.setTitle(title);
        this.setContentPane(newCargoVehicleJPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.checkEnabledSaveButtonCargo();
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
        maximumSpeed.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                try {
                    Long.parseLong(maximumSpeed.getText());
                    checkEnabledSaveButtonCargo();
                } catch (NumberFormatException nfe) {
                    maximumSpeed.setText("");
                }
            }
        });
        maximumWeight.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                try {
                    Long.parseLong(maximumWeight.getText());
                    checkEnabledSaveButtonCargo();
                } catch (NumberFormatException nfe) {
                    maximumWeight.setText("");
                }

            }
        });
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(plate.getText().length() > 1) {
                    if (Menu.getDBVehicles().allPassengers().size() > 0 && Menu.getDBVehicles().findOrFailCargo(plate.getText()).isPresent()) {
                        JOptionPane.showMessageDialog(null, "Placa já está sendo utilizada!");
                    } else {
                        addCargoScreen();
                    }
                }
            }
        });
        power.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                try {
                    Long.parseLong(power.getText());
                    checkEnabledSaveButtonCargo();
                } catch (NumberFormatException nfe) {
                    power.setText("");
                }

            }
        });

        numberOfPistons.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                try {
                    Long.parseLong(numberOfPistons.getText());
                    checkEnabledSaveButtonCargo();
                } catch (NumberFormatException nfe) {
                    numberOfPistons.setText("");
                }

            }
        });

    }

    private void addCargoScreen(){
        float maximumSpeedCast = Float.parseFloat(maximumSpeed.getText());
        int numberOfPistonsCast = Integer.parseInt(numberOfPistons.getText());
        float maximumWeightCast = Float.parseFloat(maximumWeight.getText());
        int powerCast = Integer.parseInt(power.getText());
        Carga carga = new Carga(plate.getText(), brand.getText(), model.getText(), color.getText(),maximumWeightCast, maximumSpeedCast);
        carga.getMotor().setNumberOfPistons(numberOfPistonsCast);
        carga.getMotor().setPower(powerCast);
        if (Menu.getDBVehicles().addCargo(carga)) {
            JOptionPane.showMessageDialog(null, "Veiculo Salvo com sucesso");

        } else {
            JOptionPane.showMessageDialog(null, "Ocorreu um problema ao salvar tente novamente");
        }
    }

    private void checkEnabledSaveButtonCargo(){
        save.setEnabled(
                plate.getText().length() >= 1
                        && brand.getText().length() >= 1
                        && color.getText().length() >= 1
                        && maximumSpeed.getText().length() >= 1
                        && numberOfPistons.getText().length() >= 1
                        && power.getText().length() >= 1
                        && maximumWeight.getText().length() >= 1
        );
    }

    private void clearInputs(){
        plate.setText("");
        model.setText("");
        color.setText("");
        maximumSpeed.setText("");
        numberOfPistons.setText("");
        maximumWeight.setText("");
        brand.setText("");
        power.setText("");
        checkEnabledSaveButtonCargo();
    }

}
