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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author Javi
 */
public class ButtonAddCocheActionListener implements ActionListener {

    private Interfaz interfaz;

    public ButtonAddCocheActionListener(Interfaz interfaz) {
        this.interfaz = interfaz;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        ISistema sistema = new Sistema();
        
        Coche coche = new Coche(interfaz.getJTextFieldDescripcion().getText(),
        interfaz.getJTextFieldEstado().getText(), 
                 interfaz.getJTextFieldNumBastidor().getText(),
        interfaz.parseToCalendar(interfaz.getJTextFieldFechaPrimeraMatricula().getText()), 
                interfaz.getJTextFieldTiplogia().getText(),
                Double.parseDouble(interfaz.getJTextFieldPrecioBase().getText()));    
       
        //setea el array, TODO: Tiene que cargar al ejectur el programa para que no sea NULL
        sistema.loadData(); 
        sistema.getArrayListCoche().add(coche);
        sistema.saveData();
        JOptionPane.showMessageDialog(interfaz, "Coche añadido", "Información", 
                JOptionPane.INFORMATION_MESSAGE);
    }
    
}
