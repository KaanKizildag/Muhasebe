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

/**
 *
 * @author kaan
 */
public class UrunEklemePaneli extends JPanel {

    List<Observer> observers = new ArrayList<>();

    public UrunEklemePaneli() {
        super();
        setBackground(TableConst.BACKGROUND_COLOR);
        JLabel label = new JLabel("Ürün adı: ");

        label.setFont(TableConst.FONT);
        label.setForeground(TableConst.FOREGROUND_COLOR);
        label.setBackground(TableConst.BACKGROUND_COLOR);

        add(label);

        JTextField textField = new JTextField("Ürün adı giriniz");
        textField.setFont(TableConst.FONT);
        textField.setForeground(TableConst.FOREGROUND_COLOR);
        textField.setBackground(TableConst.BACKGROUND_COLOR);
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
