/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhasebe.UI.ana_panel;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import muhasebe.UI.ana_panel.table.CustomTable;
import muhasebe.UI.ana_panel.table.TableConst;

/**
 *
 * @author kaan
 */
public final class AltPanel extends JPanel {

    public AltPanel() {
        super();
        setBackground(Color.lightGray);
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        // functional interfaceler bu şekilde kullanılabilir.
        add(createButton("buton adı", Color.BLACK, (e) -> {
            System.out.println("merhaba dünya");
        }));
        add(createButton("değişiklikleri kaydet", Color.green, (e) -> {
            CustomTable.getInstance().saveToDatabase();
            System.out.println("değişiklikler kaydedildi");
        }));
        add(createButton("Tabloyu güncelle", Color.red, (e) -> {

            if (JOptionPane.showConfirmDialog(this, "tablo güncellenecek", "Güncelleme", JOptionPane.OK_CANCEL_OPTION) == 0) {
                CustomTable.getInstance().updateTable();
                System.out.println("Tablo güncellendi");
                JOptionPane.showMessageDialog(this, "Tablo başarıyla güncellendi");
            }

        }));
    }

    JButton createButton(String name, Color c, CustomFunctionalInterface gorev) {
        JButton button = new JButton(name);
        button.setBackground(c);
        button.setFont(TableConst.FONT);
        add(button);
        button.addActionListener(gorev);
        return button;
    }

}
