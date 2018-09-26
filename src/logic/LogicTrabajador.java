package logic;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

import model.Trabajador;

public class LogicTrabajador {

	public static String sqlTrabajador;
	public static CachedRowSet consultaTrabajador;
	public static String sqlBorrarTrabajador;

	/**
	 * Genera la consulta Select para toda la tabla trabajador.
	 * 
	 * @throws SQLException
	 */
	public static void dbConsTrabajador() throws SQLException {

		sqlTrabajador = "SELECT*FROM AG_Trabajador";
		consultaTrabajador = logic.LogicPrincipal.consultaGenerica(sqlTrabajador);
	}

	/**
	 * Genera el Delete para la tabla proyecto.
	 * 
	 * @throws SQLException
	 */
	public static void dbBorrarTrabajador() throws SQLException {
		sqlBorrarTrabajador = "DELETE FROM AG_Trabajador WHERE ID_Trabajador = "
				+ controller.CtrlTrabajadores.coordenada + ";";
		databasemanager.DBsqlServer.ejecutarDML(sqlBorrarTrabajador);

	}

	/**
	 * Genera la consulta Select para capturar los datos a editar en la tabla
	 * proyecto.
	 * 
	 * @param coord
	 * @return
	 * @throws SQLException
	 */
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

	}

	/**
	 * Genera el Update para la tabla proyecto.
	 * 
	 * @param coord
	 * @param t
	 * @throws SQLException
	 */
	public static void lgGuardarTrabajador(String coord, Trabajador t) throws SQLException {

		String strSQL = "UPDATE AG_Trabajador SET DNI='" + t.getDNI() + "', Nombre='" + t.getNombreT()
				+ "', Apellidos='" + t.getApellidos() + "', Genero='" + t.getSexo() + "' WHERE ID_Trabajador=" + coord;
		databasemanager.DBsqlServer.ejecutarDML(strSQL);

	}

	/**
	 * Genera el Insert para la tabla proyecto.
	 * 
	 * @param dni
	 * @param nombre
	 * @param apellidos
	 * @param genero
	 * @throws SQLException
	 */
	public static void lgNuevoTrabajador(String dni, String nombre, String apellidos, String genero)
			throws SQLException {

		String strSQL = "insert into AG_Trabajador values ('" + dni + "','" + nombre + "','" + apellidos + "','"
				+ genero + "')";
		System.out.println(strSQL);
		databasemanager.DBsqlServer.ejecutarDML(strSQL);
	}

}
