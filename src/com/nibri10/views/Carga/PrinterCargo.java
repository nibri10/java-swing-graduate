/*
 * Copyright (c) 2021. Todos os direitos reservados.
 */

package com.nibri10.views.Carga;

import com.nibri10.views.Carga.Table.CargoTableModel;
import com.nibri10.views.Menu;



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrinterCargo extends JFrame{
    private JPanel panel;
    private JScrollPane scrollPanel;
    private JTable table;
    private JButton removeAll;
    private JButton exit;
    private static PrinterCargo printerCargo;

    public static PrinterCargo getInstance(){
       if(printerCargo == null) {
           printerCargo = new PrinterCargo("Imprimir Veiculos de Carga");
       }
       return printerCargo;
    }

    public PrinterCargo(String title){
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
                Menu.getDBVehicles().removeAllCargo();
                updateTable();
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private CargoTableModel update(){
        return  new CargoTableModel(Menu.getDBVehicles().allCargos());
    }

    private void updateTable(){
        this.table.setModel(update());
    }
}
