package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class E2_ConectaDB {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String cadena = "jdbc:mysql://localhost:3306/gestionpedidos";
		String usuario = "root";
		String contra = "";

		try {
			// CREAR CONEXIÓN
			Connection miconexion = DriverManager.getConnection(cadena, usuario, contra);
			System.out.println("Conexión establecida.");
			// CREAR STATEMENT
			Statement miStatement = miconexion.createStatement();
			// CREAR INSTRUCCIÓN SQL
			ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM PRODUCTOS");

			/*
			 * Esto no es de nacho, lo he hecho yo porque yolo while (miResultSet.next()) {
			 * String codigo = miResultSet.getString("CODIGOARTICULO"); String seccion =
			 * miResultSet.getString("SECCION"); String nombre =
			 * miResultSet.getString("NOMBREARTICULO"); String precio =
			 * miResultSet.getString("PRECIO"); String fecha =
			 * miResultSet.getString("FECHA"); String importado =
			 * miResultSet.getString("IMPORTADO"); String pais =
			 * miResultSet.getString("PAISDEORIGEN"); System.out.println(codigo + ", " +
			 * seccion + ", " + nombre + ", " + precio + ", " + fecha + ", " + importado +
			 * ", " + pais); }
			 */

			System.out.println("Conexión establecida con éxito.");
			System.out.println("MOSTRANDO DATOS TABLA PRODUCTOS:");
			// Con esto sacas por pantalla los registros almacenados en la base de datos. El
			// número del .getString() es el número de la columna que quieres sacar por
			// pantalla. También vale poner el nombre exacto de la columna entre comillas.
			while (miResultSet.next()) {
				System.out.println("CODGO ARTICULO: " + miResultSet.getString(1) + " | SECCIÓN: "
						+ miResultSet.getString("SECCION") + " | NOMBRE ARTÍCULO: " + miResultSet.getString(3)
						+ " | PAÍS: " + miResultSet.getString(4));
			}

			System.out.println("CERRANDO RESULT SET");
			miResultSet.close();
			System.out.println("CERRANDO CONEXION CON LA BASE DE DATOS: " + miconexion.getCatalog());
			miconexion.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}


