/*
 * Copyright (c) 2021. Todos os direitos reservados.
 */

package com.nibri10.views.Passeio;

import com.nibri10.views.Menu;
import com.nibri10.views.Passeio.Table.PassengerTableModel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PassengerPrinter extends  JFrame{
    private JPanel panel;
    private JScrollPane scrollPane;
    private JTable table;
    private JButton removeAll;
    private JButton exit;
    private JButton update;
    private static PassengerPrinter passengerPrinter;

    public static PassengerPrinter getInstance(){
        if(passengerPrinter == null){
            passengerPrinter = new PassengerPrinter("Imprimir Veiculos de Passeio");
        }
        return passengerPrinter;
    }

    public PassengerPrinter(String title){
        super(title);

        this.table.setModel(update());
        table.setSize(1000, 600);

        this.setContentPane(panel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        removeAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu.getDBVehicles().removeAllPassenger();
                updateTable();
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTable();
            }
        });
    }

    private PassengerTableModel update(){
        return  new PassengerTableModel(Menu.getDBVehicles().allPassengers());
    }

    private void updateTable(){
        this.table.setModel(update());
    }


}
