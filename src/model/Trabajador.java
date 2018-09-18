package model;

public class Trabajador {

	private String DNI;
	private String NombreT;
	private String Apellidos;
	private String Sexo;

	public Trabajador() {
		super();
	}

	public Trabajador(String Dni, String nombret, String apellidos, String sex) {
		super();
		DNI = Dni;
		NombreT = nombret;
		Apellidos = apellidos;
		Sexo = sex;

	}

	public String getDNI() {
		return DNI;
	}

	public String getNombreT() {
		return NombreT;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public void setNombreT(String nombre) {
		NombreT = nombre;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public String getSexo() {
		return Sexo;
	}

	public void setSexo(String sexo) {
		Sexo = sexo;
	}

	@Override
	public String toString() {
		return "Trabajador [getDNI()=" + getDNI() + ", getNombre()=" + getNombreT() + ", getApellidos()="
				+ getApellidos() + "]";
	}

}
