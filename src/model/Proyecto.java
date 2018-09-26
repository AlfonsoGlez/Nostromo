package model;

public class Proyecto {

	private String Nombre;
	private String Presupuesto;
	private String FechaInicio;
	private String FechaFin;

	public Proyecto() {
		super();
	}

	public Proyecto(String nombre, String presupuesto, String fechaInicio, String fechaFin) {
		super();
		Nombre = nombre;
		Presupuesto = presupuesto;
		FechaInicio = fechaInicio;
		FechaFin = fechaFin;
	}

	public String getNombre() {
		return Nombre;
	}

	public String getPresupuesto() {
		return Presupuesto;
	}

	public String getFechaInicio() {
		return FechaInicio;
	}

	public String getFechaFin() {
		return FechaFin;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public void setPresupuesto(String presupuesto) {
		Presupuesto = presupuesto;
	}

	public void setFechaInicio(String fechaInicio) {
		FechaInicio = fechaInicio;
	}

	public void setFechaFin(String fechaFin) {
		FechaFin = fechaFin;
	}

	@Override
	public String toString() {
		return Nombre + " / " + Presupuesto + " [ " + FechaInicio + " / " + FechaFin + " ] ";
	}

}
