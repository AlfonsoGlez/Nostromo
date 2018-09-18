package logic;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

public class LogicPrincipal {
	public static int valor;

	public static CachedRowSet consultaGenerica(String strSQL) throws SQLException {
		return databasemanager.DBsqlServer.consultaSQL(strSQL);
	}

	public static void lgConsProyecto() throws SQLException {
		logic.LogicProyecto.dbConsProyecto();

	}

}