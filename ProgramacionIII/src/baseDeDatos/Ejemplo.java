package baseDeDatos;
import java.sql.*;

public class Ejemplo {
	public static void main(String[] args) {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection("jdbc:sqlite:data/bbdd");
			Statement st = con.createStatement();
			//Conexion abierta
			//Statement creado
			ResultSet rs = st.executeQuery("SELECT nombre, apellido FROM usuario"); ///Realizar consulta
			while(rs.next()) { //Mientras haya filas en el resultado
				//estoy en una fila del resultado
				String nombre = rs.getString("nombre");  
				String apellido = rs.getString("apellido");
				
				System.out.println(nombre + apellido);
				
			}
			
			
			//Ya no queremos usarlos mas
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			System.out.println("No se ha podido cargar el driver");
		
		}	catch(SQLException e1) {
			System.out.println("No se ha podido contactar con la BD");
		}
	}
}
