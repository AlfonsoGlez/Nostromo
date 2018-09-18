package controller;

import java.util.ArrayList;
import java.util.List;

import model.Equipo;

public class CtrlEquipos {

	public static List<Equipo> lstEquipo = new ArrayList<Equipo>();
	public static List<?> tablaBid[][];
	public static int frameMode;
	public static Integer elementoSeleccionado;

	public static void inicio() {
		if (lstEquipo.isEmpty()) {

		}

		new view.FrmEquipos();

	}

	public static void borrar(int selectedIndex) {
		if (selectedIndex >= 0) {
			lstEquipo.remove(selectedIndex);
		}
	}

	/*
	 * public static void rellenaTabla() {
	 * 
	 * view.FrmEquipos.table.removeAll(); for (Trabajador t :
	 * controller.CtrlTrabajadores.lstTrabajador) {
	 * 
	 * view.FrmEquipos.table.setCellEditor(null);
	 * 
	 * for (Cargo c : model.Cargo.values());
	 * 
	 * }
	 * 
	 * }
	 */

	/*
	 * public static void rellenarTabla1() {
	 * 
	 * for (int i = 0; i <= controller.CtrlTrabajadores.lstTrabajador.size(); i++) {
	 * 
	 * //controller.CtrlTrabajadores.lstTrabajador.get(i).getNombreT();
	 * 
	 * for(int e =0; i<=model.Equipo.lstCargo.size();e++) {
	 * 
	 * view.FrmEquipos.table.setRowSelectionInterval(i, e);
	 * 
	 * }
	 * 
	 * }
	 * 
	 * }
	 */

}
