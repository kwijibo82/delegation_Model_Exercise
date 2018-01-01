/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Escuchadores;

import View.DeleteCarForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Javi
 */
public class ButtonShowDeleteFormActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
       DeleteCarForm JFrameDeleteCar = new DeleteCarForm();
       JFrameDeleteCar.setVisible(true);
    }
    
}
