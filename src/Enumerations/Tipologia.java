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
public enum Tipologia  {
    
    FAMILIAR,
    DEPORTIVO,
    FURGONETA;
    
    @Override
    public String toString() {
       switch(this)
       {
           case FAMILIAR:
               return "FAMILIAR";
           case DEPORTIVO:
               return "DEPORTIVO";
           case FURGONETA:
               return "FURGONETA";
       }
       return null;
    }
    

}
