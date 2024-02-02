package modificaDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BorrarFilas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String cadena = "jdbc:mysql://localhost:3306/gestionpedidos";
		String usuario = "root";
		String contra ="";
		
		try {
			Connection miConexion = DriverManager.getConnection(cadena, usuario, contra);
			System.out.println("Conexion establecida");
			
			Statement miStatement = miConexion.createStatement();
			
			String sentenciaDeBorrado = "DELETE FROM PRODUCTOS WHERE CÓDIGOARTICULO='AR02'";
			miStatement.execute(sentenciaDeBorrado);
			System.out.println("Producto borrado adecuadamente de la tabla");
			
			}catch (SQLException e){
			e.printStackTrace();			
		}
	}


}
