package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Ficheros {

	/**
	 * Lee el fichero con los datos de conexion a la base de datos.
	 * 
	 * @return
	 * @throws Exception
	 */
	public static List<String> cargaFicheroCFG() throws Exception {
		List<String> cfg = new ArrayList<String>();
		FileReader fch = new FileReader("Fichero.txt");
		BufferedReader b = new BufferedReader(fch);

		for (int i = 1; i <= 5; i++) {
			cfg.add(b.readLine());

		}
		b.close();
		return cfg;

	}
}
