import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import junit.CalculadoraImpl;

class TestCalculadoraImpl {
	private CalculadoraImpl c;
	
	
	@Before
	public void setUp() { //Sirve `para hacer algo común con los test. En este caso llamar a la clase calduladoraImpl
		c = new CalculadoraImpl();
		System.out.println("Se ha llamado al setUp");
	}

	@Test
	public void sumarTest(){
		assertEquals(5, c.sumar(3, 2));
		
	}
	
	@Test
	public void restarTest(){
		assertEquals(7, c.restar(10, 3));
		
	}
	
	@Test
	public void multiplicarTest(){
		assertEquals(30, c.multiplicar(6, 5));
		
	}
	
	@Test
	public void esParTest(){
		assertTrue(c.esPar(6));
		
	}
	
	@Test
	public void cuadradoTest() {
		assertEquals(9.0, c.cuadrado(3), 0.1);
	}
	

}
