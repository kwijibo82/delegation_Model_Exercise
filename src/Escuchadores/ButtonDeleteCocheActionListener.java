/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Escuchadores;

import Interfaces.ISistema;
import Model.Coche;
import Sistema.Sistema;
import View.DeleteCarForm;
import View.Interfaz;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

/**
 *
 * @author Javi
 */
public class ButtonDeleteCocheActionListener implements ActionListener {

    private DeleteCarForm dcf;

    public ButtonDeleteCocheActionListener(DeleteCarForm dcf) {
        this.dcf = dcf;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        ISistema sistema = new Sistema();
        sistema.loadData();
        sistema.deleteCar(Integer.parseInt(
                dcf.getJTextFieldBorrarCoche().getText()));
        sistema.saveData();
        }
    }
    

