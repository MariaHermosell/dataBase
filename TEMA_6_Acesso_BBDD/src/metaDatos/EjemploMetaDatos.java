package metaDatos;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EjemploMetaDatos {

	public static void main(String[] args) {
		metodoMostrarInfoBBDD(); // Al final llamamos al metodo para que funcione. 
		

	}
static void metodoMostrarInfoBBDD() {
	
	try {
		Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas","root","");
		//obtener los metadatos
		DatabaseMetaData misDatos= miConexion.getMetaData();
		//mostrar datos
		System.out.println("Nombre del SGBD gestor: "+ misDatos.getDatabaseProductName());
		System.out.println("Versión del gestor: "+ misDatos.getDatabaseProductVersion());
		System.out.println("Nombre del Driver: "+ misDatos.getDriverName());
		System.out.println("Versión del Driver: "+ misDatos.getDriverVersion());
		System.out.println("Nivel de aislamiento por defecto: "+ misDatos.getDefaultTransactionIsolation());
		System.out.println("Nombre del SGBD gestor: "+ misDatos.getDatabaseProductName());
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
}
