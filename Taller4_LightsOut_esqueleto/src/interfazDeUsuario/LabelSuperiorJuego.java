package interfazDeUsuario;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class LabelSuperiorJuego extends JLabel{

    public LabelSuperiorJuego(int tamanioTablero, int dificultad) {
        String dificultadString = "";
        if(dificultad == 10){
            dificultadString = "Facil";
        }
        else if(dificultad == 50){
            dificultadString = "Medio";
        }
        else if(dificultad == 100){
            dificultadString = "Dificil";
        }
        setOpaque(true);
        setBackground(Color.decode("#2a89e0"));
        
        String mostrar = "Tamanio:  " + tamanioTablero+"x"+tamanioTablero + "                                                                                   Dificultad: " + dificultadString;

        setText(mostrar);
        setFont(new Font("Arial", Font.BOLD, 14));
        setForeground(Color.WHITE);

    }
    
}
