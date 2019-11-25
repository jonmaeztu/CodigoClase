package Algoritmos;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class EjemploPersona {
	public static void main(String[] args) {
		Persona a = new Persona("Jon", "Maeztu", 19);
		Persona b = new Persona("b", "b", 35);
		Persona c = new Persona("c", "c", 38);
		
		System.out.println("a == a " + (a==a)); // == mira si es el mismo objeto en memoria
		System.out.println("a == b " + (a==b));
		System.out.println("a == c " + (a==c));
		
		System.out.println("a equals a " + (a.equals(a))); 
		System.out.println("a equals b " + (a.equals(b)));
		System.out.println("a equals c " + (a.equals(c)));
		
		
		
		System.out.println("a.hashcode(): " + a.hashCode()); //devuelve el numero en funcion de la instancia, usa a direccion de memoria para calcular el hashcode
		System.out.println("b.hashcode(): " + b.hashCode());
		System.out.println("c.hashcode(): " + c.hashCode());
		
		Map<Persona, Integer> notas = new HashMap<>();
		notas.put(a, 8);
		notas.put(b, 7);
		
		for (Entry<Persona, Integer> mapa: notas.entrySet()) {
			System.out.println(mapa);
		}
		
		

	}

}
