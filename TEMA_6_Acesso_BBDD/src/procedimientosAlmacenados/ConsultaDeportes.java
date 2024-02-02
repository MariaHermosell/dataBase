package procedimientosAlmacenados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConsultaDeportes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String cadena = "jdbc:mysql://localhost:3306/gestionpedidos";
		String usuario = "root";
		String contra = "";
		
		
		try {
			Connection miConexion=DriverManager.getConnection(null);
			//Statement// Para crear qwery/ consultas
			//PreparedStatement // PAra hacer consultas preparadas. 
			//CallableStatement 
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
