package ejemploSerializacion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Ejemplo {
	public static void main(String[] args) {
		Alumno a = new Alumno();
		a.setNombre("jon");
		a.setApellido("maeztu");
		
		
		try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(new File("datos.bin")))) {
			os.writeObject(a);
		}catch(FileNotFoundException e) {
			System.out.println("No se ha encontrado el fichero");
		}catch(IOException e) {
			System.out.println("No se ha podido serializar el objeto");
		}
	}

}
