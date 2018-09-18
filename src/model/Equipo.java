package model;

import java.util.ArrayList;
import java.util.List;

public class Equipo {

	public static List<Trabajador> lstTrabajadores = new ArrayList<Trabajador>();
	public static List<Cargo> lstCargo = new ArrayList<Cargo>();

	public Equipo() {
		super();
	}

	public Equipo(List<Trabajador> lstTrabajadores, List<Cargo> lstCargo) {
		super();
		this.lstTrabajadores = lstTrabajadores;
		this.lstCargo = lstCargo;
	}

	public List<Trabajador> getLstTrabajadores() {
		return lstTrabajadores;
	}

	public void setLstTrabajadores(List<Trabajador> lstTrabajadores) {
		this.lstTrabajadores = lstTrabajadores;
	}

	public List<Cargo> getLstCargo() {
		return lstCargo;
	}

	public void setLstCArgo(List<Cargo> lstCargo) {
		this.lstCargo = lstCargo;
	}

	@Override
	public String toString() {
		return "Equipo [" + getLstTrabajadores() + ", " + getLstCargo() + "]";
	}

}