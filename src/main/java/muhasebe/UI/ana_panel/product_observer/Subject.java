/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muhasebe.UI.ana_panel.product_observer;

/**
 *
 * @author kaan
 */
public interface Subject {
    void attach(Observer observer);
    void dettach(Observer observer);
    void myNotify();
}
