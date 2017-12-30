/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author Javi
 */
public class View {
    
    public static void intro(){
        System.out.println("Bienvenido al sistema de gestión de"
                + " coches Autoudima");
        System.out.println("Antes de comenzar permítame, cargar"
                + " los datos almacenados ...");
        System.out.println("El proceso de carga de datos "
                + "ha finalizado correctamente");
    }
    
    public static void menu(){
        System.out.println("¿Qué desea hacer?");
            System.out.println("(1) Ver todos los coches disponibles");
            System.out.println("(2) Añadir un nuevo coche al sistema");
            System.out.println("(3) Eliminar un coche en el sistema");
            System.out.println("(0) Salir del sistema");
            System.out.println("Seleccione una opción:");
    }
    
    public static void exitMessage(){
        System.out.println("Antes de finalizar, "
                + "permítame guardar los datos para la siguiente ocasión.");
    }
    
    public static void saveProcessSuccess(){
        System.out.println("El proceso de guardado "
                + "de datos ha finalizado correctamente.");
    }
    
    public static void saveProcessFailed(){
        System.out.println("El proceso de guardado "
        + "de datos ha fallado, revise el archivo de log.");
    }
    
    public static void defaultMessage(){
        System.out.println("La opción entrada es incorrecta");
    }
    
    public static String FirstRow() {
        return "ID\tDescripción\tTipología\tNum.Bastidor\t"
                + "Prim.Matric\tEstado\tAntiguedad\tP. Base"
                + "\tP.Venta\tFecha de creacion\n" +
                "----------------------------------------" +
                  "--------------------------------------" +
                  "--------------------------------------" +
                "--------------------------------------" +
                "---------------";
    }

    public static void incorrectValueExceptionString() {
        System.out.println("La entrada de datos no se corresponde "
                       + "con el formato esperado.");
    }

    public static void startGuideProcessView() {
       System.out.println("CREACIÓN DE UN NUEVO COCHE");
        System.out.println("--------------------------\n");
        System.out.println("Introduzca descripción:");
    }

    public static void invalidStateView() {
        System.out.println("Entrada inválida, "
                    + "por favor introduzca NUEVO|SEMINUEVO");
    }

    public static void getDateView() {    
        System.out.println("Introduzca la fecha de la primera matriculación"
                + " con un formato yyyy-MM-dd");
    }

    public static void enterChasisNumber() {
        System.out.println("Introduzca número bastidor:");
    }

    public static void invalidTipologiesView() {
        System.out.println("Entrada inválida, "
                    + "por favor introduzca FAMILIAR | DEPORTIVO | FURGONETA");
    }
    
    public static void InvalidFormatView() {
        System.out.println("El formato es inválido, por favor vuelva"
                        + " a intentarlo.");
    }

    public static void getTipologiesView() {
        System.out.println("Introduzca la tipología del coche"
                + " FAMILIAR | DEPORTIVO | FURGONETA");
    }

    public static void enterBasePriceView() {
        System.out.println("Introduzca precio base:");
    }

    public static void notFoundCarView(int id) {
       System.out.println("El coche con el identificador " +
                    id + " no se ha encontrado,");
    }

    public static void enterCarIdView() {
        System.out.println("Introduzca el identificador del coche a eliminar:");
    }

    public static void enterStateView() {
        System.out.println("Introduzca estado:");
    }

    public static void emptyValueEnteredView() {
       System.out.println("Entrada inválida, se ha introducido una"
                    + " cadena vacia. Por favor, vuelva a intentarlo.");
    }
    
    public static void addedCarView() {
         System.out.println("Coche añadido");
    }
    
    
}
