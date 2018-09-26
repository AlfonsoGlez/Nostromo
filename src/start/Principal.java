package start;

import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * @author Alfonso
 * @since 25/09/2018
 * @version 1.2
 */
public class Principal {

	public static void main(String[] args) throws IOException {
		Principal app = new Principal();
		app.inicio();
	}

	/**
	 * El metodo de inicio se encarga de leer el fichero de conexion y genera la
	 * cadena de los datos de conexion con lo leido en el fichero y muetra mensaje
	 * de error en el cara de que esto ocurra. Tambien permite arrancar la
	 * aplicacion
	 * 
	 * @throws IOException
	 */
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
