package recursividad;


public class Ejemplos {
	public static void main(String[] args) throws Exception {
		
		System.out.println(Ejemplos.factorialErrores(5));
		System.out.println(Ejemplos.fibonacciErrores(8));
		
	}
	
	private static int factorialErrores(int numero) throws Exception{
		if(numero < 0) {
			throw new Exception("Error");
		}
		
		return factorial(numero);
	}
	
	
	
	private static  int factorial(int numero) {
		//caso base
		
		if(numero == 1 || numero == 0) {
			return 1;
			
		}else if(numero > 1) {
			return numero * factorial(numero -1 );
		}
		
		return 0;
	}
	
	private static int fibonacciErrores(int numero)throws Exception {
		if(numero <0) {
			throw new Exception("Error");
		}
		
		return fibonacci(numero);
	}
	
	private static int fibonacci(int numero) {
		//caso base
		if(numero == 0) {
			return 0;
		}
		if(numero == 1 ) {
			return 1;
		}else {
			return fibonacci(numero-1) + fibonacci(numero-2);
		}
		
	}

}
