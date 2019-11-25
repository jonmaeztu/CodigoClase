package baseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class DataBaseManager {
	private  Connection con = null;
	
	
	public void connect() throws DBException {
		try {
			Class.forName("or.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:data/ejemplo.bd");
		}catch(ClassNotFoundException e) {
			throw new DBException("No se pudo cargar el driver", e);
		}catch(SQLException e) {
			throw new DBException("No se ha podido conectar a la BD", e);
		}
	}
	
	public void disconnect() throws DBException{
		try {
			if (con != null) {
				con.close();
			}
		}catch(SQLException e) {
			throw new DBException("No se ha podido cerrar la conecion a la BD", e);
		}
	}
	
	public void crearTablaUsuario() throws DBException{
		try (	Statement st = con.createStatement()){ // se cierra si no va bien (te ahorras el st.close) 
			String sql = "CREATE TABLE usuario (id INTEGER PRIMARY KEY, nombre VARCHAR, apellido VARCHAR )";
			st.executeUpdate(sql);
		
		}catch(SQLException e) {
			throw new DBException("No se pudo crear la tabla 'usuario'", e);
			
		}
		
		
	}
	
	public void borrarTablaUsuario() throws DBException{
		try(Statement st = con.createStatement()){
			String sql = "DROP TABLE usuario";
			st.executeUpdate(sql);
		}catch(SQLException e) {
			throw new DBException("No se pudo crear la tabla 'usuario'", e);
		}
		
	}
	
	
	public List<Usuario> obtenerTodosUsuarios() throws DBException{
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		try(Statement st = con.createStatement()){
			ResultSet rs = st.executeQuery("SELECT id, nombre, apellido FROM usuario");
			while(rs.next()) { //mientras haya objetos
				Usuario u = new Usuario();
				u.setId(rs.getInt("id"));
				u.setNombre(rs.getString("nombre"));
				u.setApellido(rs.getString("apellido"));
				
				usuarios.add(u);
			}
			
		}catch(SQLException e) {
			throw new DBException("No se pudo osbtener la lista de la tabla 'usuario'", e);
		}
		
		return usuarios;
		
	}
	
	public  Usuario obtenerUsuario(int id) throws DBException{
		try (Statement st = con.createStatement()){
			String sql = "SELECT id, nombre, apellido FROM usuario WHERE id" + id;
			ResultSet rs =st.executeQuery(sql);
			if(rs.next()) {  //Si hay resultados de esta consulta
				Usuario u = new Usuario();
				u.setId(rs.getInt("id"));
				u.setNombre(rs.getString("nombre"));
				u.setApellido(rs.getString("apellido"));
				
				return u;
				
			}else {
				return new Usuario();
			}
			
		}catch(SQLException e) {
			throw new DBException("No se pudo obtener el usuario con id" + id, e);
		}
	}
	
	public  List<Usuario> obtenerUsuario(String apellido) throws DBException{
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try (Statement st = con.createStatement()){
			
			//SELECT id, nombre, apellido FROM usuario WHERE apellido = 'jimenez'
			String sql = "SELECT id, nombre, apellido FROM usuario WHERE apellido='" + apellido + "'";
			ResultSet rs =st.executeQuery(sql);
			while(rs.next()) {  //Si hay resultados de esta consulta
				Usuario u = new Usuario();
				u.setId(rs.getInt("id"));
				u.setNombre(rs.getString("nombre"));
				u.setApellido(rs.getString("apellido"));
				usuarios.add(u);
				
			}
			
		}catch(SQLException e) {
			throw new DBException("No se pudo obtener el usuario con apellido" + apellido, e);
		}
		
		return usuarios;
	}
	
	public  List<Usuario> obtenerUsuario(String nombre, String apellido) throws DBException{
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try (Statement st = con.createStatement()){
			
			//SELECT id, nombre, apellido FROM usuario WHERE apellido = 'jimenez'
			String sql = "SELECT id, nombre, apellido FROM usuario WHERE apellido='" + apellido + "' AND nombre='" + nombre + "'";
			ResultSet rs =st.executeQuery(sql);
			while(rs.next()) {  //Si hay resultados de esta consulta
				Usuario u = new Usuario();
				u.setId(rs.getInt("id"));
				u.setNombre(rs.getString("nombre"));
				u.setApellido(rs.getString("apellido"));
				usuarios.add(u);
				
			}
			
		}catch(SQLException e) {
			throw new DBException("No se pudo obtener el usuario con apellido" + apellido, e);
		}
		
		return usuarios;
	}
	
	public void guardar(Usuario u) throws DBException {
		 
		try (Statement st = con.createStatement()){
			String sql = "INSERT INTO usuario (id, nombre, apellido) VALUES (" + u.getId() + ", '" + u.getNombre() + "','" + u.getApellido() + "`)";
			st.executeUpdate(sql);
			
		}catch(SQLException e) {
			throw new DBException("Error al insertar usuario", e);
		}
		
		
	}
//Con prepared Statement
	public void guardarPST(Usuario u) throws DBException {
		String sql = "INSERT INTO usuario (id, nombre, apellido) VALUES (?, ?, ?)"; //Las posiciones empiecan en 1
		
		try (PreparedStatement st = con.prepareStatement(sql)){
			st.setInt(1, u.getId());
			st.setString(2, u.getNombre());
			st.setString(3, u.getApellido());
			
			st.executeUpdate(sql);
			
		}catch(SQLException e) {
			throw new DBException("Error al insertar usuario", e);
		}
		
		
	}
	
	//VALE PARA EL LOGIN EN EL PROYECTO, SI NO OBTIENE EL USUARIO SALTA EL CATCH 
	public  List<Usuario> obtenerUsuarioPST(String nombre, String apellido) throws DBException{
		List<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = "SELECT id, nombre, apellido FROM usuario WHERE nombre=? AND apellido = ?";

		try (PreparedStatement st = con.prepareStatement(sql)){
			st.setString(1, nombre);
			st.setString(2, apellido);
			
			
			//SELECT id, nombre, apellido FROM usuario WHERE apellido = 'jimenez'
			ResultSet rs =st.executeQuery();
			while(rs.next()) {  //Si hay resultados de esta consulta
				Usuario u = new Usuario();
				u.setId(rs.getInt("id"));
				u.setNombre(rs.getString("nombre"));
				u.setApellido(rs.getString("apellido"));
				usuarios.add(u);
				
				
				
			}
			
		}catch(SQLException e) {
			throw new DBException("No se pudo obtener el usuario con apellido" + apellido, e);
			
		}
		
		return usuarios;
	}
	
	
	//SELECT login FROM usuario WHERE login='" + user + "' AND  password ='" + pass + "';
	
	
	
	
	
		

	
	
	
}
