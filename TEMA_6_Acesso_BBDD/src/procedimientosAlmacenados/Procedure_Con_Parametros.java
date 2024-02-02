package procedimientosAlmacenados;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Procedure_Con_Parametros {

	public static void main(String[] args) {
		// ESTE EJERCICIO ES IGUAL QUE EL DE MODIFICARPRECIOS
		try {
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionpedidos","root","");
			//hay que pasar los parámetros de conexion. los paso aquí, pero se pueden hacer en un fichero
			CallableStatement miStatement= miConexion.prepareCall("{call ACTUALIZA_ARTICULO(?,?)}");
			String parametro1="80"; // Aquí pasamos el precio nuevo
			String parametro2= "SERRUCHO";// Aqui el nombre de producto al que se le asigan ese precio nuevo 
			
			miStatement.setString(1,parametro1 ); // llamo a miStatement y le paso los parámetros. En este caso el 1
			miStatement.setString(2,parametro2); // llamo a miStatement y le paso los parámetros. En este caso el parámetro 2
			System.out.println("Preparados para cambiar el precio del "+ parametro2+ " a nuevo precio de "+ parametro1);
			
			miStatement.execute();
			
			System.out.println("Su precio se ha actualizado");
			
			//CERRAMOS FLUJOS
			miStatement.close();
			miConexion.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
