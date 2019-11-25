package Algoritmos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListSyn {
	public static void main(String[] args) {
		List<Integer> enteros = Collections.synchronizedList(new ArrayList<>());
		List<Integer> noModificable = Collections.unmodifiableList(enteros); //nos da una vista de la lista pero si accedo a traves de la referencia no modificable no puedo modificar la lista
		enteros.add(5);
		enteros.add(3);
		enteros.add(100);
		
		imprimir(enteros);
		
		Collections.shuffle(enteros); //permuta la lista aleatoriamente
		
		imprimir(enteros);
		
		Collections.swap(enteros, 1, 2);
		imprimir(enteros);	
		
		List<Integer> otraLista = new ArrayList();
		otraLista.add(2);
		otraLista.addAll(enteros);
		imprimir(otraLista);
	}
	
	public List<Integer> hacerAlgo(){
		//return new ArrayList<Integer>(); //no es recomendable usar esto
		return Collections.emptyList();
	}
	
	public static void imprimir(List<Integer> enteros) {
		for (Integer integer : enteros) {
			System.out.println(integer + " " + "\n");
			
		}
		
	}
	

}
