package databasemanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class DBsqlServer {

	public static String cadenaConexion;

	/**
	 * Comprueba si se ha establecido o no la conexion
	 * 
	 * @return test
	 */
	public static boolean testConexion() {
		boolean test = false;
		try {
			Connection c = establecerConexion();
			cerrarConexion(c);
			test = true;
		} catch (Exception e) {

			test = false;

		}

		return test;
	}

	/**
	 * Crea la cadena de conexion con los parametros introducidos a mano desde el
	 * cuadro de dialogo parametros.
	 */
	public static void crearCadenaConexion(String strIP, String strPort, String strDatabaseName, String strUserName,
			String strUserPassword) {

		String cadena = "jdbc:sqlserver:";
		cadena += "//" + strIP;
		cadena += ":" + strPort;
		cadena += ";database=" + strDatabaseName;
		cadena += ";user=" + strUserName;
		cadena += ";password=" + strUserPassword;

		cadenaConexion = cadena;
	}

	/**
	 * Manda la cadena de conexion para establecer dicha conexion con el servidor.
	 * 
	 * @return getConexion
	 * @throws SQLException
	 */
	public static Connection establecerConexion() throws SQLException {
		return DriverManager.getConnection(cadenaConexion);

	}

	/**
	 * Cierra la conexion.
	 * 
	 * @param conn
	 * @throws SQLException
	 */
	public static void cerrarConexion(Connection conn) throws SQLException {
		conn.close();
	}

	/**
	 * Ejecuta una consulta en SQL.
	 * 
	 * @param strSQL
	 * @return rowset
	 * @throws SQLException
	 */
	public static CachedRowSet consultaSQL(String strSQL) throws SQLException {
		Connection c = databasemanager.DBsqlServer.establecerConexion();
		Statement s = c.createStatement();
		ResultSet r = s.executeQuery(strSQL);
		RowSetFactory factory = RowSetProvider.newFactory();
		CachedRowSet rowset = factory.createCachedRowSet();

		rowset.populate(r);
		databasemanager.DBsqlServer.cerrarConexion(c);

		return rowset;
	}

	public static void ejecutarDML(String strSQL) throws SQLException {

		Connection c = establecerConexion();
		Statement s = c.createStatement();
		s.executeUpdate(strSQL);
		cerrarConexion(c);
	}

}
