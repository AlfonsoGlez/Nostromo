package logic;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

public class LogicProyecto {

	public static String sqlProyecto;
	public static CachedRowSet consultaProyecto;

	public static void dbConsProyecto() throws SQLException {

		sqlProyecto = "SELECT*FROM AG_Proyecto";
		consultaProyecto = logic.LogicPrincipal.consultaGenerica(sqlProyecto);
	}

}
