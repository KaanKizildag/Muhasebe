/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhasebe.UI.pencere;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import muhasebe.UI.ana_panel.MainPane;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import muhasebe.UI.giris_paneli.GirisPaneli;
import muhasebe.UI.musteri_paneli.MusteriPanel;
import muhasebe.UI.urun_ekleme.UrunEklemePaneli;

/**
 *
 * @author kaan
 */
public class CustomFrame extends JFrame {

    public CustomFrame() {
        super();
        setVisible(true);
        setLayout(new BorderLayout());
        setTitle("Ön Muhasebe");
        setSize(FrameConsts.WIDHT, FrameConsts.HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBackground(Color.darkGray);
        tabbedPane.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 18));
        tabbedPane.add("Giriş paneli",new GirisPaneli());

        new Thread(() -> {
            tabbedPane.add("Satışlar paneli", MusteriPanel.getInstance());
        }).start();

        new Thread(() -> {
            tabbedPane.add("Satış yönetim paneli", MainPane.getInstance());
        }).start();

        new Thread(() -> {
            tabbedPane.add("Ürün ekleme paneli", new UrunEklemePaneli());
        }).start();

        add(tabbedPane, BorderLayout.CENTER);

    }

}
