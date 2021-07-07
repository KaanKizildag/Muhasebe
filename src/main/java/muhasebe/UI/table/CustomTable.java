/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhasebe.UI.table;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import muhasebe.service.concretes.CustomerServiceImpl;

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
                new Object[][]{},
                new String[]{
                    "#",
                    "isim",
                    "teslimat noktası",
                    "önceki kalan",
                    "adet",
                    "birim fiyat",
                    "tutar",
                    "havale",
                    "tahsilat",
                    "ürün adı"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, // #
                java.lang.String.class, // isim
                java.lang.String.class, // teslimat noktası
                java.lang.Float.class, // önceki kalan
                java.lang.Integer.class, // adet
                java.lang.Float.class, // birim fiyat
                java.lang.Float.class, // tutar
                java.lang.Float.class, // havale
                java.lang.Float.class, // tahsilat
                java.lang.String.class // ürün adı
            };
            boolean[] canEdit = new boolean[]{
                true, true, true, true, true, true, true, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        if (this.getColumnModel().getColumnCount() > 0) {

            this.getColumnModel().getColumn(9).setCellEditor(new MyComboBoxEditor());
            this.getColumnModel().getColumn(9).setCellRenderer(new MyTextBoxRenderer());
        }

        setRowHeight(32);
        setBackground(TableConst.BACKGROUND_COLOR);
        setFont(TableConst.FONT);
        setForeground(TableConst.FOREGROUND_COLOR);
        new Thread(() -> {
            loadData();
        }).start();
    }

    private void addRow(
            int id, String name, String address, float oncekiKalan,
            float quantity, float price) {
        DefaultTableModel model = (DefaultTableModel) this.getModel();
        model.addRow(new Object[]{id, name, address, oncekiKalan, null, null, null, null, null});
        setModel(model);
    }

    private void loadData() {
        CustomerServiceImpl.getInstance().getAll().forEach((customer) -> {
            addRow(customer.getId(),
                    customer.getIsim(),
                    customer.getTeslimatNoktasi(),
                    customer.getOncekiKalan(),
                    0,
                    0);
        });

    }
}
