package interfazDeUsuario;

import javax.swing.JLabel;

public class LabelInferiorJuego extends JLabel{

    private int jugadas;
    private static String nombreJugador;
    public int getJugadas() {
        return jugadas;
    }

    public LabelInferiorJuego(String nombreJugador) {
        LabelInferiorJuego.nombreJugador = nombreJugador;
        jugadas = 0;

        setText("Jugadas: " + jugadas + ".                                                                                   Jugador: " + nombreJugador + ".");
    }
    public void sumarJugada(){
        jugadas++;
        setText("Jugadas: " + jugadas + ".                                                                                   Jugador: " + nombreJugador + ".");
    }

}
