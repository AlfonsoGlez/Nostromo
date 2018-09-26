package logic;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

import model.Proyecto;

public class LogicEquipo {

	public static String sqlEquipo;
	public static CachedRowSet consultaEquipo;
	/**
	 * Este metodo realiza la consulta sql SELECT 	a tabla equipo
	 * @throws SQLException
	 */
	public static void dbConsEquipo() throws SQLException {
		sqlEquipo = "Select  * from IP_Equipo";
		System.out.println(sqlEquipo);
		consultaEquipo = logic.LogicPrincipal.consultaGenerica(sqlEquipo);
	}
	/**
	 * Este metodo realiza la consulta sql SELECT 	a tabla proyecto
	 * @return
	 * @throws SQLException
	 */
	public static Proyecto capturarProyecto() throws SQLException {
		String strSQL = "SELECT * FROM IP_Proyecto " ;
		CachedRowSet resultado = logic.LogicPrincipal.consultaGenerica(strSQL);
		resultado.next();
		Proyecto p = new Proyecto();
		p.setNombre(resultado.getString("Nombre"));
		return p;
	}
}
