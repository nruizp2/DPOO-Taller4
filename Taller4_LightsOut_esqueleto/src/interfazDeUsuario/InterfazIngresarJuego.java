package interfazDeUsuario;

import javax.swing.*;

import uniandes.dpoo.taller4.modelo.Top10;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class InterfazIngresarJuego extends JFrame{
	private LabelSuperiorIngreso labelSuperiorIngreso;
	private LabelIzquierdoIngreso labelIzquierdoIngreso;
	private LabelInferiorIngreso labelInferiorIngreso;
	private LabelDerechoIngreso labelDerechoIngreso;

	private Top10 top10;

	public static void main(String[] args) {
		new InterfazIngresarJuego();
	}
	
	public InterfazIngresarJuego(){
		top10 = new Top10();
		top10.cargarRecords(new File("./data/top10.csv"));

		labelSuperiorIngreso = new LabelSuperiorIngreso();
		labelIzquierdoIngreso = new LabelIzquierdoIngreso();
		labelInferiorIngreso = new LabelInferiorIngreso(top10);
		labelDerechoIngreso = new LabelDerechoIngreso();

		setTitle("Ingresar al juego");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(350,250);
		
		setLayout(new BorderLayout());
        add(labelSuperiorIngreso, BorderLayout.NORTH);
        add(labelIzquierdoIngreso, BorderLayout.WEST);
        add(labelInferiorIngreso, BorderLayout.SOUTH);
        add(labelDerechoIngreso, BorderLayout.EAST);
		
		labelDerechoIngreso.setPreferredSize(new Dimension(150, 100));
		labelIzquierdoIngreso.setPreferredSize(new Dimension(150, 100));
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screenSize.width - getWidth()) / 2;
		int y = (screenSize.height - getHeight()) / 2;
		setLocation(x, y);
		
		setVisible(true);
		setResizable(false);

		labelInferiorIngreso.getBotonIngresar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(labelSuperiorIngreso.getNombreJugador().length() > 0 && labelIzquierdoIngreso.getTamanio() != -1 && labelDerechoIngreso.getDificultad()>0){
					int tamanioTablero = labelIzquierdoIngreso.getTamanio();
					int dificultad = labelDerechoIngreso.getDificultad();
					String nombreJugador = labelSuperiorIngreso.getNombreJugador();
					setVisible(false);
					new InterfazJuego(tamanioTablero,top10,dificultad,nombreJugador);
				}
				else{
					JOptionPane.showMessageDialog(labelInferiorIngreso, "Rellene correctamente los parametros pedidos");
				}
			}
		});

	}

}
