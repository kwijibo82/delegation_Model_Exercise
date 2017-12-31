package mp.pkg17181s.aa2;


import Interfaces.ISistema;
import Sistema.Sistema;
import View.Interfaz;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Javi
 */
public class Principal {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
                           new Interfaz();
                            
			}
		});
    }
    
}
