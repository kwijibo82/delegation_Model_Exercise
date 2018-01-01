/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;


import Model.Coche;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Javi
 */
public interface ISistema {
    
    
    public ArrayList<Coche> getArrayListCoche();
    /**
    * Método que debe implementar el sistema concreto con la funcionalidad
    * especifica.
    */
    public void ejecutar();   
    
    /**
     * Método que guarda los datos cuando finaliza la ejecución.
     */
    public void saveData();

    /**
     * Método que borra un determinado coche del sistema.
     */
    public void deleteCar(int id);
    
    /**
     * Método que carga los datos  cuando finaliza la ejecución.
     */
    public ArrayList<Coche> loadData();
    
    /**
     * Método que lee los datos entrados por el tecaldo.
     */
    public String readFromKeyboard(String str, Scanner sc);
    
    public Double readFromKeyboard(Double value, Scanner sc);
    
    public int readFromKeyboard(int value, Scanner sc);
    

}
