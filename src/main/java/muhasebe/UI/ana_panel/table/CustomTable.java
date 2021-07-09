/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhasebe.UI.ana_panel.table;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import muhasebe.entities.Urun;
import muhasebe.repository.Database;
import muhasebe.service.concretes.CustomerServiceImpl;

/**
 *
 * @author kaan
 */
public class CustomTable extends JTable {

    private final int COL_ID = 0;
    private final int COL_ISIM = 1;
    private final int COL_TESLIMAT_NOKTASI = 2;
    private final int COL_ONCEKI_KALAN = 3;
    private final int COL_ADET = 4;
    private final int COL_BIRIM_FIYATI = 5;
    private final int COL_TUTAR = 6;
    private final int COL_HAVALE = 7;
    private final int COL_TAHSILAT = 8;
    private final int COL_URUN_ADI = 9;

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
                true, true, true, true, true, true, false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        if (this.getColumnModel().getColumnCount() > 0) {

            this.getColumnModel().getColumn(COL_URUN_ADI).setCellEditor(new MyComboBoxEditor());
            this.getColumnModel().getColumn(COL_URUN_ADI).setCellRenderer(new MyTextBoxRenderer());
        }

        setRowHeight(32);
        setBackground(TableConst.BACKGROUND_COLOR);
        setFont(TableConst.FONT);
        setForeground(TableConst.FOREGROUND_COLOR);
        setSelectionBackground(TableConst.SELECTION_BACKGROUND_COLOR);
        setSelectionForeground(TableConst.SELECTION_FOREGROUND_COLOR);
        new Thread(() -> {
            loadData();
        }).start();
        
        addPropertyChangeListener((arg0) -> {
           try{
               int row = getSelectedRow();
               int adet = (int) getValueAt(row, COL_ADET);
               float fiyat = (float) getValueAt(row, COL_BIRIM_FIYATI);
               setValueAt(adet * fiyat, row, COL_TUTAR);
               
           }catch(Exception e){
               // do nothing
           }
            
        });
        
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

    public void updateTable() {
        DefaultTableModel dm = (DefaultTableModel) this.getModel();
        dm.getDataVector().removeAllElements();
        dm.fireTableDataChanged();
        new Thread(() -> {
            loadData();
        }).start();
    }

    public void saveToDatabase() {
        boolean isOk = true;

        if (isOk) {
            Urun urun = new Urun();
            urun.setMusteri(Database.getInstance().getById(Integer.parseInt(this.getValueAt(getSelectedRow(), 0).toString())));
            urun.setAdet((int) getValueAt(getSelectedRow(), COL_ADET));
            urun.setFiyat((float) getValueAt(getSelectedRow(), COL_BIRIM_FIYATI));
            urun.setIsim((String) getValueAt(getSelectedRow(), COL_URUN_ADI));

            Database.getInstance().insertProduct(urun);
            System.out.println("ürün eklendi");
        }
    }
    
}
