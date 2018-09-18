package logic;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

import model.Trabajador;

public class LogicTrabajador {

	public static String sqlTrabajador;
	public static CachedRowSet consultaTrabajador;
	public static String sqlBorrarTrabajador;

	public static void dbConsTrabajador() throws SQLException {

		sqlTrabajador = "SELECT*FROM AG_Trabajador";
		consultaTrabajador = logic.LogicPrincipal.consultaGenerica(sqlTrabajador);
	}

	public static void dbBorrarTrabajador() throws SQLException {
		sqlBorrarTrabajador = "DELETE FROM AG_Trabajador WHERE ID_Trabajador = "
				+ controller.CtrlTrabajadores.coordenada + ";";
		databasemanager.DBsqlServer.ejecutarDML(sqlBorrarTrabajador);

	}

	public static Trabajador dbEditarTrabajador(String coord) throws SQLException {

		String strSQL = "SELECT * FROM AG_Trabajador WHERE ID_Trabajador=" + coord;
		CachedRowSet resultado = logic.LogicPrincipal.consultaGenerica(strSQL);
		resultado.next();
		Trabajador t = new Trabajador();
		t.setDNI(resultado.getString("DNI"));
		t.setNombreT(resultado.getString("Nombre"));
		t.setApellidos(resultado.getString("Apellidos"));
		t.setSexo(resultado.getString("Genero"));

		return t;

		/*
		 * sqlEditarTrabajador = "UPDATE FROM AG_Trabajador WHERE ID_Trabajador = " +
		 * controller.CtrlTrabajadores.coordenada + ";";
		 * databasemanager.DBsqlServer.ejecutarDML(sqlEditarTrabajador);
		 */

	}

	public static void lgGuardarTrabajador(String coord, String dni, String nombre, String apellido, String genero)
			throws SQLException {

		String strgSQL = "UPDATE AG_Trabajador SET DNI=" + dni + ", Nombre=" + nombre + ", Apellidos=" + apellido
				+ ", Genero=" + genero + "WHERE ID_Trabajador=" + coord;
		System.out.println(strgSQL);
		databasemanager.DBsqlServer.ejecutarDML(strgSQL);

	}

}
