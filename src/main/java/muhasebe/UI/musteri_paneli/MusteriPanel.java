/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhasebe.UI.musteri_paneli;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author kaan
 */
public class MusteriPanel extends JPanel {

    private static MusteriPanel INSTANCE;

    private MusteriPanel() {
        super();
        setLayout(new BorderLayout());
        add(new JScrollPane(new CustomMusteriTable()), BorderLayout.CENTER);
    }

    public static MusteriPanel getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MusteriPanel();
        }
        return INSTANCE;
    }
}
