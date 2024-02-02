package transaccion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Transacc_Clientes_Pedidos2 { // CODIGO DE NACHO

	public static void main(String[] args) {

		// mi programa quiere guardar pedidos. Para ello, debe existir un cliente donde
		// guardar ese pedido.
		// 1º se inserta al cliente y 2º hacer pedido y asignarselo al cliente.

		
		try {
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
			try {
			// CONFIGURAMOS LA BASE DE DATOS PAR ESTABLECER EL AUTOCOMMIT
			miConexion.setAutoCommit(false);// BEGIN TRANSACTION//1 EL SGBD SABE QUE TODO DEBE SER EJECUTADO COMO UNA
											// UNIDAD
			// LOS DATOS CYUANDO ACABE EL BLOQUE DE INSTRUICIONES DEBEN SER INTENGREGOS Y
			// CONSISTENTES.3-SE EJECUTAN AISLADOS(BLOUEOS)
			// LLOS CAMBIOS VAN A SER DURADEROS(DISCO DURO)
			Statement miStatement = miConexion.createStatement();
			String sqlCliente = "INSERT INTO CLIENTES (CÓDIGOCLIENTE,EMPRESA,DIRECCIÓN) VALUES ('ct84','IES CASTELAR','Calle la bomba')";
			System.out.println("CLIENTE NUEVO INSERTADO EN LA BBDD");
			miStatement.executeUpdate(sqlCliente);
			// UNA VEZ QUE EL CLIENTE EXISTE PODEMOS GUARDAR SUS PEDIDOS, ANTES NO
			String sqlPedido = "INSERT INTO PEDIDOS (NÚMERODEPEDIDO,CÓDIGOCLIENTE,FECHADEPEDIDO) VALUES ('82','ct84','12/05/2023')";
			miStatement.executeUpdate(sqlPedido);
			miConexion.commit();// END TRANSACTION
			System.out.println("PEDIDO INSERTADO CORRECTAMENTE EN LA BBDD");
			miStatement.close();
			miConexion.close();
						
			} catch (SQLException es) {
				miConexion.rollback();
				System.out.println();
				es.printStackTrace();
							}
		} catch (Exception e) {
			System.out.println("Errores en la conexióna  la BBDD ");
			
		}
	}

}




