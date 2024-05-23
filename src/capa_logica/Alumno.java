package capa_logica;

import java.io.Serializable;

public class Alumno implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int cedula;
	private String nombre;
	private String apellido;
	private String domicilio;
	private String telefono;
	private int cantAsigAprobadas;
	private Inscripciones inscripciones;
	
	public Alumno(int cedParam, String nomParam, String apeParam, String domicParam, String telParam) {
		cedula = cedParam;
		nombre = nomParam;
		apellido = apeParam;
		domicilio = domicParam;
		telefono = telParam;
		cantAsigAprobadas = 0; //se inicializa en 0 
		inscripciones = new Inscripciones();
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
	
	public String getDomicilio() {
		return domicilio;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public int getCantAsigAprobadas() {
		return cantAsigAprobadas;
	}
	
	public String tipoAlumno() { //esta funcion debe tener un comportamiento diferente en becado, debe devolver Becado;
		return "alumno";
	}
	
	public boolean alumnoEgresado (int cantAsig) {
		return cantAsigAprobadas == cantAsig;
	}

	public Inscripciones getInscripciones () {
		return inscripciones;
	}
	
	public void aumentarAprobadas() {
		cantAsigAprobadas++;
	}
}
