package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class E0_ConectaDB {

	public static void main(String[] args) {
		//1-  CREAR CONEXIÓN 
		String cadena= "jdbc:mysql://localhost:3306/gestionPedidos"; // Esta es la cadena de conexión normalmente, lo que suele cambiar es el nombre de la BBDD. 
		
		String usuario= "root";
		String contra= ""; 
		try {
			Connection miConexion=DriverManager.getConnection(cadena,usuario,contra);
			System.out.println("Conexión establecida");
			
		//2- CREAR OBJETO STATEMENT (LO HAREMOS DENTRO DEL BLOQUE TRY) 
			Statement miStatement= miConexion.createStatement();
			
		//3- CREAR UNA CONSULTA, UNA QWERY (DENTRO DEL TRY)
		ResultSet miResultSet=miStatement.executeQuery("SELECT * FROM PRODUCTO");
		
		//4- PROCESAR LA QWERY
			
			
			
		} catch (SQLException e) {
			
			
			e.printStackTrace();
		}
	}

}
