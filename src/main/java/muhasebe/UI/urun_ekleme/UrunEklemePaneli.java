/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhasebe.UI.urun_ekleme;

import java.awt.Color;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import muhasebe.UI.ana_panel.product_observer.Observer;
import muhasebe.UI.ana_panel.table.TableConst;
import muhasebe.entities.UrunIsmi;
import muhasebe.repository.Database;
import java.util.ArrayList;
import muhasebe.UI.pencere.FrameConsts;

/**
 *
 * @author kaan
 */
public class UrunEklemePaneli extends JPanel {

    List<Observer> observers = new ArrayList<>();

    public UrunEklemePaneli() {
        super();
        setBackground(TableConst.BACKGROUND_COLOR);
        JLabel label = FrameConsts.createLabel("Ürün adı giriniz:");
        add(label);

        JTextField textField = FrameConsts.createTextField("ürün adı giriniz.");
        
        add(textField);

        JButton button = new JButton("Ekle");
        button.setBackground(Color.green);
        button.addActionListener((arg0) -> {
            UrunIsmi urun = new UrunIsmi();
            urun.setIsim(textField.getText());
            Database.getInstance().insertProductName(urun);
            System.out.println(textField.getText() + " başarıyla eklendi");
        });

        add(button);
    }

    
}
