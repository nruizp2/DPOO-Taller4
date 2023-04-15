package interfazDeUsuario;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.SwingConstants;

import uniandes.dpoo.taller4.modelo.RegistroTop10;
import uniandes.dpoo.taller4.modelo.Top10;

public class BotonTop10 {

    private JButton boton;

    public BotonTop10(Top10 top10) {
        boton = new JButton("TOP 10");
        boton.setBackground(Color.decode("#2a89e0"));

        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JDialog panel = new JDialog();
                Collection<RegistroTop10> data = top10.darRegistros();
                ArrayList<String> array = new ArrayList<String>();
                for (RegistroTop10 elemento : data) {
                    array.add(elemento.toString());
                }

                JList<String> lista = new JList<String>(array.toArray(new String[array.size()]));
                lista.setCellRenderer(new Top10ListRenderer()); 

                panel.add(lista);
                panel.pack();

                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                int x = (screenSize.width - panel.getWidth()) / 2;
                int y = (screenSize.height - panel.getHeight()) / 2;
                panel.setLocation(x, y);
                panel.setVisible(true);
                panel.setResizable(false);
            }
        });

    }

    public JButton getBoton() {
        return boton;
    }

}

class Top10ListRenderer extends DefaultListCellRenderer {

    private static final long serialVersionUID = 1L;

    public java.awt.Component getListCellRendererComponent(javax.swing.JList<?> list, Object value, int index,
            boolean isSelected, boolean cellHasFocus) {

        String texto = value.toString();
        java.awt.Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        renderer.setFont(new Font("Arial", Font.BOLD, 16)); 
        renderer.setForeground(Color.BLUE); 
        ((javax.swing.JLabel) renderer).setHorizontalAlignment(SwingConstants.CENTER); 

        
        if (index == 0) {
            renderer.setBackground(Color.YELLOW); 
            texto = "<html><b>" + texto + "</b></html>"; 
        }

        ((javax.swing.JLabel) renderer).setText(texto);
        return renderer;
    }
}
