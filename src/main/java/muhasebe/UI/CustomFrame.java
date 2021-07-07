/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhasebe.UI;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author kaan
 */
public class CustomFrame extends JFrame {

    public CustomFrame() {
        super();
        setVisible(true);
        setSize(FrameConsts.WIDHT, FrameConsts.HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
        tabbedPane.add("Satış yönetim paneli", MainPane.getInstance());
        add(tabbedPane);
        
    }

}
