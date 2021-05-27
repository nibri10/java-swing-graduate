/*
 * Copyright (c) 2021. Todos os direitos reservados.
 */

package com.nibri10.views.Carga;



import com.nibri10.BD.DBVeiculos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuCargo extends JFrame{
    private JButton addNewCargo;
    private JPanel panel1;
    private JButton consultCargoAndDelete;
    private JButton printerCargos;
    private JButton exit;
    private static MenuCargo menuCargo;


    public static MenuCargo getMenuCargo() {
        if(menuCargo == null){
            menuCargo = new MenuCargo("Gestao de Veiculos de Carga");
        }
        return menuCargo;
    }

    public MenuCargo(String title){
        super(title);
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        addNewCargo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewCargoVehicle.getNewCargoVehicle().setVisible(true);
            }

        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        consultCargoAndDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Consult.getConsult().setVisible(true);
            }
        });
        printerCargos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PrinterCargo.getInstance().setVisible(true);
            }
        });
    }

}
