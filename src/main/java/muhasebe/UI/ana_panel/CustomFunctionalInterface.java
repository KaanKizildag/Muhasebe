/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhasebe.UI.ana_panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author kaan
 */
@FunctionalInterface
public interface CustomFunctionalInterface extends ActionListener{
    void actionPerformed(ActionEvent e);
}
