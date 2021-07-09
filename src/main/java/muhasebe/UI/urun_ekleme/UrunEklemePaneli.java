/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhasebe.UI.urun_ekleme;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import muhasebe.UI.ana_panel.product_observer.Observer;
import muhasebe.UI.ana_panel.table.TableConst;
import muhasebe.entities.UrunIsmi;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author kaan
 */
public class UrunEklemePaneli extends JPanel {

//    List<Observer> observers = new ArrayList<>();

    public UrunEklemePaneli() {
        super();
        setBackground(TableConst.BACKGROUND_COLOR);

        add(new FormPanel());

        try {
            ImageIcon icon = new ImageIcon("ikonlar/gear.png");
            System.out.println(icon);
            JLabel label = new JLabel(icon, JLabel.CENTER);
            add(label);
        } catch (Exception e) {
            System.out.println("dosya bulunamadı");
        }

    }

}
