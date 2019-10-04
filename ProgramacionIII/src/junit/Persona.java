package junit;

public class Persona {
	
	String nombre;
	String apellido;
	public Persona(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	
	
	public  String getNombreCompleto() {
		return nombre + " " + apellido;
	}
	
	public static void main(String[] args) {
		Persona p1 = new Persona("Jon", "Maeztu");
		System.out.println(p1.getNombreCompleto());
	}

}
