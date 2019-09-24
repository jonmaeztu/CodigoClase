package repaso;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ventana extends JFrame {
	
	
	public Ventana() {
		this.setTitle("Ventana");
		this.setSize(500, 500);
		this.setLocation(100, 100);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		this.getContentPane().add(boton);
		
	}
	
	public static void main(String[] args) {
		Ventana v = new Ventana();
		v.setVisible(true);
		v.setResizable(false);
		System.out.println("Hola mundo");
			
	}
	

}
