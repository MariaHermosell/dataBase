package Conexion;
import java.sql.*;
public class E1_ConectaDB {
	

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			String cadena = "jdbc:mysql://localhost:3306/gestionpedidos";
			String usuario = "root";
			String contra="";
			
			try {
				//CREAR CONEXIÓN
				Connection miconexion=DriverManager.getConnection(cadena,usuario,contra);
				System.out.println("Conexión establecida.");
				//CREAR STATEMENT
				Statement miStatement=miconexion.createStatement();
				//CREAR INSTRUCCIÓN SQL
				ResultSet miResultSet = miStatement.executeQuery("SELECT * FROM PRODUCTOS");
				
				//Esto no es de nacho, lo he hecho yo porque yolo 
				while (miResultSet.next()) {
	                String codigo = miResultSet.getString("CÓDIGOARTICULO");
	                String seccion = miResultSet.getString("SECCION");
	                String nombre = miResultSet.getString("NOMBREARTICULO");
	                String precio = miResultSet.getString("PRECIO");
	                String fecha = miResultSet.getString("FECHA");
	                String importado = miResultSet.getString("IMPORTADO");
	                String pais = miResultSet.getString("PAISDEORIGEN");
	                System.out.println(codigo + ", " + seccion + ", " + nombre + ", " + precio + ", " + fecha + ", " + importado + ", " + pais);
	            }
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			

		}

	}



