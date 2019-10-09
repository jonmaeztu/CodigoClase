package junit;

public class CalculadoraImpl implements Calculadora {

	@Override
	public  int sumar(int a, int b) {
		
		return a + b;
	}

	@Override
	public int restar(int a, int b) {
		
		 return a - b;
	}

	@Override
	public int multiplicar(int a, int b) {
		// TODO Auto-generated method stub
		return a*b;
	}

	@Override
	public boolean esPar(int a) {
		
		
		if (a%2==0) return true ;
		else return false;
		
	}

	@Override
	public double cuadrado(int a) {
		// TODO Auto-generated method stub
		return Math.pow(a, 2.0);
	}
	

}
