/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhasebe.UI.pencere;

import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
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
        JLabel label = createLabel();
        label.setText(mesaj);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(TableConst.FONT);
        label.setBackground(TableConst.BACKGROUND_COLOR);
        label.setForeground(TableConst.FOREGROUND_COLOR);
        return label;
    }

    public static JLabel createLabel() {
        JLabel label = new JLabel();
        label.setFont(TableConst.FONT);
        label.setBackground(TableConst.BACKGROUND_COLOR);
        label.setForeground(TableConst.FOREGROUND_COLOR);
        return label;
    }

    public static JTextField createTextField(String mesaj) {
        JTextField textField = createTextField();
        textField.setText(mesaj);
        return textField;
    }

    public static JTextField createTextField() {
        JTextField textField = new JTextField();
        textField.setFont(TableConst.FONT);
        textField.setForeground(TableConst.FOREGROUND_COLOR);
        textField.setBackground(TableConst.BACKGROUND_COLOR);
        textField.setSize(200, 50);
        textField.setHorizontalAlignment(textField.CENTER);
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
                textField.setBackground(TableConst.HOVER_COLOR);
                textField.setForeground(Color.white);
            }

            @Override
            public void mouseExited(MouseEvent arg0) {
                textField.setBackground(TableConst.BACKGROUND_COLOR);
                textField.setForeground(TableConst.FOREGROUND_COLOR);
            }
        });
        return textField;
    }

    public static JButton createButton(String metin, Color c, ActionListener event) {
        JButton button = createButton(c, event);
        button.setText(metin);
        return button;
    }
    
    public static JButton createButton(Color c, ActionListener event) {
        JButton button = createButton(event);
        button.setBackground(c);
        return button;
    }
    
    
    public static JButton createButton(ActionListener event) {
        JButton button = new JButton("henüz atanmadı");
        button.setFont(TableConst.FONT);
        button.addActionListener(event);
        return button;
    }

}
