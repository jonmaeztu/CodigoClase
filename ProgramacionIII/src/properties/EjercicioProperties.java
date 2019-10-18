package properties;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class EjercicioProperties {
	
	public static void main(String[] args) {
		salida();
		
		
	}

	private static void salida() {
		Properties properties = new Properties();
		properties.setProperty("carpeta", "c:\\users\\all\\datos");
		properties.setProperty("usuario", "maria");
		properties.setProperty("ventana", "640,680");
		
		try {
			FileOutputStream fos = new FileOutputStream(new File("config,ini"));;
			try {
				properties.store(fos, "Esto es un ejemplo de configuracion");
			}catch(IOException e) {
				System.out.println("No se ha podido escribir en el fichero" + e.getMessage());
			}finally {
				try {
					fos.close();
				}catch(IOException e) {
					
				}
			}
			
		
		
		} catch (FileNotFoundException e) {
			System.out.println("No se ha podido abrir el fichero" + e.getMessage());
		}
	}
	
	
	
}
