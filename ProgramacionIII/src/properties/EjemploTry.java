package properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class EjemploTry {
	public static void main(String[] args) {
		
		try(FileInputStream fis = new FileInputStream("config.init")){
			Properties p = new Properties();
			p.load(fis);
			System.out.println(p.getProperty("usuario"));
			//Fichero abierto
		}catch(FileNotFoundException e) {
			//Fichero no abierto
			System.out.println("No se ha podido encontrar el fichero");
		}catch (IOException e) {
			System.out.println("No se ha podido leer del ficherp");
		}
	}

}
