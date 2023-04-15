package interfazDeUsuario;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class LabelIzquierdoIngreso extends JLabel{
    
    private int tamanio;
    private JButton boton;
    
    public LabelIzquierdoIngreso() {
        tamanio = -1;
        String[] opciones = {"5x5","7x7","9x9"};
    	JComboBox<String> panel = new JComboBox<>(opciones);
        boton = new JButton("Confirmar tamanio");
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selected = panel.getItemAt(panel.getSelectedIndex());
                if(selected.equals("5x5")){
                    tamanio = 5;
                }
                else if(selected.equals("7x7")){
                    tamanio = 7;
                }
                else if(selected.equals("9x9")){
                    tamanio = 9;
                }
                JOptionPane.showMessageDialog(null, "Tamanio seleccionado: " + selected);
                boton.setEnabled(false);
            }
        });
    	setLayout(new BorderLayout());
        add(boton,BorderLayout.SOUTH);
        add(panel,BorderLayout.CENTER);
    	
    }
    
	public int getTamanio() {
		return tamanio;
	}
}
