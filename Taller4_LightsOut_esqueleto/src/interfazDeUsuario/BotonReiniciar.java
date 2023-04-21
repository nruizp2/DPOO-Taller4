package interfazDeUsuario;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;

public class BotonReiniciar {

    private JButton boton;

    public BotonReiniciar(){

        boton = new JButton("Reiniciar");

        Dimension d = new Dimension(170, 30);
        boton.setMaximumSize(d);
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        boton.setBackground(Color.decode("#2a89e0"));
        boton.setForeground(Color.WHITE);
        
    }

    public JButton getBoton() {
        return boton;
    }

    
    
}
