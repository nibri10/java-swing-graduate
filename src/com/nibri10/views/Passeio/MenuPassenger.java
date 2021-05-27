/*
 * Copyright (c) 2021. Todos os direitos reservados.
 */

package com.nibri10.views.Passeio;



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPassenger extends JFrame{
    private JPanel menuPassengerJPanel;
    private JButton newRegistry;
    private JButton consult;
    private JButton printerPassengers;
    private JButton exit;
    private static MenuPassenger instance;

    public static MenuPassenger getInstance() {
        if(instance == null){
            instance = new MenuPassenger("Gestão de Veiculos de Passeio");
        }
        return instance;
    }

    private MenuPassenger(String title){
        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(menuPassengerJPanel);
        this.pack();
        newRegistry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Passenger.getPassenger().setVisible(true);
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        printerPassengers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    PassengerPrinter.getInstance().setVisible(true);
            }
        });
        consult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Consultar.getConsultar().setVisible(true);
            }
        });
    }
}
