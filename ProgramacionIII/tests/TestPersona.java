

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import junit.Persona;

class TestPersona {

	@Test
	public void testPersona(){
		Persona p1 = new Persona("Jon", "Maeztu");
		assertEquals("Jon Maeztu", p1.getNombreCompleto());
	}

}
