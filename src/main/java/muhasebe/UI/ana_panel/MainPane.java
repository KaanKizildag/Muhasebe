/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhasebe.UI.ana_panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import muhasebe.UI.pencere.FrameConsts;
import muhasebe.UI.ana_panel.table.CustomTable;

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
        
        
        add(new AltPanel(), BorderLayout.SOUTH);
        
        
        setBackground(Color.BLACK);
    }

    public static MainPane getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MainPane();
        }
        return INSTANCE;
    }

}
