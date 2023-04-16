package interfazDeUsuario;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import uniandes.dpoo.taller4.modelo.Tablero;

public class LabelIzquierdoJuego extends JLabel implements MouseListener{

    private Tablero tablero;
    private int ladoTablero;
    private LabelInferiorJuego labelInferiorJuego;

    public LabelIzquierdoJuego(Tablero tablero, int ladoTablero, LabelInferiorJuego labelInferiorJuego) {
        this.tablero = tablero;
        this.ladoTablero = ladoTablero;
        this.labelInferiorJuego = labelInferiorJuego;
        setPreferredSize(new Dimension(380, 320));
        addMouseListener(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.drawRect(0, 0, 120, 320);

        g2d.fillRect(10, 50, 50, 60);

        boolean[][] tableroJuego = tablero.darTablero();
        ladoTablero = tableroJuego.length;

        int ancho = getWidth() / ladoTablero;
        int alto = getHeight() / ladoTablero;

        for (int i = 0; i < ladoTablero; i++) {
            for (int j = 0; j < ladoTablero; j++) {
                if (tableroJuego[i][j]) {
                    g2d.setColor(Color.YELLOW);
                    g2d.fillRect(i * ancho, j * alto, ancho, alto);
                    g2d.setColor(Color.BLACK);
                    g2d.drawRect(i * ancho, j * alto, ancho, alto);

                } else {
                    g2d.setColor(Color.GRAY);
                    g2d.fillRect(i * ancho, j * alto, ancho, alto);
                    g2d.setColor(Color.BLUE);
                    g2d.drawRect(i * ancho, j * alto, ancho, alto);
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {} //no se usa

    @Override
    public void mousePressed(MouseEvent e) {

        int click_x = e.getX();
        int click_y = e.getY();
        int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
        tablero.jugar(casilla[1], casilla[0]);
        repaint();
        labelInferiorJuego.sumarJugada();
        
    }

    private int[] convertirCoordenadasACasilla(int x, int y){
        int altoPanelTablero = getHeight();
        int anchoPanelTablero = getWidth();
        int altoCasilla = altoPanelTablero / ladoTablero;
        int anchoCasilla = anchoPanelTablero / ladoTablero;
        int fila = (int) (y / altoCasilla);
        int columna = (int) (x / anchoCasilla);
        return new int[] { fila, columna };
    }
    @Override
    public void mouseReleased(MouseEvent e) {}//no se usa

    @Override
    public void mouseEntered(MouseEvent e) {}//no se usa

    @Override
    public void mouseExited(MouseEvent e) {}//no se usa

}
