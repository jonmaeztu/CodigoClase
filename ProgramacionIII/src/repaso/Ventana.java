package repaso;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ventana {
	
	
	public Ventana() {
		JFrame ventana = new JFrame();
		ventana.setVisible(true);
		ventana.setResizable(true);
		ventana.setSize(500, 500);
		ventana.setLocation(100, 100);
		ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JButton boton = new JButton();
		boton.setVisible(true);
		boton.setSize(100, 100);
		boton.setLocation(100,100);
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
				if(o == boton) {
					System.exit(0);
				}
			}
		});
		ventana.getContentPane().add(boton);
		
	}
	
	public static void main(String[] args) {
		Ventana();
		
	}
	

}
