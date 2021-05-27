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
import java.util.Optional;

public class Consultar extends JFrame{
    private JTextField plate;
    private JButton find;
    private JPanel consultPanel;
    private JTextField brand;
    private JTextField model;
    private JTextField color;
    private JTextField maximumSpeed;
    private JTextField numberOfPistons;
    private JTextField numberOfPassengers;
    private JTextField power;
    private JTextField maximumSpeedReal;
    private JButton RemoveItemForPlate;
    private JButton exit;
    private static Consultar consultar;

    public static Consultar getConsultar(){
        if(consultar == null){
            consultar = new Consultar("Consultar Veiculos de Passageiros");
        }
        return consultar;
    }
    public Consultar(String title){
        super(title);
        this.setContentPane(consultPanel);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.pack();
        disabledButtons();
        disabledFindButton();
        find.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Optional<Passeio> findOrFail = Menu.getDBVehicles().findOrFailPassenger(plate.getText());
                if(findOrFail.isPresent()){
                    JOptionPane.showMessageDialog(null, "Veiculo de passageiros  encontrado");
                    brand.setText(findOrFail.get().getBrand());
                    model.setText(findOrFail.get().getModel());
                    color.setText(findOrFail.get().getColor());
                    maximumSpeed.setText(String.valueOf(findOrFail.get().calcSpeed(findOrFail.get().getMaximumSpeed())));
                    maximumSpeedReal.setText(String.valueOf(findOrFail.get().getMaximumSpeed()));
                    numberOfPistons.setText(String.valueOf(findOrFail.get().getMotor().getNumberOfPistons()));
                    numberOfPassengers.setText(String.valueOf(findOrFail.get().getNumberOfPassengers()));
                    power.setText(String.valueOf(findOrFail.get().getMotor().getPower()));
                }else{
                    JOptionPane.showMessageDialog(null, "Veiculo de passageiros não encontrado");
                    brand.setText("");
                    model.setText("");
                    color.setText("");
                    maximumSpeed.setText("");
                    maximumSpeedReal.setText("");
                    numberOfPistons.setText("");
                    numberOfPassengers.setText("");
                    power.setText("");
                }
            }
        });
        plate.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                disabledFindButton();
            }
        });
        RemoveItemForPlate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Optional<Passeio> findOrFail = Menu.getDBVehicles().findOrFailPassenger(plate.getText());
                if(findOrFail.isPresent()) {
                    if(Menu.getDBVehicles().removePassenger(findOrFail.get())){
                        JOptionPane.showMessageDialog(null,"Removido com sucesso!");
                    }else{
                        JOptionPane.showMessageDialog(null,"Ops! Tente Novamente");
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Não existe!");
                }
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void disabledButtons(){
        brand.setEnabled(false);
        model.setEnabled(false);
        color.setEnabled(false);
        maximumSpeed.setEnabled(false);
        maximumSpeedReal.setEnabled(false);
        numberOfPistons.setEnabled(false);
        numberOfPassengers.setEnabled(false);
        power.setEnabled(false);
    }

    private void disabledFindButton(){
        find.setEnabled(plate.getText().length() >= 1 && Menu.getDBVehicles().countPassengers() >= 1);
        RemoveItemForPlate.setEnabled(plate.getText().length() >= 1 && Menu.getDBVehicles().countPassengers() >= 1);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
