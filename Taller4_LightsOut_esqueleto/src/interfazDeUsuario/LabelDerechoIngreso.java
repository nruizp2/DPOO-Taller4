package interfazDeUsuario;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

public class LabelDerechoIngreso extends JLabel{
    JButton boton;
    int dificultad;
    public LabelDerechoIngreso(){
        dificultad = 0;
        String[] opciones = {"Facil","Medio","Dificil"};
    	JComboBox<String> panel = new JComboBox<>(opciones);
        boton = new JButton("Confirmar dificultad");
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selected = panel.getItemAt(panel.getSelectedIndex());
                if(selected.equals("Facil")){
                    dificultad = 10;
                }
                else if(selected.equals("Medio")){
                    dificultad = 50;
                }
                else if(selected.equals("Dificil")){
                    dificultad = 100;
                }
                JOptionPane.showMessageDialog(null, "Dificultad seleccionada: " + selected);
                boton.setEnabled(false);
            }
        });
    	setLayout(new BorderLayout());
        add(boton,BorderLayout.SOUTH);
        add(panel,BorderLayout.CENTER);
    }
    public JButton getBoton() {
        return boton;
    }
    public int getDificultad() {
        return dificultad;
    }
    
}
