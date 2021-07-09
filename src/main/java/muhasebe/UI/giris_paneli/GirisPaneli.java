/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhasebe.UI.giris_paneli;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import muhasebe.UI.ana_panel.table.TableConst;
import muhasebe.UI.pencere.FrameConsts;

/**
 *
 * @author kaan
 */
public class GirisPaneli extends JPanel{
    
    public GirisPaneli(){
        super();
        setLayout(new BorderLayout());
        setBackground(TableConst.BACKGROUND_COLOR);
        add(FrameConsts.createLabel("Hoşgeldiniz..."), BorderLayout.CENTER);
    }
    
}
