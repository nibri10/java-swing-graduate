/*
 * Copyright (c) 2021. Todos os direitos reservados.
 */

package com.nibri10.views;

import com.nibri10.BD.DBVeiculos;
import com.nibri10.views.Carga.MenuCargo;
import com.nibri10.views.Passeio.MenuPassenger;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame{
    private JButton createPasseio;
    private JButton createCarga;
    private JPanel jpanelMain;
    private JButton exit;
    private static DBVeiculos dbVeiculos;

    public static DBVeiculos getDBVehicles(){
        if(dbVeiculos == null){
            dbVeiculos = new DBVeiculos();
        }
        return dbVeiculos;
    }

    public Menu(String title) {
        super(title);
        this.setContentPane(jpanelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        createPasseio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               MenuPassenger.getInstance().setVisible(true);
            }
        });
        createCarga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              MenuCargo.getMenuCargo().setVisible(true);
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
    }
}
