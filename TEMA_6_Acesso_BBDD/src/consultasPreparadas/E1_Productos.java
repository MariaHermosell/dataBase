package consultasPreparadas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class E1_Productos {

	public static void main(String[] args) {
		// 1- CREA CONEXION:
		String cadena = "jdbc:mysql://localhost:3306/gestionpedidos";
		String usuario = "root";
		String contra = "";

		try {
			// 2- CREAR STATEMENT
			// Statement miStatement = miconexion.createStatement();
			Connection miConexion = DriverManager.getConnection(cadena, usuario, contra);
			System.out.println("Conexión establecida con la base de datos: " + miConexion.getCatalog());
			// 2- CREAR OBJETO PREPAREDSTATEMENT
			String sentenciaPreparada = "SELECT * FROM productos WHERE SECCION=? AND PAISDEORIGEN=?";
			PreparedStatement miPreparedStatement = miConexion.prepareStatement(sentenciaPreparada);
			// MEJORADO, PEDIMOS LA LISTA DE SECCIONES Y PAISES.
			String sentenciaSecciones = ("SELECT DISTINCT SECCION FROM PRODUCTOS");
			Statement Secciones = miConexion.createStatement();
			ResultSet rs = Secciones.executeQuery(sentenciaSecciones);

			Scanner sc = new Scanner(System.in);
			String pais = "";
			String seccion = "";
			while ((!seccion.equals("Exit")) || (!pais.equals("Exit"))) {

				System.out.println("¿Qué sección quieres? ");
				while (rs.next()) {
					System.out.println(rs.getString(1));
				}
				seccion = sc.nextLine();

				String sentenciaPaises = ("SELECT DISTINCT PAISDEORIGEN FROM PRODUCTOS");
				Statement paises = miConexion.createStatement();
				ResultSet rst = paises.executeQuery(sentenciaPaises);
				System.out.println("¿Qué país quieres? ");
				while (rst.next()) {
					System.out.println(rst.getString(1));
				}

				pais = sc.nextLine();

				// PASAMOS LOS VALORES PENDIENTES
				miPreparedStatement.setNString(1, seccion);
				miPreparedStatement.setNString(2, pais);

				// LANZAR LA EJECUCION DE LA SENTENCIA
				ResultSet miRs = miPreparedStatement.executeQuery(); // RESULSET= TABLA VIRTUAL

				// MOSTRAR CONSULTA O QWERY
				System.out.println("La consulta es correcta a continuación se muestran los datos");
				System.out.println("---------------------------------------------------------");
				while (miRs.next()) {// PARA QUE VAYA RECORRIENDO LOS QUE CONTIENE LOS PARAMETROS QUE PASAMOS.
					System.out.println("CODIGO: " + miRs.getString(1) + " NOMBRE DEL ARTICULO: " + miRs.getString(3)
							+ " PRECIO: " + miRs.getString("PRECIO") + "€");
					System.out.println("---------------------------------------------------------");

				}
				miRs.close();
			}

			System.out
					.println("GRACIAS POR CONSULTAR NUESTROS CATALOGOS, SI NO QUIERE NINGUNA CONSULTA MAS ME DESPIDO");

			miPreparedStatement.close();
			miConexion.close();
			sc.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
