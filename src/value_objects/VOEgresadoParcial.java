package value_objects;

import java.io.Serializable;

public class VOEgresadoParcial implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int cedula;
	private String nombre;
	private String apellido;
	
	public VOEgresadoParcial(int cedParam, String nombreParam, String apellidoParam) {
		cedula = cedParam;
		nombre = nombreParam;
		apellido = apellidoParam;
	}
	
	public int getCedula() {
		return cedula;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
}
