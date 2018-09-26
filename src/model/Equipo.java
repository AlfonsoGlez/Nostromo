package model;

import java.util.ArrayList;
import java.util.List;

public class Equipo {

	public static List<Trabajador> lstTrabajadores = new ArrayList<Trabajador>();

	public Equipo() {
		super();
	}

	public Equipo(List<Trabajador> lstTrabajadores) {
		super();
		Equipo.lstTrabajadores = lstTrabajadores;
	}

	public List<Trabajador> getLstTrabajadores() {
		return lstTrabajadores;
	}

	public void setLstTrabajadores(List<Trabajador> lstTrabajadores) {
		Equipo.lstTrabajadores = lstTrabajadores;
	}

	@Override
	public String toString() {
		return "Equipo [" + getLstTrabajadores() + "]";
	}

}