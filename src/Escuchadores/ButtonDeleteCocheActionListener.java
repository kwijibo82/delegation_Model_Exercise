/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Escuchadores;

import Interfaces.ISistema;
import Sistema.Sistema;
import View.Interfaz;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

/**
 *
 * @author Javi
 */
public class ButtonDeleteCocheActionListener implements ActionListener {

    private Interfaz interfaz;

    public ButtonDeleteCocheActionListener(Interfaz interfaz) {
        this.interfaz = interfaz;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        ISistema sistema = new Sistema();
        
        for (Iterator iterator = sistema.loadData().iterator();
                iterator.hasNext();) {
            Object next = iterator.next();
            
            
        }
        
    }
    
}
