package modificaDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertarFilas {

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
					
					//3 EJECUTAR LA INSTRUCCION DE INSERTAR  filas
					
					// Se podrían pedir los datos a insetar al usuario por teclado, y  con ello montar esta cadena. 
					
					String sentenciaSQLInserta="INSERT INTO productos(CÓDIGOARTICULO, NOMBREARTICULO, PRECIO) VALUES('AR42', 'MARTILLO PILÓN','20'), ('AR43', 'DESTORNILLADOR', '15,14')";
					 miStatement.executeUpdate(sentenciaSQLInserta);
					 System.out.println("Fila insertada correctamente en la BBDD: "+ miconexion.getCatalog());
					
					
					
					//4- CERRAR CONEXIONES Y FLUJOS ABIERTOS
						
						System.out.println("Cerrando Statement");
						miStatement.close();
						System.out.println("Cerrando conexión con la base de datos: "+  miconexion.getCatalog());
						miconexion.close();
					
					
				} catch (SQLException e) {
					e.printStackTrace();
					
				}
		
		

	}

}
