package interfazDeUsuario;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import uniandes.dpoo.taller4.modelo.Tablero;
import uniandes.dpoo.taller4.modelo.Top10;

public class LabelIzquierdoJuego extends JLabel implements MouseListener,ActionListener{

    private Tablero tablero;
    private int ladoTablero;
    private LabelInferiorJuego labelInferiorJuego;
    private LabelDerechoJuego labelDerechoJuego;
    private boolean mouseActivado;
    private int dificultad;

    public LabelIzquierdoJuego(Tablero tablero, int ladoTablero, LabelInferiorJuego labelInferiorJuego, LabelDerechoJuego labelDerechoJuego, int dificultad) {
        this.tablero = tablero;
        this.ladoTablero = ladoTablero;
        this.labelInferiorJuego = labelInferiorJuego;
        this.labelDerechoJuego = labelDerechoJuego;
        this.dificultad = dificultad;

        mouseActivado = true;

        labelDerechoJuego.getBotonReiniciar().addActionListener(this);

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

                    if(dificultad == 100){

                    ImageIcon imagen = new ImageIcon("Taller4_LightsOut_esqueleto/data/MrIncreibleClaro.jpg");
                    g2d.drawImage(imagen.getImage(), i * ancho, j * alto, ancho, alto, null);}

                    else{
                        ImageIcon imagen = new ImageIcon("Taller4_LightsOut_esqueleto/data/luz.png");
                        g2d.drawImage(imagen.getImage(), i * ancho, j * alto, ancho, alto, null);
                    }

                } else {
                    g2d.setColor(Color.GRAY);
                    g2d.fillRect(i * ancho, j * alto, ancho, alto);
                    g2d.setColor(Color.BLUE);
                    g2d.drawRect(i * ancho, j * alto, ancho, alto);

                    if(dificultad == 100){

                        ImageIcon imagen = new ImageIcon("Taller4_LightsOut_esqueleto/data/MrIncreibleDark.png");
                        g2d.drawImage(imagen.getImage(), i * ancho, j * alto, ancho, alto, null);}

                    else{
                            ImageIcon imagen = new ImageIcon("Taller4_LightsOut_esqueleto/data/luz.png");
                            g2d.drawImage(imagen.getImage(), i * ancho, j * alto, ancho, alto, null);
                        }
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {} //no se usa

    @Override
    public void mousePressed(MouseEvent e) {

        if(mouseActivado){

        int click_x = e.getX();
        int click_y = e.getY();
        int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
        tablero.jugar(casilla[1], casilla[0]);
        repaint();
        labelInferiorJuego.sumarJugada();
        if(tablero.tableroIluminado()){
            mouseActivado = false;
            JOptionPane.showMessageDialog(null, "¡Felicitaciones! Has ganado.");

            int jugadas = labelInferiorJuego.getJugadas();
            String nombre = LabelInferiorJuego.getNombreJugador();

            Top10 top10 = labelDerechoJuego.getTop10();

            top10.agregarRegistro(nombre, jugadas);
            try {
                top10.salvarRecords(new File("Taller4_LightsOut_esqueleto/data/top10.csv"));
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }
        }
    }
        
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == labelDerechoJuego.getBotonReiniciar()){
            tablero.reiniciar();
            repaint();

            labelInferiorJuego.reiniciar();
        }
    }

}
