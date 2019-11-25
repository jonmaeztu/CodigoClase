package utilidadesJava;

public class Ejemplo {
	public static void main(String[] args) {
		sumar(3,5,7,8);
		
		
	}
	
	public static int sumar(Integer...enteros) {
		int suma = 0;
		for (Integer integer : enteros) {
			suma+= integer;
			
		}
		
		return suma;
	}

}
