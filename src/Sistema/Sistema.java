/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;

import Enumerations.Estado;
import Enumerations.Tipologia;
import Interfaces.ISistema;
import Model.Coche;
import View.View;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Javi
 */
public class Sistema implements ISistema, Serializable {
    
    //Constantes
    private static final String FILE = "coches.data";
    
    // Atributos
    private String rutaFichero;
    private ArrayList<Coche> arrayListCoches;

    // Constructora
    public Sistema() {
	
    }
    
    @Override
    public void ejecutar() {
        
        Calendar gc = new GregorianCalendar();
        gc.set(2017, 11, 1); //Los meses se setean en base cero

        View.intro();
        this.arrayListCoches = loadData();
       
        Scanner sc = new Scanner(System.in);
        String opt = "";

            do {
                    System.out.print("\n");
                    View.menu(); 
                    try { 
                        opt =  readFromKeyboard(sc.nextLine(), sc); 
                    }
                    catch (InputMismatchException ime){
                        View.incorrectValueExceptionString();
                    }
                    
                    switch (opt)
                    {
                        case "1":
                            showCars();
                            break;
                        case "2":
                            addNewCar();
                            break;
                        case "3":
                            //deleteCar();
                            break;
                        case "0":
                            saveData();
                            View.exitMessage();
                            View.saveProcessSuccess();
                            break;
                        default:
                            View.defaultMessage();
                    }

                } while (!opt.equals("0"));  
    }
    
    @Override
    public void saveData() {
       
        try {
            
            FileOutputStream fos = new FileOutputStream(FILE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this.arrayListCoches);
            
            oos.close();
            fos.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    
    @Override
    public ArrayList<Coche> loadData() {

        arrayListCoches = new ArrayList<Coche>();
        
        try {
            
            FileInputStream fis = new FileInputStream(FILE);
            ObjectInputStream ois = new ObjectInputStream(fis);
            arrayListCoches = (ArrayList<Coche>) ois.readObject();
            
            ois.close();
            fis.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EOFException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayListCoches;
    }
    
    private void showCars() { 
        View.FirstRow();       
        for (Coche c : arrayListCoches) {
            System.out.println(c.toString());
        }
    }

    private void addNewCar() {
     
        String _descripcion;
        String _estado;
        String _numBastidor; 
        Calendar _fechaPrimeraMatricula;
        String _tipologia;
        Double _precioBase;     
        
        Scanner sc = new Scanner(System.in);
        
        View.startGuideProcessView();
        _descripcion = readFromKeyboard(sc.nextLine(), sc);
        View.enterStateView();
       
        _estado = readFromKeyboard(sc.nextLine(), sc);
        while ((!_estado.equalsIgnoreCase(Estado.NUEVO.toString())) && 
            (!_estado.equalsIgnoreCase(Estado.SEMINUEVO.toString()))) {
            View.invalidStateView();    
             _estado = readFromKeyboard(sc.nextLine(), sc);
        }
        View.enterChasisNumber();
        _numBastidor = readFromKeyboard(sc.nextLine(), sc);
        
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");                 
        View.getDateView();
        
        Date date = null;
        String line = readFromKeyboard(sc.nextLine(), sc);
        while (date == null) {   
            try {
                date = format.parse(line);
            } catch (ParseException e) {
                View.InvalidFormatView();              
            }
        }
        //convierte la date a Calendar
        _fechaPrimeraMatricula = Calendar.getInstance();
        _fechaPrimeraMatricula.setTime(date);
        View.getTipologiesView();
        _tipologia = readFromKeyboard(sc.nextLine(), sc);
        while ((!_tipologia.equalsIgnoreCase(Tipologia.FAMILIAR.toString())) && 
            (!_tipologia.equalsIgnoreCase(Tipologia.DEPORTIVO.toString())) &&
             !_tipologia.equalsIgnoreCase(Tipologia.FURGONETA.toString())) {  
            View.invalidTipologiesView();
            _tipologia = readFromKeyboard(sc.nextLine(), sc);
        }        
        View.enterBasePriceView();       
        _precioBase = readFromKeyboard(sc.nextDouble(), sc);
        
        //creamos coche
        Coche c = new Coche(_descripcion, _estado, _numBastidor, 
                _fechaPrimeraMatricula, _tipologia, _precioBase);      
        this.arrayListCoches.add(c);
        View.addedCarView();
      
    }
    
    @Override
    public void deleteCar(int id) {
       
        boolean found = false;

        for (Iterator<Coche> iterator = arrayListCoches.iterator();
                iterator.hasNext();) {
            Coche c = iterator.next();
            if (c.getIdentificador() == id) {
                iterator.remove();
                found = true;
                JOptionPane.showMessageDialog(null, "EL coche con id " 
                    + id + " ha sido eliminado del sistema", "Atención",
                    JOptionPane.INFORMATION_MESSAGE);
            }           
        }  
        if (!found) {           
            JOptionPane.showMessageDialog(null, "EL coche con id " 
                    + id + " no se encuentra en el sistema", "Atención",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @Override
    public String readFromKeyboard(String str, Scanner sc)
    {
        while (str.isEmpty()){
            View.emptyValueEnteredView();
            str = sc.nextLine();
        }
        return str;
    }
    
    @Override
    public Double readFromKeyboard(Double value, Scanner sc)
    {
        while (value == 0){
            View.emptyValueEnteredView();
            value = sc.nextDouble();
        }     
        return value;
    }
    
    @Override
    public int readFromKeyboard(int value, Scanner sc)
    {
        while (value == 0){
            View.emptyValueEnteredView();
            value = sc.nextInt();
        }      
        return value;
    }

    @Override
    public ArrayList<Coche> getArrayListCoche() {
        return arrayListCoches;
    }

   

}
