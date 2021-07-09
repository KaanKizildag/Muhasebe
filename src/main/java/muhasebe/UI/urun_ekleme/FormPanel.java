/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhasebe.UI.urun_ekleme;

import java.awt.Color;
import javax.swing.JOptionPane;
import muhasebe.UI.ana_panel.table.TableConst;
import muhasebe.UI.pencere.FrameConsts;
import muhasebe.repository.Database;
import muhasebe.entities.UrunIsmi;

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
        tbxProductName = FrameConsts.createTextField();
        jLabel5 = FrameConsts.createLabel();
        tbxPrice = FrameConsts.createTextField();
        jLabel4 = FrameConsts.createLabel();
        jButton1 = FrameConsts.createButton(Color.green, (l) -> {addProduct();});

        setBackground(TableConst.BACKGROUND_COLOR);
        setLayout(new java.awt.GridLayout(3, 2));

        jLabel1.setText("ürün adı");
        jLabel1.setPreferredSize(new java.awt.Dimension(200, 50));
        add(jLabel1);

        tbxProductName.setText("bir şeyler");
        tbxProductName.setPreferredSize(new java.awt.Dimension(200, 50));
        add(tbxProductName);

        jLabel5.setText("ürün fiyatı");
        jLabel5.setPreferredSize(new java.awt.Dimension(200, 50));
        add(jLabel5);

        tbxPrice.setText("ürün fiyatı");
        tbxPrice.setPreferredSize(new java.awt.Dimension(200, 50));
        add(tbxPrice);

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
    private javax.swing.JTextField tbxPrice;
    private javax.swing.JTextField tbxProductName;
    // End of variables declaration//GEN-END:variables

    private void addProduct(){
        String productName = tbxProductName.getText();
        float price = Float.parseFloat(tbxPrice.getText());
        UrunIsmi urun = new UrunIsmi();
        urun.setIsim(productName);
        Database.getInstance().insertProductName(urun);
        JOptionPane.showMessageDialog(null, "Ürün eklendi");
        clearTextFields();
    }

    private void clearTextFields() {
        tbxProductName.setText("");
        tbxPrice.setText("");
    }
    
}
