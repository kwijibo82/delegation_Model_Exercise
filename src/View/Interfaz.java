/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
    
import Escuchadores.ButtonAddCochesActionListener;
import Interfaces.ISistema;
import Model.Coche;
import Sistema.Sistema;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Javi
 */
public class Interfaz extends JFrame {
    
    private final String TITULO = "MP-17181S-AA2";
    
    private JPanel panelEntrada;
    private JLabel etiquetaEntrada;
    private JTextField cajaTextoEntrada;
    
    //Botones
    private JButton buttonVerCoches;
    private JButton buttonAddCoches;
    private JButton buttonDelCoches;
    private JButton botonElevarAlCuadrado;
    private JButton calcularBaseButton;

    //Paneles
    private JPanel panelSalida;
    private JScrollPane panelScrollSalida;
    private JPanel panelBotones;
    private JTextArea cajaTextoSalida;
    private TitledBorder borderPanelBotones;

    private JPanel panelComponentes;
    
    private JPanel panelExtensionCuatro;
    private TitledBorder borderExtensionCuatro;
    private JLabel labelBaseOrigen;
    private JSpinner spinnerBaseOrigen;
    private JLabel labelBaseACalcular;
    private JSpinner spinnerBaseACalcular;
           
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

        panelEntrada = new JPanel();
        panelEntrada.setLayout(new FlowLayout(FlowLayout.CENTER));
        etiquetaEntrada = new JLabel("Entrada de datos:");
        cajaTextoEntrada = new JTextField();
        cajaTextoEntrada.setColumns(15);
        panelEntrada.add(etiquetaEntrada);
        panelEntrada.add(cajaTextoEntrada);

        panelSalida = new JPanel();
        panelSalida.setLayout(new BorderLayout(0, 0));
        panelScrollSalida = new JScrollPane();
        panelSalida.add(panelScrollSalida);
        cajaTextoSalida = new JTextArea(20, 5);
        cajaTextoSalida.setEditable(false);
        panelScrollSalida.setViewportView(cajaTextoSalida);

        panelComponentes = new JPanel();
        panelComponentes.setLayout(new FlowLayout(FlowLayout.CENTER));
        botonElevarAlCuadrado = new JButton("x²");
        panelComponentes.add(botonElevarAlCuadrado);
        
        //Botones
        panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER));
        borderPanelBotones = BorderFactory.createTitledBorder("Acciones");
        panelBotones.setBorder(borderPanelBotones);
        
        buttonVerCoches = new JButton("Ver coches");
        panelBotones.add(buttonVerCoches);
        
        getContentPane().add(panelEntrada);
        getContentPane().add(panelComponentes);
        getContentPane().add(panelBotones);
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
		String tiempo = dateFormat.format(new GregorianCalendar().getTime());
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
                   new ButtonAddCochesActionListener(this));
        }
        
        
}
