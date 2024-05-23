package value_objects;

import java.io.Serializable;

public class VOAsignatura implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String codigo;
	private String nombre;
	private String descripcion;
	
	public VOAsignatura(String codigoParam, String nombreParam, String descripcionParam) {
		codigo = codigoParam;
		nombre = nombreParam;
		descripcion = descripcionParam;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
}
