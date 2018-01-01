/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
    
import Escuchadores.ButtonAddCocheActionListener;
import Escuchadores.ButtonShowCochesActionListener;
import Escuchadores.ButtonShowDeleteFormActionListener;
import Interfaces.ISistema;
import Model.Coche;
import Sistema.Sistema;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Javi
 */
public class Interfaz extends JFrame {
    
    private final String TITULO = "MP-17181S-AA2";
    
    private JTextField cajaTextoEntrada;
    
    //Botones
    private JButton buttonVerCoches;
    private JButton buttonAddCoches;
    private JButton buttonDelCoches;
    
    //Paneles
    private JPanel panelSalida;
    private JScrollPane panelScrollSalida;
    private JPanel panelBotones;
    private JTextArea cajaTextoSalida;
    private TitledBorder borderPanelBotones;
    private TitledBorder borderPanelEntradaDatosCoche;
    private TitledBorder borderPanelSalidaDatos;
    private JPanel panelEntradaDatosCoche;
    
    //Entrada datos
    private JTextField JTextFieldDescripcion;
    private JTextField JTextFieldEstado;
    private JTextField JTextFieldNumBastidor;
    private JTextField JTextFieldFechaPrimeraMatricula;
    private JTextField JTextFieldTiplogia;
    private JTextField JTextFieldPrecioBase;
    private JLabel JLabelDescripcion;
    private JLabel JLabelEstado;
    private JLabel JLabelNumBastidor;
    private JLabel JLabelFechaPrimeraMatricula;
    private JLabel JLabelTipologia;
    private JLabel JLabelPrecioBase;
           
    public Interfaz() {
        setTitle(TITULO);
        inicializarComponentes();
        registrarEscuchadores();
        pack();
        setVisible(true);
        setResizable(false);
    }
        
    private void inicializarComponentes() {
        
        getContentPane().setLayout(new GridLayout(0, 1, 0, 0));

        //Panel botones
        panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER));
        borderPanelBotones = BorderFactory.createTitledBorder("Acciones");
        panelBotones.setBorder(borderPanelBotones);

        //Panel entrada datos coche
        panelEntradaDatosCoche = new JPanel();
        panelEntradaDatosCoche.setLayout(new FlowLayout(FlowLayout.CENTER));    
        borderPanelEntradaDatosCoche = 
                BorderFactory.createTitledBorder("Añadir coche");
        panelEntradaDatosCoche.setBorder(borderPanelEntradaDatosCoche);
               
        JLabelDescripcion = new JLabel("Descripción:");
        JTextFieldDescripcion = new JTextField();
        JTextFieldDescripcion.setColumns(15);        
        panelEntradaDatosCoche.add(JLabelDescripcion);
        panelEntradaDatosCoche.add(JTextFieldDescripcion);
        
        JLabelEstado = new JLabel("Estado:");
        JTextFieldEstado = new JTextField();
        JTextFieldEstado.setColumns(15);        
        panelEntradaDatosCoche.add(JLabelEstado);
        panelEntradaDatosCoche.add(JTextFieldEstado);
        
        JLabelFechaPrimeraMatricula = new JLabel("Fecha primera matrícula:");
        JTextFieldFechaPrimeraMatricula = new JTextField();
        JTextFieldFechaPrimeraMatricula.setColumns(15);        
        panelEntradaDatosCoche.add(JLabelFechaPrimeraMatricula);
        panelEntradaDatosCoche.add(JTextFieldFechaPrimeraMatricula);
        
        JLabelNumBastidor = new JLabel("Núm. bastidor:");
        JTextFieldNumBastidor = new JTextField();
        JTextFieldNumBastidor.setColumns(15);        
        panelEntradaDatosCoche.add(JLabelNumBastidor);
        panelEntradaDatosCoche.add(JTextFieldNumBastidor);

        JLabelTipologia = new JLabel("Tipología:");
        JTextFieldTiplogia = new JTextField();
        JTextFieldTiplogia.setColumns(15);        
        panelEntradaDatosCoche.add(JLabelTipologia);
        panelEntradaDatosCoche.add(JTextFieldTiplogia);
       
        JLabelPrecioBase = new JLabel("Precio base:");
        JTextFieldPrecioBase = new JTextField();
        JTextFieldPrecioBase.setColumns(15);        
        panelEntradaDatosCoche.add(JLabelPrecioBase);
        panelEntradaDatosCoche.add(JTextFieldPrecioBase);
        
        //Panel salida datos
        panelSalida = new JPanel();
        panelSalida.setLayout(new FlowLayout(FlowLayout.CENTER));
        borderPanelSalidaDatos = 
                BorderFactory.createTitledBorder("Salida datos");
        panelSalida.setBorder(borderPanelSalidaDatos);
        panelScrollSalida = new JScrollPane();
        panelSalida.add(panelScrollSalida);
        cajaTextoSalida = new JTextArea(9, 65);
        cajaTextoSalida.setEditable(false);
        panelScrollSalida.setViewportView(cajaTextoSalida);
   
        //Botones
        buttonAddCoches = new JButton("Añadir coche");
        panelBotones.add(buttonAddCoches); 
        buttonVerCoches = new JButton("Ver coches");
        panelBotones.add(buttonVerCoches); 
        buttonDelCoches = new JButton("Borrar un coche");
        panelBotones.add(buttonDelCoches);    
        
        getContentPane().add(panelBotones);
        getContentPane().add(panelEntradaDatosCoche);
        getContentPane().add(panelSalida);
        
        // propiedades generales
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));
    }
    
	/*
	 * Métodos para la lectura y escritura de datos
	 */

	public String leerDatosDeEntrada() {
		return cajaTextoEntrada.getText();
	}

	public void escribirDatosDeSalida(String texto) {
		String formato = "hh:mm:ss a";
		DateFormat dateFormat = new SimpleDateFormat(formato);
		String tiempo = dateFormat
                        .format(new GregorianCalendar().getTime());
		cajaTextoSalida.append(tiempo + " :: " + texto + "\n");
	}
        
        public void limpiarSalida(){
            cajaTextoSalida.setText(null);
        }
	/*
	 * Otros metodos de interes
	 */
	public void establecerFocoEnDatosDeEntrada() {
		cajaTextoEntrada.requestFocus();
	}

        private void registrarEscuchadores() {
           buttonVerCoches.addActionListener(
                   new ButtonShowCochesActionListener(this));
           buttonAddCoches.addActionListener(
                   new ButtonAddCocheActionListener(this));
           buttonDelCoches.addActionListener(
                   new ButtonShowDeleteFormActionListener());
        }

    /**
     * Parsea el string del JTextField de la fecha
     * de la primera matricula a Calendar
     * @param text
     * @return 
     */
    public Calendar parseToCalendar(String text) {
         
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd", Locale.ENGLISH);
        try {
            cal.setTime(sdf.parse(JTextFieldFechaPrimeraMatricula.getText()));// all done
        } catch (ParseException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cal;
    }

    //Getters y setters de los campos de entrada de datos
    public JTextField getJTextFieldDescripcion() {
        return JTextFieldDescripcion;
    }

    public JTextField getJTextFieldEstado() {
        return JTextFieldEstado;
    }

    public JTextField getJTextFieldNumBastidor() {
        return JTextFieldNumBastidor;
    }

    public JTextField getJTextFieldFechaPrimeraMatricula() {
        return JTextFieldFechaPrimeraMatricula;
    }

    public JTextField getJTextFieldTiplogia() {
        return JTextFieldTiplogia;
    }

    public JTextField getJTextFieldPrecioBase() {
        return JTextFieldPrecioBase;
    }
}
