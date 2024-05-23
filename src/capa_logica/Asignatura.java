package capa_logica;

import java.io.Serializable;

public class Asignatura implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String codigo;
	private String nombre;
	private String descripcion;
	
	//CONSTRUCTOR POR DEFECTO?
	
	public Asignatura(String codParam, String nomParam, String descParam) {
		codigo = codParam;
		nombre = nomParam;
		descripcion = descParam;
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
