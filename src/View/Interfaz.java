/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
    
import Escuchadores.ButtonAddCochesActionListener;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
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
