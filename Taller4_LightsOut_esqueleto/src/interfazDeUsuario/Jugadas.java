package interfazDeUsuario;

public class Jugadas {
    
    int jugadas;
    LabelInferiorJuego labelInferiorJuego;
    public Jugadas(){
        this.jugadas = 0;
    }

    public void sumarJugada(){
        jugadas++;
        labelInferiorJuego.actualizarTexto();
    }

    public void reiniciar(){
        jugadas = 0;
        labelInferiorJuego.actualizarTexto();
    }

    public void setLabelInferiorJuego(LabelInferiorJuego labelInferiorJuego){
        this.labelInferiorJuego = labelInferiorJuego;
    }

    public int getJugadas() {
        return jugadas;
    }

    public LabelInferiorJuego getLabelInferiorJuego() {
        return labelInferiorJuego;
    }
    
    
}
