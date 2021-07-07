/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhasebe.UI.musteri_paneli;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import muhasebe.UI.ana_panel.table.TableConst;
import muhasebe.repository.Database;

/**
 *
 * @author kaan
 */
public class CustomMusteriTable extends JTable {

    public CustomMusteriTable() {
        setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "#", "Müşteri adı", "Teslimat noktası", "Ürün adı", "Adet", "Birim fiyat", "Toplam tutar"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        setRowHeight(32);
        setBackground(TableConst.BACKGROUND_COLOR);
        setFont(TableConst.FONT);
        setForeground(TableConst.FOREGROUND_COLOR);

        new Thread(() -> {
            loadItems();
        }).start();
    }

    private void loadItems() {

        Database.getInstance().getProducts().forEach((product) -> {
            addRow(product.getId(), product.getMusteri().getIsim(),
                    product.getMusteri().getTeslimatNoktasi(),
                    product.getIsim(),
                    product.getAdet(), product.getFiyat());
        });

    }

    private void addRow(int id, String customerName, String address,
            String productName, int quantity, float price) {
        DefaultTableModel model = (DefaultTableModel) getModel();

        model.addRow(
                new Object[]{id, customerName, address, productName, quantity, price});

        setModel(model);
    }

}
