/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhasebe.UI.table;

import java.awt.Color;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Kaan
 */
public class CustomComboBox extends JComboBox<String> {

    public CustomComboBox() {
        super(new String[]{"Marul", "Limon", "Ay Çekirdeği"});
        setBackground(Color.lightGray);
        setForeground(Color.darkGray);
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
