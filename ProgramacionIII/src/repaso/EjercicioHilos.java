package repaso;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class EjercicioHilos {
	private static List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>()); //Arraylist preparado pars que dos hilos a la vez puedan hacer cosas sobre el	
	
	public static void main(String[] args) {
		Thread tInsert = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					list.add(5);
					System.out.println("Añadido 5 - " + list);
				}
				
			}
		});
		tInsert.start();
		Thread tRemove = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					if(!list.isEmpty()) {
						list.remove(0);
						System.out.println("Eliminado  - " + list);
					}
				}
			}
		});
		tRemove.start();
	}
	
	
	

}
