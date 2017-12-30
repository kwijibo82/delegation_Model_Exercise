/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enumerations;


/**
 *
 * @author Javi
 */
public enum Estado {
    
    NUEVO,
    SEMINUEVO;
    
    @Override    
    public String toString() {
        switch(this){
            case NUEVO:
                return "NUEVO";
            case SEMINUEVO:
                return "SEMINUEVO";     
        }
        return null;
    }
    
}
