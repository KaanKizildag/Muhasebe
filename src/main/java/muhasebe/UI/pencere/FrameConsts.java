/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhasebe.UI.pencere;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import muhasebe.UI.ana_panel.table.TableConst;

/**
 *
 * @author kaan
 */
public class FrameConsts {
    public static final int WIDHT = 1000;
    public static final int HEIGHT = 600;

    public static JLabel createLabel(String hoşgeldiniz, Color white) {
        JLabel label = new JLabel("hoşgeldiniz");
        label.setFont(TableConst.FONT);
        label.setBackground(TableConst.BACKGROUND_COLOR);
        label.setForeground(TableConst.FOREGROUND_COLOR);
        return label;
    }
}
