package interfazDeUsuario;

import javax.swing.JLabel;

public class LabelInferiorJuego extends JLabel{

    private Jugadas jugadas;
    private static String nombreJugador;
    
    public Jugadas getJugadas() {
        return jugadas;
    }

    public LabelInferiorJuego(String nombreJugador, Jugadas jugadas) {
        LabelInferiorJuego.nombreJugador = nombreJugador;
        this.jugadas = jugadas;
        actualizarTexto();
    }
    public void actualizarTexto(){
        setText("Jugadas: " + jugadas.getJugadas() + ".                                                                                   Jugador: " + nombreJugador + ".");
    }

    public static String getNombreJugador() {
        return nombreJugador;
    }

    

}
