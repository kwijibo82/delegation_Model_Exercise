/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Escuchadores.ButtonDeleteCocheActionListener;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


public class DeleteCarForm extends JFrame {
    
    private final String TITULO = "Delete car form";
    
    private JLabel JLabelBorrarCoche;
    private JTextField JTextFieldBorrarCoche;
    private JButton JButtonBorrarCoche;
    private JPanel panelBorrarCoche;
    private TitledBorder borderBorrarCoche;

    public DeleteCarForm() {
        setTitle(TITULO);
        inicializarComponentes();
        registrarEscuchadores();
        pack();
        setVisible(true);
        setResizable(false);
    }
        
    private void inicializarComponentes() {
        
        getContentPane().setLayout(new GridLayout(0, 1, 0, 0));

        panelBorrarCoche = new JPanel();
        panelBorrarCoche.setLayout(new FlowLayout(FlowLayout.CENTER));
        borderBorrarCoche = BorderFactory.createTitledBorder("Delete car by Id");
        panelBorrarCoche.setBorder(borderBorrarCoche);
        
        JLabelBorrarCoche = new JLabel("Car Id:");
        JTextFieldBorrarCoche = new JTextFiled();
        JTextFieldBorrarCoche.setColumns(15);
        JButtonBorrarCoche = new JButton("Delete car");
        panelBorrarCoche.add(JLabelBorrarCoche);
        panelBorrarCoche.add(JTextFieldBorrarCoche);
        panelBorrarCoche.add(JButtonBorrarCoche);
        
        getContentPane().add(panelBorrarCoche);
        
        // propiedades generales
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 200));
    }


    private void registrarEscuchadores() {
       JButtonBorrarCoche.addActionListener(
              new ButtonDeleteCocheActionListener(this));

    }

    public JTextField getJTextFieldBorrarCoche() {
        return JTextFieldBorrarCoche;
    }


}