/*
 * Copyright (c) 2021. Todos os direitos reservados.
 */

package com.nibri10.views.Carga;

import com.nibri10.BD.DBVeiculos;
import com.nibri10.model.Carga;
import com.nibri10.views.Menu;

import javax.swing.*;
import java.awt.event.*;
import java.util.Optional;

public class Consult extends JFrame {
    private JTextField plate;
    private JButton find;
    private JPanel consultPanel;
    private JTextField brand;
    private JTextField model;
    private JTextField color;
    private JTextField maximumSpeed;
    private JTextField maximumWeight;
    private JTextField power;
    private JTextField numberOfPistons;
    private JTextField maximumSpeedReal;
    private JButton removeItemForPlate;
    private JButton exit;
    private JTextField maximumWeight2;
    private static Consult consult;


    public static Consult getConsult(){
        if(consult == null ){
            consult = new Consult("Consultar Veiculo Cadastrado");
        }
        return consult;
    }

    public Consult(String title){
        super(title);
        this.setContentPane(consultPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.pack();
        disabledFindButton();
        disabledInputs();

        find.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   Optional <Carga> findOrFail = Menu.getDBVehicles().findOrFailCargo(plate.getText());
                   if(findOrFail.isPresent()){
                       JOptionPane.showMessageDialog(null,"Veiculo de Carga encontrado");
                       brand.setText(findOrFail.get().getBrand());
                       color.setText(findOrFail.get().getColor());
                       model.setText(findOrFail.get().getModel());
                       maximumSpeed.setText(String.valueOf(findOrFail.get().calcSpeed(findOrFail.get().getMaximumSpeed())));
                       maximumSpeedReal.setText(String.valueOf(findOrFail.get().getMaximumSpeed()));
                       maximumWeight.setText(String.valueOf(findOrFail.get().getTara()));
                       maximumWeight2.setText(String.valueOf(findOrFail.get().getMaximumWeight()));
                       numberOfPistons.setText(String.valueOf(findOrFail.get().getMotor().getNumberOfPistons()));
                       power.setText(String.valueOf(findOrFail.get().getMotor().getPower()));
                   }else{
                       JOptionPane.showMessageDialog(null,"Veiculo de Carga não encontrado");
                       brand.setText("");
                       color.setText("");
                       model.setText("");
                       maximumSpeed.setText("");
                       maximumSpeedReal.setText("");
                       maximumWeight.setText("");
                       maximumWeight2.setText("");
                       numberOfPistons.setText("");
                       power.setText("");
                   }
            }
        });
        plate.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                disabledFindButton();
            }
        });
        removeItemForPlate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Optional <Carga> findOrFail = Menu.getDBVehicles().findOrFailCargo(plate.getText());
                if(findOrFail.isPresent()){
                    if(Menu.getDBVehicles().removeCargo(findOrFail.get())){
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



    private void disabledInputs(){
        brand.setEnabled(false);
        color.setEnabled(false);
        maximumSpeed.setEnabled(false);
        maximumSpeedReal.setEnabled(false);
        maximumWeight.setEnabled(false);
        model.setEnabled(false);
        numberOfPistons.setEnabled(false);
        power.setEnabled(false);
    }

    private void disabledFindButton(){
        find.setEnabled(plate.getText().length() >= 1 && Menu.getDBVehicles().countCargo() >= 1);
        removeItemForPlate.setEnabled(plate.getText().length() >= 1 && Menu.getDBVehicles().countCargo() >= 1);
    }


}
