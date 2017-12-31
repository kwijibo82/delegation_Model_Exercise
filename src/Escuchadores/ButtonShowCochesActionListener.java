/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Escuchadores;

import Interfaces.ISistema;
import Model.Coche;
import Sistema.Sistema;
import View.Interfaz;
import View.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Javi
 */
public class ButtonShowCochesActionListener implements ActionListener {

    private Interfaz interfaz; 
    
    public ButtonShowCochesActionListener(Interfaz interfaz){
        this.interfaz = interfaz;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        interfaz.limpiarSalida();
        interfaz.escribirDatosDeSalida(View.FirstRow());
      
        ISistema sistema = new Sistema();
        
        ArrayList<Coche> arrayCoches = sistema.loadData();
        
        for (Iterator iterator = arrayCoches.iterator(); 
                iterator.hasNext();) {
            Object coche = iterator.next();
            interfaz.escribirDatosDeSalida(coche.toString());
        }
        
    }

}
