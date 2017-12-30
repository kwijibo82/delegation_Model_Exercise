/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.Calendar;

/**
 *
 * @author Javi
 */
public interface IGenerateValues {
    
    /**
     * Método que genera de manera aleatoria un id de cuatro
     * cifras.
     */
    public int generateRandomId();
    
    /**
     * Método que establece la fecha de fabricación del coche,
     * se almacena en el coche y permite mantener información 
     * histórica.
     */
    public Calendar setBuildingData();
    
    
}