package interfazDeUsuario;

import java.awt.*;


import javax.swing.*;

import uniandes.dpoo.taller4.modelo.Tablero;
import uniandes.dpoo.taller4.modelo.Top10;

public class InterfazJuego extends JFrame {

    private Tablero tablero;
    BotonReiniciar botonReiniciar;
    LabelDerechoJuego labelDerechoJuego;
    LabelIzquierdoJuego labelIzquierdoJuego;
    LabelInferiorJuego labelInferiorJuego;
    LabelSuperiorJuego labelSuperiorJuego;

    Jugadas jugadas;
    
    public Tablero getTablero() {
        return tablero;
    }

    public InterfazJuego(int tamanioTablero,Top10 top10, int dificultad, String nombreJugador){

        tablero = new Tablero(tamanioTablero);
        tablero.desordenar(dificultad);
        jugadas = new Jugadas();
        BotonReiniciar botonReiniciar = new BotonReiniciar();
        LabelDerechoJuego labelDerechoJuego = new LabelDerechoJuego(top10,this,botonReiniciar.getBoton());
        LabelIzquierdoJuego labelIzquierdoJuego = new LabelIzquierdoJuego(tablero,tamanioTablero,jugadas, botonReiniciar.getBoton(),dificultad,top10);
        LabelInferiorJuego labelInferiorJuego = new LabelInferiorJuego(nombreJugador,jugadas);
        LabelSuperiorJuego labelSuperiorJuego = new LabelSuperiorJuego(tamanioTablero, dificultad);

        jugadas.setLabelInferiorJuego(labelInferiorJuego);

        
        setTitle("Lights out");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(580,500);
        setLayout(new BorderLayout());


        add(labelSuperiorJuego,BorderLayout.NORTH);
        add(labelInferiorJuego,BorderLayout.SOUTH);
        add(labelIzquierdoJuego,BorderLayout.WEST);
        add(labelDerechoJuego,BorderLayout.EAST);


        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screenSize.width - getWidth()) / 2;
		int y = (screenSize.height - getHeight()) / 2;
		setLocation(x, y);



        setVisible(true);
        setResizable(false);


    }
}
