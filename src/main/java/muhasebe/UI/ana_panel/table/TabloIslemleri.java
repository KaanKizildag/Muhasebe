/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhasebe.UI.ana_panel.table;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;

/**
 *
 * @author Kaan
 */
class TabloIslemleri {

    public static void urunTabloDuzenle() {
        JTable tbl = CustomTable.getInstance();
        // excel formullerine benzer değerler yazılacak.
    }

    public static void createTableSytle() {
        JTable tbl = CustomTable.getInstance();
        tbl.getTableHeader().setFont(new Font("Segore UI", Font.BOLD, 13));
        tbl.getTableHeader().setOpaque(true);
        tbl.getTableHeader().setForeground(Color.BLACK);
    }

}
