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
        actualizarTexto();
    }
    public void sumarJugada(){
        jugadas++;
        actualizarTexto();
    }

    public void reiniciar(){
        jugadas = 0;
        actualizarTexto();
    }

    public void actualizarTexto(){
        setText("Jugadas: " + jugadas + ".                                                                                   Jugador: " + nombreJugador + ".");
    }

    public static String getNombreJugador() {
        return nombreJugador;
    }

    

}
