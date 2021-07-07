/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhasebe.UI.table;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kaan
 */
public class CustomTable extends JTable {

    private static CustomTable INSTANCE;

    public static CustomTable getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CustomTable();
        }

        return INSTANCE;
    }

    private CustomTable() {
        super();
        setModel(new DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null}
                },
                new String[]{
                    "#", "isim", "teslimat noktasi", "Henüz girilmedi", "adet", "birim fiyat", "tutar", "ürün adı"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.Integer.class,
                java.lang.String.class,
                java.lang.String.class,
                java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                true, true, true, true, true, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        if (this.getColumnModel().getColumnCount() > 0) {

            this.getColumnModel().getColumn(7).setCellEditor(new MyComboBoxEditor());
            this.getColumnModel().getColumn(7).setCellRenderer(new MyTextBoxRenderer());
        }

        setRowHeight(32);
        setBackground(TableConst.BACKGROUND_COLOR);
        setFont(TableConst.FONT);
        setForeground(TableConst.FOREGROUND_COLOR);
    }

    public void addRow(
            int id, String name, String address, String productName,
            float quantity, float price) {
        DefaultTableModel model = (DefaultTableModel) this.getModel();
        model.addRow(new Object[]{id, name, address, productName, 15, price, 0});
        setModel(model);
    }

}
