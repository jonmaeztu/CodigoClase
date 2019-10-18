package ejemploSerializacion;

import java.io.Serializable;

public class Alumno implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1897063723111447376L;
	private String nombre, apellido;
	
	public Alumno() {
		//SIEMPRE PONER CONSTRUCTOR VACIO Y PUBLICO
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	

}
