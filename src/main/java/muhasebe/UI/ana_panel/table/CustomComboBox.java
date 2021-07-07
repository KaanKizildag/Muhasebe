/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhasebe.UI.ana_panel.table;

import java.awt.Color;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableCellRenderer;
import muhasebe.service.concretes.ProductNameServiceImpl;

/**
 *
 * @author Kaan
 */
public class CustomComboBox extends JComboBox<String> {

    public CustomComboBox() {
        super();
        setBackground(Color.lightGray);
        setForeground(Color.darkGray);

        new Thread(() -> {
            ProductNameServiceImpl.getInstance().getAll().forEach((productName) -> {
                addItem(productName.getIsim());
            });
        }).start();

    }

}

class MyComboBoxEditor extends DefaultCellEditor {

    MyComboBoxEditor() {
        super(new CustomComboBox());
    }
}

class MyTextBoxRenderer extends DefaultTableCellRenderer {

    public MyTextBoxRenderer() {
        super();

    }

}
