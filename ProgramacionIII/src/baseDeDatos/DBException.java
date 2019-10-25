package baseDeDatos;

public class DBException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4998198040568530312L;
	
	public DBException(String mensaje, Throwable e) {
		super(mensaje, e);
	}
	
}
