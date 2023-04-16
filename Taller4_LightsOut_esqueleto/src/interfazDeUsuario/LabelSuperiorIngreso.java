package interfazDeUsuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LabelSuperiorIngreso extends JPanel {
    private JTextField campoNombre;
    private JButton botonGuardar;
    private String nombreJugador;

    public LabelSuperiorIngreso() {
        setLayout(new BorderLayout());

        JLabel labelTitulo = new JLabel("Ingrese su nombre de jugador:");
        labelTitulo.setHorizontalAlignment(JLabel.CENTER);

        campoNombre = new JTextField();
        botonGuardar = new JButton("Guardar nombre");
        botonGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarNombre();
            }
        });

        JPanel panelCentro = new JPanel(new GridLayout(2, 1, 1, 1));
        panelCentro.add(labelTitulo);
        panelCentro.add(campoNombre);

        JPanel panelSur = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelSur.add(botonGuardar);

        add(panelCentro, BorderLayout.CENTER);
        add(panelSur, BorderLayout.SOUTH);

        nombreJugador = "";
    }

    private void guardarNombre() {
    	if (campoNombre.getText().length() > 0) {
        nombreJugador = campoNombre.getText();
        JOptionPane.showMessageDialog(this, "Nombre guardado: " + nombreJugador);
        botonGuardar.setEnabled(false);}
    }

    public String getNombreJugador() {
        return nombreJugador;
    }
}
