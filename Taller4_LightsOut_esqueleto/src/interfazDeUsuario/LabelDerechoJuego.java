package interfazDeUsuario;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import uniandes.dpoo.taller4.modelo.Top10;


public class LabelDerechoJuego extends JLabel implements ActionListener{
    private JButton botonNuevo;
    private JButton botonReiniciar;
    private JButton botonTop10;
    private InterfazJuego interfazJuego;
    private Top10  top10;

    public LabelDerechoJuego(Top10 top10, InterfazJuego interfazJuego) {
        this.top10 = top10;
        this.interfazJuego = interfazJuego;

        setOpaque(true);
        setFont(new Font("Arial", Font.BOLD, 14));

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Component filler1 = Box.createVerticalGlue();
        add(filler1);

        botonNuevo = new JButton("Nuevo/Cambiar Jugador");
        botonReiniciar = new JButton("Reiniciar");
        botonTop10 = new BotonTop10(top10).getBoton();

        Dimension d = new Dimension(170, 30);
        botonNuevo.setMaximumSize(d);
        botonReiniciar.setMaximumSize(d);
        botonTop10.setMaximumSize(d);
        botonNuevo.setPreferredSize(d);
        botonReiniciar.setPreferredSize(d);
        botonTop10.setPreferredSize(d);

        botonNuevo.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonReiniciar.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonTop10.setAlignmentX(Component.CENTER_ALIGNMENT);

        botonNuevo.setBackground(Color.decode("#2a89e0"));
        botonReiniciar.setBackground(Color.decode("#2a89e0"));

        botonNuevo.addActionListener(this);

        add(botonNuevo);
        add(Box.createRigidArea(new Dimension(0,50)));
        add(botonReiniciar);
        add(Box.createRigidArea(new Dimension(0,50)));
        add(botonTop10);

        Component filler2 = Box.createVerticalGlue();
        add(filler2);

        botonNuevo.setForeground(Color.WHITE);
        botonReiniciar.setForeground(Color.WHITE);
        botonTop10.setForeground(Color.WHITE);

        setPreferredSize(new Dimension(200, 100));

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botonNuevo){
            interfazJuego.setVisible(false);
            new InterfazIngresarJuego();
        }
    }


    public JButton getBotonNuevo() {
        return botonNuevo;
    }


    public JButton getBotonReiniciar() {
        return botonReiniciar;
    }


    public JButton getBotonTop10() {
        return botonTop10;
    }

    public Top10 getTop10(){
        return top10;
    }
    
}
