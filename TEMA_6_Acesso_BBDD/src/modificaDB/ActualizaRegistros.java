package modificaDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ActualizaRegistros {

	public static void main(String[] args) {
		
		
		//1- establecer conexion
		
		String cadena= "jdbc:mysql://localhost:3306/gestionpedidos";
		String usuario= "root";
		String contra= "";
		
		try {
			
			
			
			Connection miconexion= DriverManager.getConnection(cadena, usuario, contra);
			System.out.println("Conexión establecida");
			
			//2 CREAR OBJETO STATEMENT
			
			Statement miStatement =miconexion.createStatement();
			
			
			
			//3 EJECUTAR LA INSTRUCCION DE actualizacion de filas
			
			String sqlUpdateSentencia="UPDATE clientes SET EMPRESA= 'EL ESPAÑOLAZO' WHERE CÓDIGOCLIENTE= 'CT03'";
			 miStatement.executeUpdate(sqlUpdateSentencia);
			
			//executeUpdate(sqlUpdateSentencia);
			System.out.println("EL cliente CT03 ha sido actualizado correctamente");
			
			
			//4- CERRAR CONEXIONES Y FLUJOS ABIERTOS
			
			System.out.println("Cerrando Statement");
		
			
					
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
