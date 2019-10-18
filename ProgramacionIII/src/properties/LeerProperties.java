package properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LeerProperties {
	public static void main(String[] args) {
		Properties properties = new Properties();
		try {
			FileInputStream fis =  new FileInputStream(new File("config.ini"));
			try {
				properties.load(fis);
				
				System.out.println(properties.getProperty("carpeta"));
				System.out.println(properties.getProperty("usuario"));
				
			}catch(IOException e) {
				System.out.println("No se ha podido leer el fivhero" + e.getMessage());
			}finally {
				try {
					fis.close();
				}catch(IOException e) {
					//
				}
				
			}
			
		}catch (FileNotFoundException e){
			System.out.println("No se ha podido encontrar el fichero" + e.getMessage());
			
		}
	}

}
