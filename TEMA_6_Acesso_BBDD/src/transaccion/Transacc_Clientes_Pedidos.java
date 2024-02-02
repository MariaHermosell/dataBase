package transaccion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Transacc_Clientes_Pedidos {

	public static void main(String[] args) {
	//mi programa quiere guardar pedidos. Para ello, debe existir un cliente donde guardar ese pedido. 
	// 1º se inserta al cliente y 2º hacer pedido y asignarselo al cliente. 
	
		try {
			
			Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas","root","");
			//CONFIGURACION DE LA BB PARA ESTABLECER EL AUTOCOMMIT.. Es lo mismo que BEGIN TRANSACTION. 1- EL SGBD sabe que todo debe ser ejecutado como una unidad(ATOMICIDAD)
			//2- Los datos cuando acabe el bloque de instrucciones deben ser integros y consistentes (CONSISTENCIA)
			//3- Se ejecutan aislados (BLOQUEO) (AISLAMIENTO)
			//4- Los cambios van a ser duraderos (DISCO DURO)(DURABILIDAD)
			miConexion.setAutoCommit(false); // Aqui lo desactivamos. Por defecto lo trae True
			
			Statement miStatement= miConexion.createStatement();
			//1 Insertar un nuevo cliente
			// CREO sentencia sql
			String sqlCliente="INSERT INTO CLIENTES (CÓDIGOCLIENTE,EMPRESA, DIRECCIÓN) VALUES ('pi93', 'IES CASTELAR','Calle La Bomba')"; 
			System.out.println("CLIENTE NUEVO INSERTADO EN LA BASE DE DATOS");
			// Ejecuto la sentencia SQL
			miStatement.executeUpdate(sqlCliente);
			
			// INSERTO EL PEDIDO
			String sqlPedido= "INSERT INTO PEDIDOS (NÚMERODEPEDIDO,CÓDIGOCLIENTE,FECHADEPEDIDO) VALUES(83,'pi93','12/05/2023')" ;// EL CODIGO DE CLIENTE DEBE EXISTIR
			miStatement.executeUpdate(sqlPedido);// lo ejecuto para que se lleve a cabo
			miConexion.commit(); // END TRANSACTION
			System.out.println("PEDIDO INSERTADO CORRECTAMENTE EN LA BASE DE DATOS");// indico al usuario que está insertado. 
			miStatement.close();
			miConexion.close();
			
		} catch (SQLException e) {
			
			System.out.println("Errores en la inserción en la Base de datos");
			e.printStackTrace();
		}
		

	
	
	
	}
	
	
	
	

}
