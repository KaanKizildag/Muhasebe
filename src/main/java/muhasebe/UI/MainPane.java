/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhasebe.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import muhasebe.UI.table.CustomTable;

/**
 *
 * @author kaan
 */
public class MainPane extends JPanel {

    private static MainPane INSTANCE;

    private MainPane() {
        super();
        setLayout(new BorderLayout());
        JScrollPane pane = new JScrollPane(CustomTable.getInstance());
        pane.setBackground(Color.darkGray);
        setSize(FrameConsts.WIDHT, FrameConsts.HEIGHT);
        pane.setSize(this.getSize());
        add(pane,BorderLayout.CENTER);
        JButton button = new JButton("Ekle");
        button.setSize(150,50);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                CustomTable.getInstance().addRow(1, "Kaan", "Kahramanmaş", "marul", 15, 156);
            }
        });
        add(button,BorderLayout.WEST);
        setBackground(Color.BLACK);
    }

    public static MainPane getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MainPane();
        }
        return INSTANCE;
    }

}
