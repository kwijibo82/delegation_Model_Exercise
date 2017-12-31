/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import Enumerations.Estado;
import Enumerations.Tipologia;
import Interfaces.IGenerateValues;
import java.io.Serializable;
import java.lang.ProcessBuilder.Redirect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javafx.animation.KeyValue;


/**
 *
 * @author Javi
 */
public class Coche implements IGenerateValues, Serializable {
    
    //Constantes
    private static final int MAX = 9999;
    private static final int MIN = 1;
    private static final double IVA = 0.21;
    
    private String descripcion;
    private Enum estado;
    private String numBastidor;
    private Calendar fechaPrimeraMatricula;
    private Enum tipologia;
    private Double precioBase;
    private int Identificador;
    private Calendar fechaCreacion;
    
    public Coche(String descripcion, String estado, String numBastidor, 
            Calendar fechaPrimeraMatricula, String tipologia, 
            Double precioBase) 
    {
        this.descripcion = descripcion;
        this.estado = Estado.valueOf(estado.toUpperCase());
        this.numBastidor = numBastidor;
        this.fechaPrimeraMatricula = fechaPrimeraMatricula;
        this.tipologia = Tipologia.valueOf(tipologia.toUpperCase());
        this.precioBase = precioBase;
        this.Identificador = this.generateRandomId();   
        this.fechaCreacion = this.setBuildingData();
    }
         
    public double precioVenta(){
    
        return this.precioBase += (this.precioBase * IVA);
    }
    
    public int Antiguedad(){
    
        Calendar c = setBuildingData();  
        long end = c.getTimeInMillis();
        long start = this.fechaPrimeraMatricula.getTimeInMillis();
        return (int) TimeUnit.MILLISECONDS.toDays(Math.abs(end - start));

    }
    
    @Override
    public final int generateRandomId() {

        Random rand = new Random();
        return rand.nextInt((MAX - MIN) + MIN) + MIN;
    }

    @Override
    public final Calendar setBuildingData() {
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        return cal;
    }

    @Override
    public String toString() {
       
       StringBuilder sb = new StringBuilder(); 
       
       sb.append(Identificador);
       sb.append("\t");
       sb.append(descripcion);
       sb.append("\t");
       sb.append(tipologia);
       sb.append("\t");
       sb.append(numBastidor);
       sb.append("\t");
       sb.append(fechaPrimeraMatricula.getTime());
       sb.append("\t");
       sb.append(estado);
       sb.append("\t");
       sb.append(Antiguedad());
       sb.append("\t");
       sb.append(precioBase);
       sb.append("\t");
       sb.append(precioVenta());
       sb.append("\t");
       sb.append(fechaCreacion.getTime());

       return sb.toString();
    
    }

    //Getters y setters
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Enum getEstado() {
        return estado;
    }

    public void setEstado(Enum estado) {
        this.estado = estado;
    }

    public String getNumBastidor() {
        return numBastidor;
    }

    public void setNumBastidor(String numBastidor) {
        this.numBastidor = numBastidor;
    }

    public Calendar getFechaPrimeraMatricula() {
        return fechaPrimeraMatricula;
    }

    public void setFechaPrimeraMatricula(Calendar fechaPrimeraMatricula) {
        this.fechaPrimeraMatricula = fechaPrimeraMatricula;
    }

    public Enum getTipologia() {
        return tipologia;
    }

    public void setTipologia(Enum tipologia) {
        this.tipologia = tipologia;
    }

    public Double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(Double precioBase) {
        this.precioBase = precioBase;
    }
    
    //Solo getters para los atributos identificador y fechaCreacion
    public int getIdentificador() {
        return Identificador;
    }

    public Calendar getFechaCreacion() {
        return fechaCreacion;
    }
    
    
}
