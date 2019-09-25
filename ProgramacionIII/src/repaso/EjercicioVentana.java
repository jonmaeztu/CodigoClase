package repaso;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class EjercicioVentana extends JFrame {
	
	private final static int MIN = 0;
	private final static int MAX = 100;
	int contador = 0; long contador_hilo = 0;
	
	public EjercicioVentana() {
		//Creacion de la ventana
		this.setTitle(" Ventana ");
		this.setSize(500, 500);
		this.setBackground(Color.WHITE);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		
		JProgressBar barra = new JProgressBar(MIN, MAX);
		
		JButton boton = new JButton(" Acaba ");
		boton.setVisible(true);
		boton.setSize(100, 100);
		boton.setLocation(100,100);
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
				Thread hilo = new Thread(new Runnable() {
					
					@Override
					public void run() {
						if(o == boton) {
							while(contador <= MAX) {
								try {
									Thread.sleep(contador_hilo+100);
								}catch(Exception e1) {
									
								}
								if(contador_hilo == 1000) {
									contador+=20;						
									barra.setBackground(Color.BLACK);
									
									barra.setValue(contador);
								}
							}
							System.exit(0);
						}
						
					}
				});
				hilo.start();
				
				
			}
		});
		
		JPanel panelContenidos = new JPanel();
		
		panelContenidos.add(boton);
		panelContenidos.add(barra);
		
		this.getContentPane().add(panelContenidos);
	}
	
	public static void main(String[] args) {
		new EjercicioVentana();
	}
	

}
