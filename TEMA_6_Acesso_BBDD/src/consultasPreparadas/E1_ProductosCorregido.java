package consultasPreparadas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class E1_ProductosCorregido {
	


		public static void main(String[] args) {
			String cadena = "jdbc:mysql://localhost:3306/gestionpedidos";
			String usuario = "root";
			String contra = "";

			// Statement miStatement= miConexion.createStatement();

			try {
				Connection miConexion = DriverManager.getConnection(cadena, usuario, contra);
				System.out.println("Conexion establecida con la base de datos: " + miConexion.getCatalog());
				String sentenciaPreparada = "SELECT * FROM PRODUCTOS WHERE SECCION=? AND PAISDEORIGEN=?";
				PreparedStatement miPreparedStatement = miConexion.prepareStatement(sentenciaPreparada);

				String sentenciaSecciones = ("SELECT DISTINCT SECCION FROM PRODUCTOS");
				Statement Secciones = miConexion.createStatement();

				String sentenciaPaises = ("SELECT DISTINCT PAISDEORIGEN FROM PRODUCTOS");
				Statement Paises = miConexion.createStatement();

				String seccion = "";
				String pais = "";
				Scanner sc = new Scanner(System.in);

				while ((!seccion.equals("Salir")) || (!pais.equals("Salir"))) {
					int cont = 0;
					System.out.println("¿Qué sección quieres? ");
					ResultSet rs = Secciones.executeQuery(sentenciaSecciones);
					while (rs.next()) {
						System.out.println(rs.getString(1));
					}
					seccion = sc.nextLine();

					System.out.println("¿Qué país le interesa?");
					rs = Paises.executeQuery(sentenciaPaises);
					while (rs.next()) {
						System.out.println(rs.getString(1));
					}
					pais = sc.nextLine();

					if ((!seccion.equals("Salir")) || (!pais.equals("Salir"))) {
						miPreparedStatement.setString(1, seccion);
						miPreparedStatement.setString(2, pais);

						ResultSet miRs = miPreparedStatement.executeQuery();

						while (miRs.next()) {
							System.out.println("CODIGO: " + miRs.getString(1) + " | NOMBRE DEL ARTICULO: "
									+ miRs.getString(3) + " | PRECIO: " + miRs.getString(4));
							System.out.println("------------------------------------------------------------------------");
							cont++;
						}

						System.out.println("Filas de la query: " + cont);
						miRs.close();
					}
				}

				miPreparedStatement.close();
				miConexion.close();
				sc.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}



