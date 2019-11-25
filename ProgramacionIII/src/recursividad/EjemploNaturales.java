package recursividad;

public class EjemploNaturales {
	public static void main(String[] args) {
		imprimir(10);
		
	}
	
	public static void imprimir(int n) {
		System.out.println(n);
		if(n > 0) {
			imprimir(n-1);
		}
		
	}
	
	

}
