package utils;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.swing.table.DefaultTableModel;

public class Gui {

	public static DefaultTableModel generarTabla(CachedRowSet resultado) throws SQLException {

		ResultSetMetaData md = resultado.getMetaData();

		int totalCampos = md.getColumnCount();
		DefaultTableModel modelo = new DefaultTableModel();
		for (int i = 1; i <= totalCampos; i++) {
			modelo.addColumn(md.getColumnName(i));
		}

		String[] campo = new String[totalCampos];
		while (resultado.next()) {
			for (int i = 1; i <= totalCampos; i++) {
				campo[i - 1] = resultado.getString(i);
			}
			modelo.addRow(campo);
		}

		return modelo;

	}
}
