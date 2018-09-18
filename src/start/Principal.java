package start;

import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) throws IOException {
		Principal app = new Principal();
		app.inicio();
	}

	private void inicio() throws IOException {
		List<String> cfg = null;
		try {
			cfg = utils.Ficheros.cargaFicheroCFG();
		} catch (Exception e) {
		}
		databasemanager.DBsqlServer.crearCadenaConexion(cfg.get(0), cfg.get(1), cfg.get(2), cfg.get(3), cfg.get(4));
		if (databasemanager.DBsqlServer.testConexion()) {
			controller.CtrPrincipal.inicioApp();
		} else {

			JOptionPane.showMessageDialog(null, "No se Puede establecer conexion con el servidor.", "ERROR DE CONEXION",
					JOptionPane.ERROR_MESSAGE);

		}
	}

}
