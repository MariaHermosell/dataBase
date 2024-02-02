package procedimientosAlmacenados;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JOptionPane;



		public class ModificaPrecios {

			public static void main(String[] args) {
				String cadena="jdbc:mysql://localhost:3306/gestionpedidos";
				String usuario="root";
				String clave="";
				Scanner sc=new Scanner(System.in);
			try {
				Connection miConexion = DriverManager.getConnection(cadena,usuario,clave);
				System.out.println("Conexion establecida");
				CallableStatement miLLamable=miConexion.prepareCall("{call ACTUALIZA_ARTICULO(?,?)}");
				Statement miSt=miConexion.createStatement();
				// PEDIR EL NOMBRE DEL ARTICULO AL USUARIO, 
				//Aquí empieza el bucle si queremos modificar muchos productos
				System.out.println("Digame el nombre del producto que quiere cambiar.");
				ResultSet miRs=miSt.executeQuery("SELECT DISTINCT NOMBREARTICULO FROM PRODUCTOS");
				while(miRs.next()) {
					System.out.println(miRs.getString(1)); //muestro los nombres de los productos
						}
				String articulo=sc.nextLine();// leemos el articulo que quiere cambiar
				//otra forma de leer: 
				//String articulo=JOptionPane.showInputDialog("Introduce el nombre del artículo");
				//Y PEDIRLE EL NUEVO PRECIO A CAMBIAR
				System.out.println("Digame el nuevo precio del articulo "+articulo+" que quiere cambiar.");
				String precio=sc.nextLine();
				miLLamable.setString(1,precio);// Se ordena por orden de creacion.el 1 es el precio porque se creó primero. 
				miLLamable.setString(2,articulo);
				miLLamable.execute();
				// AHORA SERÍA CONVENIENTE UNA COLSULOTA PARA VER QUE SE HA MODIFICADO
				System.out.println("Datos cambiados en la BD");
				System.out.println("");
				miRs=miSt.executeQuery("SELECT * FROM `PRODUCTOS` WHERE NOMBREARTI"
						+ "CULO="+"'"+articulo+"'"+" limit 1"); // Para comprobar que se ha cambiado el precio 
				miRs.next();
				System.out.println("CODIGO: "+miRs.getString(1)+" SECCIÓN :"+miRs.getString(2)+" NOMBRE :"+miRs.getString(3)+" NUEVO PRECOIO :"+miRs.getString(4));
				// Aqui hay que preguntar al usuario si quiere modificar más artículos. 
				
				miLLamable.close();
				miConexion.close();	
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
				
			}

		}
