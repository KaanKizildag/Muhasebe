/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhasebe.UI.urun_ekleme;

import java.awt.Color;
import muhasebe.UI.ana_panel.table.TableConst;
import muhasebe.UI.pencere.FrameConsts;

/**
 *
 * @author kaan
 */
public class FormPanel extends javax.swing.JPanel {

    /**
     * Creates new form FormPanel
     */
    public FormPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = FrameConsts.createLabel();
        jTextField1 = FrameConsts.createTextField();
        jLabel5 = FrameConsts.createLabel();
        jTextField3 = FrameConsts.createTextField();
        jLabel4 = FrameConsts.createLabel();
        jButton1 = FrameConsts.createButton(Color.green, (l) -> {System.out.println("veri tabanına kaydedildi");});

        setBackground(TableConst.BACKGROUND_COLOR);
        setLayout(new java.awt.GridLayout(3, 2));

        jLabel1.setText("ürün adı");
        jLabel1.setPreferredSize(new java.awt.Dimension(200, 50));
        add(jLabel1);

        jTextField1.setText("bir şeyler");
        jTextField1.setPreferredSize(new java.awt.Dimension(200, 50));
        add(jTextField1);

        jLabel5.setText("ürün fiyatı");
        jLabel5.setPreferredSize(new java.awt.Dimension(200, 50));
        add(jLabel5);

        jTextField3.setText("ürün fiyatı");
        jTextField3.setPreferredSize(new java.awt.Dimension(200, 50));
        add(jTextField3);

        jLabel4.setText("Kaydet");
        jLabel4.setPreferredSize(new java.awt.Dimension(200, 50));
        add(jLabel4);

        jButton1.setText("Ekle");
        add(jButton1);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
