package interfazDeUsuario;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uniandes.dpoo.taller4.modelo.Top10;

public class LabelInferiorIngreso extends JPanel {
	
	private JButton botonIngresar;
	private BotonTop10 botonTop10;
	public LabelInferiorIngreso(Top10 top10) {
		
		top10.cargarRecords(new File("./data/top10.csv"));
		botonTop10 = new BotonTop10(top10);

		setLayout(new BorderLayout());
		
		botonIngresar = new JButton("Ingresar Juego");
		
		
		add(new JLabel("Presiona el boton para ingresar al juego:"), BorderLayout.NORTH);
		add(botonIngresar, BorderLayout.CENTER);
		add(botonTop10.getBoton(),BorderLayout.SOUTH);
	
	}

	public JButton getBotonIngresar() {
		return botonIngresar;
	}
	
}