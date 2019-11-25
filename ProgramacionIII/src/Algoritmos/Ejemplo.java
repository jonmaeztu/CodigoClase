package Algoritmos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ejemplo {
	public static void main(String[] args) {
		List<Persona> persona = new ArrayList<Persona>();
		persona.add(new Persona("Juan", "Garcia", 29));
		persona.add(new Persona("Jon", "Maeztu", 19));
		persona.add(new Persona("Unai", "Aguilera", 39));
		
		persona.sort(new Comparator<Persona>() {

			@Override
			public int compare(Persona p1, Persona p2) {
				if(p1.getEdad()<p2.getEdad()){
					return -1;
					
				}else{
					return 1;
				}
				
					
				
			}
		});
		imprimirLista(persona);
		
	}
	/**
	 * 
	 * @param persona
	 */
	
 public static void imprimirLista(List<Persona> persona) {
		for (Persona p : persona) {
			System.out.println(p);
			
		}
	
	}
	

}
