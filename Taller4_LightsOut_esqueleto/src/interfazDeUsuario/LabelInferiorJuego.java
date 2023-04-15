package interfazDeUsuario;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JLabel;

public class LabelInferiorJuego extends JLabel implements PropertyChangeListener{

    private int jugadas;
    public int getJugadas() {
        return jugadas;
    }

    public void setJugadas(int jugadas) {
        this.jugadas = jugadas;
    }

    public LabelInferiorJuego(String nombreJugador) {
        jugadas = 0;

        setText("Jugadas: " + jugadas + ".                                                                                   Jugador: " + nombreJugador + ".");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("jugadas")) {
            int newValue = (int) evt.getNewValue();
            setJugadas(newValue);
        }
    }

}
