/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhasebe.UI.pencere;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import muhasebe.UI.ana_panel.table.TableConst;

/**
 *
 * @author kaan
 */
public class FrameConsts {
    public static final int WIDHT = 1000;
    public static final int HEIGHT = 600;

    public static JLabel createLabel(String mesaj) {
        JLabel label = new JLabel(mesaj,JLabel.CENTER);
        label.setFont(TableConst.FONT);
        label.setBackground(TableConst.BACKGROUND_COLOR);
        label.setForeground(TableConst.FOREGROUND_COLOR);
        return label;
    }
    
    public static JTextField createTextField(String mesaj){
        JTextField textField = new JTextField(mesaj);
        textField.setFont(TableConst.FONT);
        textField.setForeground(TableConst.FOREGROUND_COLOR);
        textField.setBackground(TableConst.BACKGROUND_COLOR);
        textField.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                textField.setText("");
            }

            @Override
            public void mousePressed(MouseEvent arg0) {
            }

            @Override
            public void mouseReleased(MouseEvent arg0) {
            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
            }

            @Override
            public void mouseExited(MouseEvent arg0) {
            }
        });
        return textField;
    }
}
