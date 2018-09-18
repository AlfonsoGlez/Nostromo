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

	public static Connection establecerConexion() throws SQLException {
		return DriverManager.getConnection(cadenaConexion);

	}

	public static void cerrarConexion(Connection conn) throws SQLException {
		conn.close();
	}

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
